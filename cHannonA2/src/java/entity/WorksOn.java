/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "works_on")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorksOn.findAll", query = "SELECT w FROM WorksOn w"),
    @NamedQuery(name = "WorksOn.findByEssn", query = "SELECT w FROM WorksOn w WHERE w.worksOnPK.essn = :essn"),
    @NamedQuery(name = "WorksOn.findByPno", query = "SELECT w FROM WorksOn w WHERE w.worksOnPK.pno = :pno"),
    @NamedQuery(name = "WorksOn.findByHours", query = "SELECT w FROM WorksOn w WHERE w.hours = :hours")})
public class WorksOn implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WorksOnPK worksOnPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "hours")
    private BigDecimal hours;
    @JoinColumn(name = "pno", referencedColumnName = "pnumber", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;
    @JoinColumn(name = "essn", referencedColumnName = "ssn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public WorksOn() {
    }

    public WorksOn(WorksOnPK worksOnPK) {
        this.worksOnPK = worksOnPK;
    }

    public WorksOn(String essn, int pno) {
        this.worksOnPK = new WorksOnPK(essn, pno);
    }

    public WorksOnPK getWorksOnPK() {
        return worksOnPK;
    }

    public void setWorksOnPK(WorksOnPK worksOnPK) {
        this.worksOnPK = worksOnPK;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (worksOnPK != null ? worksOnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorksOn)) {
            return false;
        }
        WorksOn other = (WorksOn) object;
        if ((this.worksOnPK == null && other.worksOnPK != null) || (this.worksOnPK != null && !this.worksOnPK.equals(other.worksOnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WorksOn[ worksOnPK=" + worksOnPK + " ]";
    }
    
}
