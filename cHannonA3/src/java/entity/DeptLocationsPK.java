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
public class DeptLocationsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "dnumber")
    private int dnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dlocation")
    private String dlocation;

    public DeptLocationsPK() {
    }

    public DeptLocationsPK(int dnumber, String dlocation) {
        this.dnumber = dnumber;
        this.dlocation = dlocation;
    }

    public int getDnumber() {
        return dnumber;
    }

    public void setDnumber(int dnumber) {
        this.dnumber = dnumber;
    }

    public String getDlocation() {
        return dlocation;
    }

    public void setDlocation(String dlocation) {
        this.dlocation = dlocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dnumber;
        hash += (dlocation != null ? dlocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptLocationsPK)) {
            return false;
        }
        DeptLocationsPK other = (DeptLocationsPK) object;
        if (this.dnumber != other.dnumber) {
            return false;
        }
        if ((this.dlocation == null && other.dlocation != null) || (this.dlocation != null && !this.dlocation.equals(other.dlocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DeptLocationsPK[ dnumber=" + dnumber + ", dlocation=" + dlocation + " ]";
    }
    
}
