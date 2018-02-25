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

@XmlRootElement(name = "LibraryUsersRecords")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryUsersRecords_ClientSide {

    @XmlElement(name = "recordId", required = true)
    private int record_id;
    @XmlElement(name = "userId", required = true)
    private int user_id;
    @XmlElement(name = "bookId", required = true)
    private String book_id;
    @XmlElement(name = "recordDate", required = true)
    private String record_date;
    @XmlElement(name = "recordStatus", required = true)
    private String record_status;

    public LibraryUsersRecords_ClientSide() {
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getRecord_date() {
        return record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    public String getRecord_status() {
        return record_status;
    }

    public void setRecord_status(String record_status) {
        this.record_status = record_status;
    }

}
