/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Department;
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
public class DepartmentFacade extends AbstractFacade<Department> {
    @PersistenceContext(unitName = "cHannonA3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartmentFacade() {
        super(Department.class);
    }
    
    public List<Department> findByDnumber(int dnumber) {
        Query q = em.createNamedQuery("Department.findByDnumber");
        q.setParameter("dnumber", dnumber);
        List<Department> selectedDepartment = q.getResultList();
        return selectedDepartment;
    }    
    
    
    
}
