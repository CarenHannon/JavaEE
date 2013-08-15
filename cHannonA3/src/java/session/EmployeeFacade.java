/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Employee;
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
public class EmployeeFacade extends AbstractFacade<Employee> {
    @PersistenceContext(unitName = "cHannonA3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }
    
    public List<Employee> findByDnumber(int dnumber) {
        Query q = em.createQuery("SELECT e FROM Employee e where e.dno.dnumber = :dnumber");
        q.setParameter("dnumber", dnumber);
        List<Employee> employees = q.getResultList();
        return employees;
    }  
    
    public List<Employee> findBySSNDnumber(String ssn) {
        Query q = em.createQuery("SELECT e FROM Employee e, Department d where e.ssn = :ssn and e.dno.dnumber = d.dnumber");
        q.setParameter("ssn", ssn);
        List<Employee> employees = q.getResultList();
        return employees;
    }  
    
}
