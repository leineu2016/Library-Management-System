package web;

import data.LibraryUsersRequest_ClientSide;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import javax.xml.bind.DatatypeConverter;
import rest.LibraryUsersRESTClient;
import rest.LibraryUsersRequestRESTClient;

@Named(value = "libraryRegistrationManagedBean")
@RequestScoped
public class LibraryRegistrationManagedBean
        implements Serializable {

    private String user_name;
    private String uesr_password;
    private String user_phone_number;
    private String user_email_address;

    private final LibraryUsersRequestRESTClient lurrClient;
    private final LibraryUsersRESTClient lurClient;

    public LibraryRegistrationManagedBean() {
        this.lurrClient = new LibraryUsersRequestRESTClient();
        this.lurClient = new LibraryUsersRESTClient();
        user_name = null;
        uesr_password = null;
        user_phone_number = null;
        user_email_address = null;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUesr_password() {
        return uesr_password;
    }

    public void setUesr_password(String uesr_password) {
        this.uesr_password = uesr_password;
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

    public String registerNewMember() {
        try {
            String userId = lurClient.findIdByUserName(user_name);
            System.out.println("userId" + userId);
            if (!userId.equals("-1")) {
                return "failure";
            }

            LibraryUsersRequest_ClientSide lurClientSide = new LibraryUsersRequest_ClientSide();
            lurClientSide.setUser_name(user_name);
            lurClientSide.setUser_password(passwordMD5(uesr_password));
            lurClientSide.setUser_phone_number(user_phone_number);
            lurClientSide.setUser_email_address(user_email_address);
            lurrClient.create(lurClientSide);
            return "success";
        } catch (ClientErrorException e) {
            System.out.println("Error registerNewMember:" + e.getLocalizedMessage());
            return "failure";
        }
    }

    private String passwordMD5(String password) {
        try {
            return DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(password.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            System.out.print((new StringBuilder()).append("cannot generate MD5:").append(password).toString());
        }
        return null;
    }
}
