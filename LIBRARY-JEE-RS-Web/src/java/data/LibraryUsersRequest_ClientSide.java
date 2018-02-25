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

@XmlRootElement(name = "LibraryUsersRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class LibraryUsersRequest_ClientSide {

    @XmlElement(name = "userId", required = true)
    private int user_id;
    @XmlElement(name = "userName", required = true)
    private String user_name;
    @XmlElement(name = "userPassword", required = true)
    private String user_password;
    @XmlElement(name = "userPhoneNumber", required = true)
    private String user_phone_number;
    @XmlElement(name = "userEmailAddress", required = true)
    private String user_email_address;
    private boolean process_result;

    public LibraryUsersRequest_ClientSide() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_email_address() {
        return user_email_address;
    }

    public void setUser_email_address(String user_email_address) {
        this.user_email_address = user_email_address;
    }

    public boolean isProcess_result() {
        return process_result;
    }

    public void setProcess_result(boolean process_result) {
        this.process_result = process_result;
    }

}
