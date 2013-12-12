/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grackle.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sithum
 */
@Entity
@Table(name = "PROFILES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profiles.findAll", query = "SELECT p FROM Profiles p"),
    @NamedQuery(name = "Profiles.findByProfileid", query = "SELECT p FROM Profiles p WHERE p.profileid = :profileid"),
    @NamedQuery(name = "Profiles.findByProfilename", query = "SELECT p FROM Profiles p WHERE p.profilename = :profilename"),
    @NamedQuery(name = "Profiles.findByDisplayname", query = "SELECT p FROM Profiles p WHERE p.displayname = :displayname"),
    @NamedQuery(name = "Profiles.findByDescription", query = "SELECT p FROM Profiles p WHERE p.description = :description"),
    @NamedQuery(name = "Profiles.findByWorkspaceid", query = "SELECT p FROM Profiles p WHERE p.workspaceid = :workspaceid")})
public class Profiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROFILEID")
    private Long profileid;
    @Basic(optional = false)
    @Column(name = "PROFILENAME")
    private String profilename;
    @Column(name = "DISPLAYNAME")
    private String displayname;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "WORKSPACEID")
    private Long workspaceid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Users userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profileid")
    private Collection<Profiletemplates> profiletemplatesCollection;

    public Profiles() {
    }

    public Profiles(Long profileid) {
        this.profileid = profileid;
    }

    public Profiles(Long profileid, String profilename) {
        this.profileid = profileid;
        this.profilename = profilename;
    }

    public Long getProfileid() {
        return profileid;
    }

    public void setProfileid(Long profileid) {
        this.profileid = profileid;
    }

    public String getProfilename() {
        return profilename;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWorkspaceid() {
        return workspaceid;
    }

    public void setWorkspaceid(Long workspaceid) {
        this.workspaceid = workspaceid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Profiletemplates> getProfiletemplatesCollection() {
        return profiletemplatesCollection;
    }

    public void setProfiletemplatesCollection(Collection<Profiletemplates> profiletemplatesCollection) {
        this.profiletemplatesCollection = profiletemplatesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileid != null ? profileid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profiles)) {
            return false;
        }
        Profiles other = (Profiles) object;
        if ((this.profileid == null && other.profileid != null) || (this.profileid != null && !this.profileid.equals(other.profileid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.grackle.domain.Profiles[ profileid=" + profileid + " ]";
    }
    
}
