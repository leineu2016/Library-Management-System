package web;

import data.LibraryGroups_ClientSide;
import data.LibraryUsersRequest_ClientSide;
import data.LibraryUsers_ClientSide;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.ClientErrorException;
import rest.LibraryGroupsRESTClient;
import rest.LibraryUsersRESTClient;
import rest.LibraryUsersRequestRESTClient;

@Named(value = "libraryProcessRequestManagedBean")
@SessionScoped
public class LibraryProcessRequestManagedBean
        implements Serializable {

    private List lurrClientList;
    private List selectedLurrClientList;
    private List resultLurrClientList;

    private final LibraryUsersRequestRESTClient lurrClient;
    private final LibraryGroupsRESTClient lgrClient;
    private final LibraryUsersRESTClient lurClient;

    public LibraryProcessRequestManagedBean() {
        this.lurrClient = new LibraryUsersRequestRESTClient();
        this.lgrClient = new LibraryGroupsRESTClient();
        this.lurClient = new LibraryUsersRESTClient();
    }

    @PostConstruct
    public void init() {
        getAllMembersRequests();
    }

    public List getLurrClientList() {
        return lurrClientList;
    }

    public void setLurrClientList(List lurrClientList) {
        this.lurrClientList = lurrClientList;
    }

    public List getSelectedLurrClientList() {
        return selectedLurrClientList;
    }

    public void setSelectedLurrClientList(List selectedLurrClientList) {
        this.selectedLurrClientList = selectedLurrClientList;
    }

    public List getResultLurrClientList() {
        return resultLurrClientList;
    }

    public void setResultLurrClientList(List resultLurrClientList) {
        this.resultLurrClientList = resultLurrClientList;
    }

    public void getAllMembersRequests() {
        try {
            LibrarySessionRestLogin.getInstance().setPrincipal(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
            setLurrClientList(lurrClient.findAll());
        } catch (ClientErrorException e) {
            System.out.println("Error getAllMembersRequests:" + e.getLocalizedMessage());
        }
    }

    public String permitNewMembers() {
        LibrarySessionRestLogin.getInstance().setPrincipal(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
        resultLurrClientList = new ArrayList();
        String res = "true";
        for (Iterator iterator = selectedLurrClientList.iterator(); iterator.hasNext();) {
            LibraryUsersRequest_ClientSide lurClientSide = (LibraryUsersRequest_ClientSide) iterator.next();
            try {
                res = lgrClient.findByUserName(lurClientSide.getUser_name());
                if (res.equals("true")) {
                    lurClientSide.setProcess_result(false);
                    resultLurrClientList.add(lurClientSide);
                } else {
                    res = lurClient.findIdByUserName(lurClientSide.getUser_name());
                    if (!res.equals("-1")) {
                        lurClientSide.setProcess_result(false);
                        resultLurrClientList.add(lurClientSide);
                    } else {
                        lurClient.create(usersRequestToUsers(lurClientSide));
                        LibraryGroups_ClientSide lgClientSide = new LibraryGroups_ClientSide();
                        lgClientSide.setGroup_name("LIBRARY-MEMBER");
                        lgClientSide.setUser_name(lurClientSide.getUser_name());
                        lgrClient.create(lgClientSide);
                        lurrClient.remove(String.valueOf(lurClientSide.getUser_id()));

                        lurClientSide.setProcess_result(true);
                        resultLurrClientList.add(lurClientSide);
                        sendEmail(lurClientSide.getUser_email_address(), lurClientSide.getUser_name());
                    }
                }
            } catch (ClientErrorException e) {
                lurClientSide.setProcess_result(false);
                resultLurrClientList.add(lurClientSide);
                System.out.println("Error permitNewMembers:" + e.getLocalizedMessage());
            }
        }

        getAllMembersRequests();
        selectedLurrClientList = null;

        return "success";
    }

    private LibraryUsers_ClientSide usersRequestToUsers(LibraryUsersRequest_ClientSide request) {
        LibraryUsers_ClientSide user = new LibraryUsers_ClientSide();
        user.setUser_name(request.getUser_name());
        user.setUser_password(request.getUser_password());
        user.setUser_phone_number(request.getUser_phone_number());
        user.setUser_email_address(request.getUser_email_address());
        return user;
    }

    private void sendEmail(String email, String userName) {
        String from = "zhyj0121pp@gmail.com";
        String to = email;
        String pwd = "Zhyj0121++";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        Session session = Session.getDefaultInstance(properties);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("Library Member permitted");
            msg.setText((new StringBuilder()).append("Your library member has been permitted. You can use your user name '").append(userName).append("' with the password to login to the library system.").toString());
            Transport.send(msg, from, pwd);
        } catch (MessagingException e) {
            System.out.print((new StringBuilder()).append("Cannot Send Emails to ").append(to).toString());
        }
    }

}
