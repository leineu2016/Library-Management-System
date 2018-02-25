package web;

import data.LibraryBooks_ClientSide;
import data.LibraryUsersRecords_ClientSide;
import data.LibraryUsers_ClientSide;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import rest.LibraryBooksRESTClient;
import rest.LibraryUsersRESTClient;
import rest.LibraryUsersRecordsRESTClient;

@Named(value = "libraryUsersRecordsManagedBean")
@SessionScoped
public class LibraryUsersRecordsManagedBean
        implements Serializable {

    private List lurrClientSideList;
    private List filteredLurrClientSideList;
    private LibraryUsersRecords_ClientSide selectedlurrClientSide;
    private LibraryUsers_ClientSide selectedlurClientSide;
    private LibraryBooks_ClientSide selectedlbrClientSide;

    private final LibraryUsersRecordsRESTClient lurrClient;
    private final LibraryBooksRESTClient lbrClient;
    private final LibraryUsersRESTClient lurClient;

    @PostConstruct
    public void init() {
        getAllMembersRecords();
    }

    public LibraryUsersRecordsManagedBean() {
        this.lurrClient = new LibraryUsersRecordsRESTClient();
        this.lbrClient = new LibraryBooksRESTClient();
        this.lurClient = new LibraryUsersRESTClient();
    }

    public List getLurrClientSideList() {
        return lurrClientSideList;
    }

    public void setLurrClientSideList(List lurrClientSideList) {
        this.lurrClientSideList = lurrClientSideList;
    }

    public List getFilteredLurrClientSideList() {
        return filteredLurrClientSideList;
    }

    public void setFilteredLurrClientSideList(List filteredLurrClientSideList) {
        this.filteredLurrClientSideList = filteredLurrClientSideList;
    }

    public LibraryUsersRecords_ClientSide getSelectedlurrClientSide() {
        return selectedlurrClientSide;
    }

    public void setSelectedlurrClientSide(LibraryUsersRecords_ClientSide selectedlurrClientSide) {
        this.selectedlurrClientSide = selectedlurrClientSide;
    }

    public LibraryUsers_ClientSide getSelectedlurClientSide() {
        return selectedlurClientSide;
    }

    public void setSelectedlurClientSide(LibraryUsers_ClientSide selectedlurClientSide) {
        this.selectedlurClientSide = selectedlurClientSide;
    }

    public LibraryBooks_ClientSide getSelectedlbrClientSide() {
        return selectedlbrClientSide;
    }

    public void setSelectedlbrClientSide(LibraryBooks_ClientSide selectedlbrClientSide) {
        this.selectedlbrClientSide = selectedlbrClientSide;
    }

    public void getAllMembersRecords() {
        try {
            LibrarySessionRestLogin.getInstance().setPrincipal(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
            setLurrClientSideList(lurrClient.findAll());
            filteredLurrClientSideList = lurrClientSideList;
        } catch (ClientErrorException e) {
            System.out.println("Error getAllMembersRecords:" + e.getLocalizedMessage());
        }
    }

    public void retrieveSelectedDetails() {
        try {
            LibrarySessionRestLogin.getInstance().setPrincipal(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
            setSelectedlbrClientSide(lbrClient.find(LibraryBooks_ClientSide.class, selectedlurrClientSide.getBook_id()));
            setSelectedlurClientSide(lurClient.find(LibraryUsers_ClientSide.class, String.valueOf(selectedlurrClientSide.getUser_id())));
        } catch (ClientErrorException e) {
            System.out.println("Error retrieveSelectedDetails:" + e.getLocalizedMessage());
        }

    }
}
