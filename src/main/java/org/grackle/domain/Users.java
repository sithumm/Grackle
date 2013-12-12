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
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserid", query = "SELECT u FROM Users u WHERE u.userid = :userid"),
    @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findBySalt", query = "SELECT u FROM Users u WHERE u.salt = :salt"),
    @NamedQuery(name = "Users.findByIsactive", query = "SELECT u FROM Users u WHERE u.isactive = :isactive")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USERID")
    private Long userid;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "SALT")
    private String salt;
    @Basic(optional = false)
    @Column(name = "ISACTIVE")
    private short isactive;
    @OneToMany(mappedBy = "userid")
    private Collection<Workspaces> workspacesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Userroles> userrolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentuserid")
    private Collection<Users> usersCollection;
    @JoinColumn(name = "PARENTUSERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Users parentuserid;
    @OneToMany(mappedBy = "userid")
    private Collection<Profiles> profilesCollection;

    public Users() {
    }

    public Users(Long userid) {
        this.userid = userid;
    }

    public Users(Long userid, String email, String password, String salt, short isactive) {
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isactive = isactive;
    }
    
    public Users(String email, String password, String salt, short isactive) {
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isactive = isactive;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public short getIsactive() {
        return isactive;
    }

    public void setIsactive(short isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public Collection<Workspaces> getWorkspacesCollection() {
        return workspacesCollection;
    }

    public void setWorkspacesCollection(Collection<Workspaces> workspacesCollection) {
        this.workspacesCollection = workspacesCollection;
    }

    @XmlTransient
    public Collection<Userroles> getUserrolesCollection() {
        return userrolesCollection;
    }

    public void setUserrolesCollection(Collection<Userroles> userrolesCollection) {
        this.userrolesCollection = userrolesCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Users getParentuserid() {
        return parentuserid;
    }

    public void setParentuserid(Users parentuserid) {
        this.parentuserid = parentuserid;
    }

    @XmlTransient
    public Collection<Profiles> getProfilesCollection() {
        return profilesCollection;
    }

    public void setProfilesCollection(Collection<Profiles> profilesCollection) {
        this.profilesCollection = profilesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.grackle.domain.Users[ userid=" + userid + " ]";
    }
    
}
