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
@Table(name = "LIBRARY_USERS_REQUEST")
@XmlRootElement(name = "LibraryUsersRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "LibraryUsersRequest.findAll", query = "SELECT l FROM LibraryUsersRequest l")
    , @NamedQuery(name = "LibraryUsersRequest.findByUserId", query = "SELECT l FROM LibraryUsersRequest l WHERE l.userId = :userId")
    , @NamedQuery(name = "LibraryUsersRequest.findByUserName", query = "SELECT l FROM LibraryUsersRequest l WHERE l.userName = :userName")
    , @NamedQuery(name = "LibraryUsersRequest.findByUserPassword", query = "SELECT l FROM LibraryUsersRequest l WHERE l.userPassword = :userPassword")
    , @NamedQuery(name = "LibraryUsersRequest.findByUserPhoneNumber", query = "SELECT l FROM LibraryUsersRequest l WHERE l.userPhoneNumber = :userPhoneNumber")
    , @NamedQuery(name = "LibraryUsersRequest.findByUserEmailAddress", query = "SELECT l FROM LibraryUsersRequest l WHERE l.userEmailAddress = :userEmailAddress")})
public class LibraryUsersRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    @XmlElement(required = true)
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "USER_NAME")
    @XmlElement(required = true)
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "USER_PASSWORD")
    @XmlElement(required = true)
    private String userPassword;
    @Size(max = 10)
    @Column(name = "USER_PHONE_NUMBER")
    @XmlElement(required = true)
    private String userPhoneNumber;
    @Size(max = 32)
    @Column(name = "USER_EMAIL_ADDRESS")
    @XmlElement(required = true)
    private String userEmailAddress;

    public LibraryUsersRequest() {
    }

    public LibraryUsersRequest(Integer userId) {
        this.userId = userId;
    }

    public LibraryUsersRequest(Integer userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibraryUsersRequest)) {
            return false;
        }
        LibraryUsersRequest other = (LibraryUsersRequest) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LibraryUsersRequest[ userId=" + userId + " ]";
    }

}
