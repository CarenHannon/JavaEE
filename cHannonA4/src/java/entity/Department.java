/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDname", query = "SELECT d FROM Department d WHERE d.dname = :dname"),
    @NamedQuery(name = "Department.findByDnumber", query = "SELECT d FROM Department d WHERE d.dnumber = :dnumber"),
    @NamedQuery(name = "Department.findByMgrssn", query = "SELECT d FROM Department d WHERE d.mgrssn = :mgrssn"),
    @NamedQuery(name = "Department.findByMgrstartdate", query = "SELECT d FROM Department d WHERE d.mgrstartdate = :mgrstartdate")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "dname")
    private String dname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dnumber")
    private Integer dnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "mgrssn")
    private String mgrssn;
    @Column(name = "mgrstartdate")
    @Temporal(TemporalType.DATE)
    private Date mgrstartdate;

    public Department() {
    }

    public Department(Integer dnumber) {
        this.dnumber = dnumber;
    }

    public Department(Integer dnumber, String dname, String mgrssn) {
        this.dnumber = dnumber;
        this.dname = dname;
        this.mgrssn = mgrssn;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDnumber() {
        return dnumber;
    }

    public void setDnumber(Integer dnumber) {
        this.dnumber = dnumber;
    }

    public String getMgrssn() {
        return mgrssn;
    }

    public void setMgrssn(String mgrssn) {
        this.mgrssn = mgrssn;
    }

    public Date getMgrstartdate() {
        return mgrstartdate;
    }

    public void setMgrstartdate(Date mgrstartdate) {
        this.mgrstartdate = mgrstartdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnumber != null ? dnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.dnumber == null && other.dnumber != null) || (this.dnumber != null && !this.dnumber.equals(other.dnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Department[ dnumber=" + dnumber + " ]";
    }
    
}
