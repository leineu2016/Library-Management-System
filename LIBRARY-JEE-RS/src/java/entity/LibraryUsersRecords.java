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
@Table(name = "LIBRARY_USERS_RECORDS")
@XmlRootElement(name = "LibraryUsersRecords")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "LibraryUsersRecords.findAll", query = "SELECT l FROM LibraryUsersRecords l")
    , @NamedQuery(name = "LibraryUsersRecords.findByRecordId", query = "SELECT l FROM LibraryUsersRecords l WHERE l.recordId = :recordId")
    , @NamedQuery(name = "LibraryUsersRecords.findByUserId", query = "SELECT l FROM LibraryUsersRecords l WHERE l.userId = :userId")
    , @NamedQuery(name = "LibraryUsersRecords.findByBookId", query = "SELECT l FROM LibraryUsersRecords l WHERE l.bookId = :bookId")
    , @NamedQuery(name = "LibraryUsersRecords.findByRecordDate", query = "SELECT l FROM LibraryUsersRecords l WHERE l.recordDate = :recordDate")
    , @NamedQuery(name = "LibraryUsersRecords.findByRecordStatus", query = "SELECT l FROM LibraryUsersRecords l WHERE l.recordStatus = :recordStatus")})
public class LibraryUsersRecords implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RECORD_ID")
    @XmlElement(required = true)
    private Integer recordId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    @XmlElement(required = true)
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "BOOK_ID")
    @XmlElement(required = true)
    private String bookId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 19)
    @Column(name = "RECORD_DATE")
    @XmlElement(required = true)
    private String recordDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "RECORD_STATUS")
    @XmlElement(required = true)
    private String recordStatus;

    public LibraryUsersRecords() {
    }

    public LibraryUsersRecords(Integer recordId) {
        this.recordId = recordId;
    }

    public LibraryUsersRecords(Integer recordId, int userId, String bookId, String recordDate, String recordStatus) {
        this.recordId = recordId;
        this.userId = userId;
        this.bookId = bookId;
        this.recordDate = recordDate;
        this.recordStatus = recordStatus;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibraryUsersRecords)) {
            return false;
        }
        LibraryUsersRecords other = (LibraryUsersRecords) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LibraryUsersRecords[ recordId=" + recordId + " ]";
    }

}
