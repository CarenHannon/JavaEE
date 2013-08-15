/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entity.Employee;
import entity.WorksOn;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import session.EmployeeFacade;
import session.WorksOnFacade;

/**
 *
 * @author Acer
 */
@ManagedBean
@SessionScoped
public class empView {
    private HttpServletRequest request;
    @EJB
     EmployeeFacade employeeFacade ;
    @EJB
     WorksOnFacade worksOnFacade;
    
    private List<Employee> employee;
    private List<WorksOn> empProject;
    

    /**
     * Creates a new instance of empView
     */
    public empView() {
    }
    
    public List<Employee> getEmployee()
    {
        request = (HttpServletRequest) 
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ssn = request.getParameter("ssn");
        employee = employeeFacade.findBySSNDnumber(ssn);
        return employee;
    }
    
    public List<WorksOn> getEmpProjects()
    {
        request = (HttpServletRequest) 
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ssn = request.getParameter("ssn");
        empProject = worksOnFacade.findByPnoSSN(ssn);
        return empProject;
    }
}
