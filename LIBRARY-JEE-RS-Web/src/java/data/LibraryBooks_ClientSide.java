/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LibraryBooks")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryBooks_ClientSide {

    @XmlElement(name = "bookId", required = true)
    private String book_id;
    @XmlElement(name = "bookTitle", required = true)
    private String book_title;
    @XmlElement(name = "bookAuthors", required = true)
    private String book_authors;
    @XmlElement(name = "bookPublishedDate", required = true)
    private String book_published_date;
    @XmlElement(name = "bookStatus", required = true)
    private String book_status;

    public LibraryBooks_ClientSide() {
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_authors() {
        return book_authors;
    }

    public void setBook_authors(String book_authors) {
        this.book_authors = book_authors;
    }

    public String getBook_published_date() {
        return book_published_date;
    }

    public void setBook_published_date(String book_published_date) {
        this.book_published_date = book_published_date;
    }

    public String getBook_status() {
        return book_status;
    }

    public void setBook_status(String book_status) {
        this.book_status = book_status;
    }

}
