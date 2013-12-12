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
@Table(name = "WORKSPACES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workspaces.findAll", query = "SELECT w FROM Workspaces w"),
    @NamedQuery(name = "Workspaces.findByWorkspaceid", query = "SELECT w FROM Workspaces w WHERE w.workspaceid = :workspaceid"),
    @NamedQuery(name = "Workspaces.findByWorkspacename", query = "SELECT w FROM Workspaces w WHERE w.workspacename = :workspacename"),
    @NamedQuery(name = "Workspaces.findByDisplayname", query = "SELECT w FROM Workspaces w WHERE w.displayname = :displayname"),
    @NamedQuery(name = "Workspaces.findByDescription", query = "SELECT w FROM Workspaces w WHERE w.description = :description")})
public class Workspaces implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WORKSPACEID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long workspaceid;
    @Basic(optional = false)
    @Column(name = "WORKSPACENAME")
    private String workspacename;
    @Column(name = "DISPLAYNAME")
    private String displayname;
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Users userid;

    public Workspaces() {
    }

    public Workspaces(Long workspaceid) {
        this.workspaceid = workspaceid;
    }

    public Workspaces(Long workspaceid, String workspacename) {
        this.workspaceid = workspaceid;
        this.workspacename = workspacename;
    }

    public Long getWorkspaceid() {
        return workspaceid;
    }

    public void setWorkspaceid(Long workspaceid) {
        this.workspaceid = workspaceid;
    }

    public String getWorkspacename() {
        return workspacename;
    }

    public void setWorkspacename(String workspacename) {
        this.workspacename = workspacename;
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

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workspaceid != null ? workspaceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workspaces)) {
            return false;
        }
        Workspaces other = (Workspaces) object;
        if ((this.workspaceid == null && other.workspaceid != null) || (this.workspaceid != null && !this.workspaceid.equals(other.workspaceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.grackle.domain.Workspaces[ workspaceid=" + workspaceid + " ]";
    }
    
}
