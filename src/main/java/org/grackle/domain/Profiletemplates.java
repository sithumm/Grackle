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
@Table(name = "PROFILETEMPLATES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profiletemplates.findAll", query = "SELECT p FROM Profiletemplates p"),
    @NamedQuery(name = "Profiletemplates.findByProfiletemplateid", query = "SELECT p FROM Profiletemplates p WHERE p.profiletemplateid = :profiletemplateid")})
public class Profiletemplates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROFILETEMPLATEID")
    private Long profiletemplateid;
    @JoinColumn(name = "TEMPLATEID", referencedColumnName = "TEMPLATEID")
    @ManyToOne(optional = false)
    private Templates templateid;
    @JoinColumn(name = "PROFILEID", referencedColumnName = "PROFILEID")
    @ManyToOne(optional = false)
    private Profiles profileid;

    public Profiletemplates() {
    }

    public Profiletemplates(Long profiletemplateid) {
        this.profiletemplateid = profiletemplateid;
    }

    public Long getProfiletemplateid() {
        return profiletemplateid;
    }

    public void setProfiletemplateid(Long profiletemplateid) {
        this.profiletemplateid = profiletemplateid;
    }

    public Templates getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Templates templateid) {
        this.templateid = templateid;
    }

    public Profiles getProfileid() {
        return profileid;
    }

    public void setProfileid(Profiles profileid) {
        this.profileid = profileid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profiletemplateid != null ? profiletemplateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profiletemplates)) {
            return false;
        }
        Profiletemplates other = (Profiletemplates) object;
        if ((this.profiletemplateid == null && other.profiletemplateid != null) || (this.profiletemplateid != null && !this.profiletemplateid.equals(other.profiletemplateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.grackle.domain.Profiletemplates[ profiletemplateid=" + profiletemplateid + " ]";
    }
    
}
