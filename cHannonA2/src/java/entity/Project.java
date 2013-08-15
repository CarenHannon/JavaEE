/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByPname", query = "SELECT p FROM Project p WHERE p.pname = :pname"),
    @NamedQuery(name = "Project.findByPnumber", query = "SELECT p FROM Project p WHERE p.pnumber = :pnumber"),
    @NamedQuery(name = "Project.findByPlocation", query = "SELECT p FROM Project p WHERE p.plocation = :plocation")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "pname")
    private String pname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pnumber")
    private Integer pnumber;
    @Size(max = 15)
    @Column(name = "plocation")
    private String plocation;
    @JoinColumn(name = "dnum", referencedColumnName = "dnumber")
    @ManyToOne(optional = false)
    private Department dnum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Collection<WorksOn> worksOnCollection;

    public Project() {
    }

    public Project(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Project(Integer pnumber, String pname) {
        this.pnumber = pnumber;
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public String getPlocation() {
        return plocation;
    }

    public void setPlocation(String plocation) {
        this.plocation = plocation;
    }

    public Department getDnum() {
        return dnum;
    }

    public void setDnum(Department dnum) {
        this.dnum = dnum;
    }

    @XmlTransient
    public Collection<WorksOn> getWorksOnCollection() {
        return worksOnCollection;
    }

    public void setWorksOnCollection(Collection<WorksOn> worksOnCollection) {
        this.worksOnCollection = worksOnCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pnumber != null ? pnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.pnumber == null && other.pnumber != null) || (this.pnumber != null && !this.pnumber.equals(other.pnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Project[ pnumber=" + pnumber + " ]";
    }
    
}
