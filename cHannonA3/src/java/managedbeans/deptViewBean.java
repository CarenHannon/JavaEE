/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entity.DeptLocations;
import entity.Employee;
import entity.Department;
import entity.Project;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import session.DepartmentFacade;
import session.DeptLocationsFacade;
import session.EmployeeFacade;
import session.ProjectFacade;

/**
 *
 * @author Acer
 */
@ManagedBean
@SessionScoped
public class deptViewBean {
    private HttpServletRequest request;
    
     @EJB
    private DeptLocationsFacade deptLocationsFacade;
     @EJB
    private EmployeeFacade employeeFacade;
     @EJB
    private DepartmentFacade departmentFacade;
     @EJB
    private ProjectFacade projectFacade;
     
     
    private List<Project> deptProjects;
    private List<Employee> deptEmployees;
    private List<DeptLocations> deptLocations;
    private List<Department> deptInfo;
    private Employee manager;

    /**
     * Creates a new instance of deptViewBean
     */
    public deptViewBean() {
    }
    
    public List<DeptLocations> getDeptLocations(){
        request = (HttpServletRequest) 
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String dno = request.getParameter("dno");
        deptLocations = deptLocationsFacade.findByDnumber(Integer.parseInt(dno));
        return deptLocations;
    }
    
    //employees in department
    public List<Employee> getDeptEmployees(){
         request = (HttpServletRequest) 
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String dno = request.getParameter("dno");
        deptEmployees = employeeFacade.findByDnumber(Integer.parseInt(dno));
        return deptEmployees;
        
        
    }
    
    public List<Department> getDeptManager(){
        request = (HttpServletRequest) 
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String dno = request.getParameter("dno");
        deptInfo = departmentFacade.findByDnumber(Integer.parseInt(dno));
        
        return deptInfo;
    }
    
    public Employee getManager()
    {
        return employeeFacade.findBySSNDnumber(deptInfo.get(0).getMgrssn()).get(0);
    }
    
    public List<Project> getDeptProjects(){
        request = (HttpServletRequest) 
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String dno = request.getParameter("dno");
        deptProjects = projectFacade.findByDnumber(Integer.parseInt(dno));
        return deptProjects;
    }
}
