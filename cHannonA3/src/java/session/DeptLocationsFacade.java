/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.DeptLocations;
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
public class DeptLocationsFacade extends AbstractFacade<DeptLocations> {
    @PersistenceContext(unitName = "cHannonA3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeptLocationsFacade() {
        super(DeptLocations.class);
    }
    
      public List<DeptLocations> findByDnumber(int dnumber) {
        Query q = em.createNamedQuery("DeptLocations.findByDnumber");
        q.setParameter("dnumber", dnumber);
        List<DeptLocations> deptLocations = q.getResultList();
        return deptLocations;
    }    
    
}
