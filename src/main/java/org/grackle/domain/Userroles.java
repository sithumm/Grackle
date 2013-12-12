/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grackle.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sithum
 */
@Entity
@Table(name = "USERROLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userroles.findAll", query = "SELECT u FROM Userroles u"),
    @NamedQuery(name = "Userroles.findByUserroleid", query = "SELECT u FROM Userroles u WHERE u.userroleid = :userroleid")})
public class Userroles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERROLEID")
    private Long userroleid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Users userid;
    @JoinColumn(name = "ROLEID", referencedColumnName = "ROLEID")
    @ManyToOne(optional = false)
    private Roles roleid;

    public Userroles() {
    }

    public Userroles(Long userroleid) {
        this.userroleid = userroleid;
    }

    public Long getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(Long userroleid) {
        this.userroleid = userroleid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    public Roles getRoleid() {
        return roleid;
    }

    public void setRoleid(Roles roleid) {
        this.roleid = roleid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userroleid != null ? userroleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userroles)) {
            return false;
        }
        Userroles other = (Userroles) object;
        if ((this.userroleid == null && other.userroleid != null) || (this.userroleid != null && !this.userroleid.equals(other.userroleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.grackle.domain.Userroles[ userroleid=" + userroleid + " ]";
    }
    
}
