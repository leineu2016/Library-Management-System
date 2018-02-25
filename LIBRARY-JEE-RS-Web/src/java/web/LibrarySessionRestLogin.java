/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.Principal;
import javax.xml.bind.DatatypeConverter;

public class LibrarySessionRestLogin implements
        Serializable {

    private static LibrarySessionRestLogin instance;

    private LibrarySessionRestLogin() {

    }

    private Principal principal;

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public static LibrarySessionRestLogin getInstance() {
        if (instance == null) {
            instance = new LibrarySessionRestLogin();
        }
        return instance;
    }

    private String getPrincipalPassword() {

        String password = null;
        try {
            Method method = principal.getClass().getMethod("getPassword", new Class[0]);
            if (method != null) {
                char[] obj = (char[]) method.invoke(principal, new Object[0]);
                if (obj != null) {
                    password = String.valueOf(obj);
                }
            }
        } catch (Exception e) {
            System.out.println("Error getPrincipalPassword:" + e.getLocalizedMessage());
        }
        return password;
    }

    public String getRestAuth() {
        try {
            String token = principal.getName() + ":" + getPrincipalPassword();
            return "BASIC " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error getRestAuth:" + ex.getLocalizedMessage());
        }
        return null;
    }

    public String getGuestRestAuth() {
        try {
            String token = "guest:guest";
            return "BASIC " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error getRestAuth:" + ex.getLocalizedMessage());
        }
        return null;
    }
}
