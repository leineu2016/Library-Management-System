package web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named(value = "libraryLoginManagedBean")
@SessionScoped
public class LibraryLoginManagedBean
        implements Serializable {

    private static final String LOGOUT = "logout";

    public LibraryLoginManagedBean() {
    }

    public String logoutResult() {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            request.logout();
            if (request.isUserInRole("LIBRARY-ADMIN")) {
                System.out.println("Yes, user is in LIBRARY-ADMIN role");
            }
            if (request.isUserInRole("LIBRARY-MEMBER")) {
                System.out.println("Yes, user is in LIBRARY-MEMBER role");
            }
        } catch (Exception ex) {
            System.out.println("log out ...");
        }
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        return "logout";
    }

}
