/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.DeptLocations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Acer
 */
@Stateless
public class DeptLocationsFacade extends AbstractFacade<DeptLocations> {
    @PersistenceContext(unitName = "companyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DeptLocationsFacade() {
        super(DeptLocations.class);
    }
    
}
