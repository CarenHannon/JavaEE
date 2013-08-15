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
public class WorksOnPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "essn")
    private String essn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pno")
    private int pno;

    public WorksOnPK() {
    }

    public WorksOnPK(String essn, int pno) {
        this.essn = essn;
        this.pno = pno;
    }

    public String getEssn() {
        return essn;
    }

    public void setEssn(String essn) {
        this.essn = essn;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (essn != null ? essn.hashCode() : 0);
        hash += (int) pno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorksOnPK)) {
            return false;
        }
        WorksOnPK other = (WorksOnPK) object;
        if ((this.essn == null && other.essn != null) || (this.essn != null && !this.essn.equals(other.essn))) {
            return false;
        }
        if (this.pno != other.pno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.WorksOnPK[ essn=" + essn + ", pno=" + pno + " ]";
    }
    
}
