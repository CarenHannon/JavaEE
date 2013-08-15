/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Project;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Acer
 */
@Stateless
public class ProjectFacade extends AbstractFacade<Project> {
    @PersistenceContext(unitName = "cHannonA3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectFacade() {
        super(Project.class);
    }
    
      public List<Project> findByDnumber(int dnumber) {
        Query q = em.createQuery("SELECT p FROM Project p where p.dnum.dnumber = :dnumber");
        q.setParameter("dnumber", dnumber);
        List<Project> projects = q.getResultList();
        return projects;
    } 
    
    public List<Project> findByPnumberJoinWithDnumber(int pnumber) {
        Query q = em.createQuery("SELECT p FROM Project p, Department d where p.dnum.dnumber=d.dnumber and p.pnumber = :pnumber");
        q.setParameter("pnumber", pnumber);
        List<Project> projects = q.getResultList();
        return projects;
    }   
    
}
