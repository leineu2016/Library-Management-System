package web;

import data.LibraryBooks_ClientSide;
import data.LibraryUsersRecords_ClientSide;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import rest.LibraryBooksRESTClient;
import rest.LibraryUsersRESTClient;
import rest.LibraryUsersRecordsRESTClient;

@Named(value = "libraryBooksManagedBean")
@SessionScoped
public class LibraryBooksManagedBean
        implements Serializable {

    private List lbrClientSideList;
    private List filteredLbrClientSideList;
    private String bookISBN;

    private final LibraryBooksRESTClient lbrClient;
    private final LibraryUsersRESTClient lurClient;
    private final LibraryUsersRecordsRESTClient lurrClient;

    public LibraryBooksManagedBean() {
        this.lbrClient = new LibraryBooksRESTClient();
        this.lurClient = new LibraryUsersRESTClient();
        this.lurrClient = new LibraryUsersRecordsRESTClient();
    }

    @PostConstruct
    public void init() {
        getAllBooks();
    }

    public List getLbrClientSideList() {
        return lbrClientSideList;
    }

    public void setLbrClientSideList(List lbrClientSideList) {
        this.lbrClientSideList = lbrClientSideList;
    }

    public List getFilteredLbrClientSideList() {
        return filteredLbrClientSideList;
    }

    public void setFilteredLbrClientSideList(List filteredLbrClientSideList) {
        this.filteredLbrClientSideList = filteredLbrClientSideList;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public void getAllBooks() {
        try {
            LibrarySessionRestLogin.getInstance().setPrincipal(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
            setLbrClientSideList(lbrClient.findAll());
            filteredLbrClientSideList = lbrClientSideList;
        } catch (ClientErrorException e) {
            System.out.println("Error getAllBooks:" + e.getLocalizedMessage());
        }
    }

    public String borrowBook() {
        return borrowOrReturnProcedure(true);
    }

    public String returnBook() {
        return borrowOrReturnProcedure(false);
    }

    private String borrowOrReturnProcedure(boolean isBorrow) {
        String bookStatus = "on loan";
        String recordStatus = "borrow";
        if (!isBorrow) {
            bookStatus = "available";
            recordStatus = "return";
        }

        try {
            LibrarySessionRestLogin.getInstance().setPrincipal(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
            LibraryBooks_ClientSide res = lbrClient.find(LibraryBooks_ClientSide.class, bookISBN);
            if (res == null || res.getBook_status().equals(bookStatus)) {
                return "failure";
            }

            res.setBook_status(bookStatus);
            lbrClient.edit(res, bookISBN);

            int userId = Integer.valueOf(lurClient.findIdByUserName(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName()));
            if (userId == -1) {
                return "failure";
            } else {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                String recordDate = sdf.format(date);

                LibraryUsersRecords_ClientSide request = new LibraryUsersRecords_ClientSide();
                request.setBook_id(bookISBN);
                request.setUser_id(userId);
                request.setRecord_date(recordDate);
                request.setRecord_status(recordStatus);

                lurrClient.create(request);
                return "success";
            }
        } catch (ClientErrorException e) {
            System.out.println("Error borrowOrReturnProcedure:" + e.getLocalizedMessage());
            return "failure";
        }

    }

}
