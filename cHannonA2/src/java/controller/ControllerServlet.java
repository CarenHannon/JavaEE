/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Department;
import entity.DeptLocations;
import entity.Employee;
import entity.Project;
import entity.WorksOn;
import entity.WorksOnPK;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.DepartmentFacade;
import session.EmployeeFacade;
import session.ProjectFacade;

/**
 *
 * @author Acer
 */
@WebServlet(name = "ControllerServlet", 
            loadOnStartup = 1,
            urlPatterns = {"/ShowDeps", "/ShowEmps" , "ShowProjs", "deptView", "empView", "projView"})

public class ControllerServlet extends HttpServlet {

    @PersistenceContext(unitName = "companyPU")
    private EntityManager em;
    
    @EJB
    private DepartmentFacade departmentFacade;
    @EJB
    private EmployeeFacade employeeFacade;
    @EJB
    private ProjectFacade projectFacade;

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if category page is requested
        if (userPath.equals("/ShowDeps")) {
            //get all departments
            List<Department> getdpts = departmentFacade.findAll();
            request.setAttribute("departments", getdpts);
            userPath = "/showDepartments";

        // if cart page is requested
        } else if (userPath.equals("/ShowEmps")) {
            //get all employees
            List<Employee> getemps = employeeFacade.findAll();
            request.setAttribute("employees", getemps);
            userPath = "/showEmployees";

        // if checkout page is requested
        } else if (userPath.equals("/ShowProjs")) {
            List<Project> getprojs = projectFacade.findAll();
            request.setAttribute("projects",getprojs);   
            userPath = "/showProjects";
            
        } else if (userPath.equals("/empView")) {
            String ssn = request.getParameter("ssn");
            if(ssn!=null)
            {
                
                Query q=em.createQuery("SELECT e FROM Employee e, Department d where e.ssn = :ssn and e.dno.dnumber = d.dnumber");
                q.setParameter("ssn", ssn);
                //select e from Employee.e, Department d where e.ssn = : ssn and e.dno.dnumber = d.dumber");
                List<Employee>employee = q.getResultList();
                request.setAttribute("selectedEmployee", employee);
                q = em.createQuery("SELECT p from WorksOn p where p.worksOnPK.essn = :ssn");
                q.setParameter("ssn", ssn);
                List<WorksOn>workson = q.getResultList();
                request.setAttribute("employeeProjects", workson);
            }
            userPath = "/empView";

        } else if (userPath.equals("/deptView")) {
            String dno = request.getParameter("dno");
            if(dno!=null)
            {
                
                //Department selectedDepartment = departmentFacade.find(Integer.parseInt(dno));
                //request.setAttribute("selectedDepartment", selectedDepartment);
               
                Query q = em.createQuery("Select e From Employee e, Department d where e.dno.dnumber = :dno");
                q.setParameter("dno",Integer.parseInt(dno));
                List<Employee> selectedDepartment = q.getResultList();
                request.setAttribute("selectedManager", selectedDepartment);
                
                q=em.createQuery("SELECT l From DeptLocations l where l.department.dnumber = 4");
                //q.setParameter("dno",Integer.parseInt(dno));
                //select e from Employee.e, Department d where e.ssn = : ssn and e.dno.dnumber = d.dumber");
                List<DeptLocations>deptLocation = q.getResultList();
                request.setAttribute("Location", deptLocation);
                
                q = em.createQuery("SELECT e from Employee e where e.dno.dnumber = :dno");
                q.setParameter("dno", Integer.parseInt(dno));
                List<Employee>employees = q.getResultList();
                request.setAttribute("dEmployees",employees);
                
                q = em.createQuery("Select p from Project p where p.dnum.dnumber = :dno");
                q.setParameter("dno", Integer.parseInt(dno));
                List<Project>projects = q.getResultList();
                request.setAttribute("dProjects", projects);
            }
            
            userPath = "/deptView";
        } else if (userPath.equals("/projView")) {
            
            String pno = request.getParameter("pno");
            if(pno!=null)
            {
                
                //Department selectedDepartment = departmentFacade.find(Integer.parseInt(dno));
                //request.setAttribute("selectedDepartment", selectedDepartment);
               
                Query q = em.createQuery("Select p From Project p where p.pnumber =: 1");
                //q.setParameter("pno",Integer.parseInt(pno));
                List<Project> selectedDepartment = q.getResultList();
                request.setAttribute("selectedProject", selectedDepartment);
                
                q = em.createQuery("Select e from WorksOn e where e.worksOnPK.pno = :pno");
                q.setParameter("pno",Integer.parseInt(pno));
                List<WorksOn> projectEmployee = q.getResultList();
                request.setAttribute("projEmployee", projectEmployee);
                
            }
            userPath = "/projView";
        }
        

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


