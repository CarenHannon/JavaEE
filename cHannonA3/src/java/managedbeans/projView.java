/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entity.Project;
import entity.WorksOn;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import session.ProjectFacade;
import session.WorksOnFacade;

/**
 *
 * @author Acer
 */
@ManagedBean
@SessionScoped
public class projView {

    @EJB
    ProjectFacade projectFacade;
    @EJB
    WorksOnFacade worksOnFacade;
    private HttpServletRequest request;
    
    private List<Project> project;
    private List<WorksOn> projEmployees;
    /**
     * Creates a new instance of projView
     */
    public projView() {
    }
    
    public List<Project> getProjectInformation()
    {
        request = (HttpServletRequest) 
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String pno = request.getParameter("pno");
        project = projectFacade.findByPnumberJoinWithDnumber(Integer.parseInt(pno));
        return project;
    }
    
    public List<WorksOn> getEmpProjects()
    {
        request = (HttpServletRequest) 
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String pno = request.getParameter("pno");
        projEmployees = worksOnFacade.findByPnoJoinSSN(Integer.parseInt(pno));
        return projEmployees;
    }
}
