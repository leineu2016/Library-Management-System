/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "LIBRARY_GROUPS")
@XmlRootElement(name = "LibraryGroups")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "LibraryGroups.findAll", query = "SELECT l FROM LibraryGroups l")
    , @NamedQuery(name = "LibraryGroups.findByGroupId", query = "SELECT l FROM LibraryGroups l WHERE l.groupId = :groupId")
    , @NamedQuery(name = "LibraryGroups.findByGroupName", query = "SELECT l FROM LibraryGroups l WHERE l.groupName = :groupName")
    , @NamedQuery(name = "LibraryGroups.findByUserName", query = "SELECT l FROM LibraryGroups l WHERE l.userName = :userName")})
public class LibraryGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GROUP_ID")
    @XmlElement(required = true)
    private Integer groupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "GROUP_NAME")
    @XmlElement(required = true)
    private String groupName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "USER_NAME")
    @XmlElement(required = true)
    private String userName;

    public LibraryGroups() {
    }

    public LibraryGroups(Integer groupId) {
        this.groupId = groupId;
    }

    public LibraryGroups(Integer groupId, String groupName, String userName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.userName = userName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibraryGroups)) {
            return false;
        }
        LibraryGroups other = (LibraryGroups) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LibraryGroups[ groupId=" + groupId + " ]";
    }

}
