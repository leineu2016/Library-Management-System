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
@Table(name = "LIBRARY_BOOKS")
@XmlRootElement(name = "LibraryBooks")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "LibraryBooks.findAll", query = "SELECT l FROM LibraryBooks l")
    , @NamedQuery(name = "LibraryBooks.findByBookId", query = "SELECT l FROM LibraryBooks l WHERE l.bookId = :bookId")
    , @NamedQuery(name = "LibraryBooks.findByBookTitle", query = "SELECT l FROM LibraryBooks l WHERE l.bookTitle = :bookTitle")
    , @NamedQuery(name = "LibraryBooks.findByBookAuthors", query = "SELECT l FROM LibraryBooks l WHERE l.bookAuthors = :bookAuthors")
    , @NamedQuery(name = "LibraryBooks.findByBookPublishedDate", query = "SELECT l FROM LibraryBooks l WHERE l.bookPublishedDate = :bookPublishedDate")
    , @NamedQuery(name = "LibraryBooks.findByBookStatus", query = "SELECT l FROM LibraryBooks l WHERE l.bookStatus = :bookStatus")})
public class LibraryBooks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "BOOK_ID")
    @XmlElement(required = true)
    private String bookId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "BOOK_TITLE")
    @XmlElement(required = true)
    private String bookTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "BOOK_AUTHORS")
    @XmlElement(required = true)
    private String bookAuthors;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BOOK_PUBLISHED_DATE")
    @XmlElement(required = true)
    private String bookPublishedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "BOOK_STATUS")
    @XmlElement(required = true)
    private String bookStatus;

    public LibraryBooks() {
    }

    public LibraryBooks(String bookId) {
        this.bookId = bookId;
    }

    public LibraryBooks(String bookId, String bookTitle, String bookAuthors, String bookPublishedDate, String bookStatus) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthors = bookAuthors;
        this.bookPublishedDate = bookPublishedDate;
        this.bookStatus = bookStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public String getBookPublishedDate() {
        return bookPublishedDate;
    }

    public void setBookPublishedDate(String bookPublishedDate) {
        this.bookPublishedDate = bookPublishedDate;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibraryBooks)) {
            return false;
        }
        LibraryBooks other = (LibraryBooks) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LibraryBooks[ bookId=" + bookId + " ]";
    }

}
