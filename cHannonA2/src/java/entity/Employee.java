/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByFname", query = "SELECT e FROM Employee e WHERE e.fname = :fname"),
    @NamedQuery(name = "Employee.findByMinit", query = "SELECT e FROM Employee e WHERE e.minit = :minit"),
    @NamedQuery(name = "Employee.findByLname", query = "SELECT e FROM Employee e WHERE e.lname = :lname"),
    @NamedQuery(name = "Employee.findBySsn", query = "SELECT e FROM Employee e WHERE e.ssn = :ssn"),
    @NamedQuery(name = "Employee.findByBdate", query = "SELECT e FROM Employee e WHERE e.bdate = :bdate"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findBySex", query = "SELECT e FROM Employee e WHERE e.sex = :sex"),
    @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary"),
    @NamedQuery(name = "Employee.findBySuperssn", query = "SELECT e FROM Employee e WHERE e.superssn = :superssn")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "fname")
    private String fname;
    @Size(max = 1)
    @Column(name = "minit")
    private String minit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "lname")
    private String lname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ssn")
    private String ssn;
    @Column(name = "bdate")
    @Temporal(TemporalType.DATE)
    private Date bdate;
    @Size(max = 50)
    @Column(name = "address")
    private String address;
    @Column(name = "sex")
    private Character sex;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salary")
    private BigDecimal salary;
    @Size(max = 9)
    @Column(name = "superssn")
    private String superssn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<WorksOn> worksOnCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Dependent> dependentCollection;
    @JoinColumn(name = "dno", referencedColumnName = "dnumber")
    @ManyToOne
    private Department dno;

    public Employee() {
    }

    public Employee(String ssn) {
        this.ssn = ssn;
    }

    public Employee(String ssn, String fname, String lname) {
        this.ssn = ssn;
        this.fname = fname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getSuperssn() {
        return superssn;
    }

    public void setSuperssn(String superssn) {
        this.superssn = superssn;
    }

    @XmlTransient
    public Collection<WorksOn> getWorksOnCollection() {
        return worksOnCollection;
    }

    public void setWorksOnCollection(Collection<WorksOn> worksOnCollection) {
        this.worksOnCollection = worksOnCollection;
    }

    @XmlTransient
    public Collection<Dependent> getDependentCollection() {
        return dependentCollection;
    }

    public void setDependentCollection(Collection<Dependent> dependentCollection) {
        this.dependentCollection = dependentCollection;
    }

    public Department getDno() {
        return dno;
    }

    public void setDno(Department dno) {
        this.dno = dno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ssn != null ? ssn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.ssn == null && other.ssn != null) || (this.ssn != null && !this.ssn.equals(other.ssn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employee[ ssn=" + ssn + " ]";
    }
    
}
