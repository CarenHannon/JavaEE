package managedbeans;

import entity.Department;
import entity.Employee;
import entity.Project;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import session.DepartmentFacade;
import session.EmployeeFacade;
import session.ProjectFacade;

/**
 *
 * @author your name
 */
@ManagedBean(name = "companyBean")
@SessionScoped
public class CompanyBean {

    private List<Department> departments;
    private List<Employee> employees;
    private List<Project> projects;
    
    @EJB
    private DepartmentFacade departmentFacade;
    @EJB
    private EmployeeFacade employeeFacade;
    @EJB
    private ProjectFacade projectFacade;
    
    public CompanyBean() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    public List<Department> getDepartments() {
        departments = departmentFacade.findAll();
        return departments;
    }

    public List<Employee> getEmployees() {
        employees = employeeFacade.findAll();
        return employees;
    }

    public List<Project> getProjects() {
        projects = projectFacade.findAll();
        return projects;
    }  
    
}