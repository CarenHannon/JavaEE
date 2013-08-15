/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WorksOn;
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
public class WorksOnFacade extends AbstractFacade<WorksOn> {
    @PersistenceContext(unitName = "cHannonA3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorksOnFacade() {
        super(WorksOn.class);
    }
    
    public List<WorksOn> findByPnoSSN(String ssn) {
        Query q = em.createQuery("SELECT w FROM WorksOn w, Project p where w.worksOnPK.pno = p.pnumber and w.worksOnPK.essn = :ssn ");
        q.setParameter("ssn", ssn);
        List<WorksOn> worksons = q.getResultList();
        return worksons;
    } 
    
    public List<WorksOn> findByPnoJoinSSN(int pno) {
        Query q = em.createQuery("SELECT w FROM WorksOn w, Employee e where  w.worksOnPK.essn = e.ssn and w.worksOnPK.pno = :pno");
        q.setParameter("pno", pno);
        List<WorksOn> worksons = q.getResultList();
        return worksons;
    } 
    
}
