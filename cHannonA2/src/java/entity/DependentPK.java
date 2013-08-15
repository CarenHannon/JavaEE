/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Acer
 */
@Embeddable
public class DependentPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "essn")
    private String essn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dependent_name")
    private String dependentName;

    public DependentPK() {
    }

    public DependentPK(String essn, String dependentName) {
        this.essn = essn;
        this.dependentName = dependentName;
    }

    public String getEssn() {
        return essn;
    }

    public void setEssn(String essn) {
        this.essn = essn;
    }

    public String getDependentName() {
        return dependentName;
    }

    public void setDependentName(String dependentName) {
        this.dependentName = dependentName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (essn != null ? essn.hashCode() : 0);
        hash += (dependentName != null ? dependentName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DependentPK)) {
            return false;
        }
        DependentPK other = (DependentPK) object;
        if ((this.essn == null && other.essn != null) || (this.essn != null && !this.essn.equals(other.essn))) {
            return false;
        }
        if ((this.dependentName == null && other.dependentName != null) || (this.dependentName != null && !this.dependentName.equals(other.dependentName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DependentPK[ essn=" + essn + ", dependentName=" + dependentName + " ]";
    }
    
}
