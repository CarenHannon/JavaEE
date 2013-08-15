/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.WorksOn;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Acer
 */
@Stateless
public class WorksOnFacade extends AbstractFacade<WorksOn> {
    @PersistenceContext(unitName = "companyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WorksOnFacade() {
        super(WorksOn.class);
    }
    
}
