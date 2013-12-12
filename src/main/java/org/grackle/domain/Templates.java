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
@Table(name = "TEMPLATES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Templates.findAll", query = "SELECT t FROM Templates t"),
    @NamedQuery(name = "Templates.findByTemplateid", query = "SELECT t FROM Templates t WHERE t.templateid = :templateid"),
    @NamedQuery(name = "Templates.findByTemplatename", query = "SELECT t FROM Templates t WHERE t.templatename = :templatename"),
    @NamedQuery(name = "Templates.findByDisplayname", query = "SELECT t FROM Templates t WHERE t.displayname = :displayname"),
    @NamedQuery(name = "Templates.findByDiscription", query = "SELECT t FROM Templates t WHERE t.discription = :discription"),
    @NamedQuery(name = "Templates.findByTemplateurl", query = "SELECT t FROM Templates t WHERE t.templateurl = :templateurl"),
    @NamedQuery(name = "Templates.findByIseditablebyothers", query = "SELECT t FROM Templates t WHERE t.iseditablebyothers = :iseditablebyothers"),
    @NamedQuery(name = "Templates.findByIspublic", query = "SELECT t FROM Templates t WHERE t.ispublic = :ispublic")})
public class Templates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TEMPLATEID")
    private Long templateid;
    @Basic(optional = false)
    @Column(name = "TEMPLATENAME")
    private String templatename;
    @Column(name = "DISPLAYNAME")
    private String displayname;
    @Column(name = "DISCRIPTION")
    private String discription;
    @Column(name = "TEMPLATEURL")
    private String templateurl;
    @Column(name = "ISEDITABLEBYOTHERS")
    private Short iseditablebyothers;
    @Column(name = "ISPUBLIC")
    private Short ispublic;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "templateid")
    private Collection<Profiletemplates> profiletemplatesCollection;

    public Templates() {
    }

    public Templates(Long templateid) {
        this.templateid = templateid;
    }

    public Templates(Long templateid, String templatename) {
        this.templateid = templateid;
        this.templatename = templatename;
    }

    public Long getTemplateid() {
        return templateid;
    }

    public void setTemplateid(Long templateid) {
        this.templateid = templateid;
    }

    public String getTemplatename() {
        return templatename;
    }

    public void setTemplatename(String templatename) {
        this.templatename = templatename;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getTemplateurl() {
        return templateurl;
    }

    public void setTemplateurl(String templateurl) {
        this.templateurl = templateurl;
    }

    public Short getIseditablebyothers() {
        return iseditablebyothers;
    }

    public void setIseditablebyothers(Short iseditablebyothers) {
        this.iseditablebyothers = iseditablebyothers;
    }

    public Short getIspublic() {
        return ispublic;
    }

    public void setIspublic(Short ispublic) {
        this.ispublic = ispublic;
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
        hash += (templateid != null ? templateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Templates)) {
            return false;
        }
        Templates other = (Templates) object;
        if ((this.templateid == null && other.templateid != null) || (this.templateid != null && !this.templateid.equals(other.templateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.grackle.domain.Templates[ templateid=" + templateid + " ]";
    }
    
}
