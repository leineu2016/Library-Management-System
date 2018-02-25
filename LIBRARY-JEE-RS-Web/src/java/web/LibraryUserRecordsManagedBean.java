package web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import rest.LibraryUsersRESTClient;
import rest.LibraryUsersRecordsRESTClient;

@Named(value = "libraryUserRecordsManagedBean")
@SessionScoped
public class LibraryUserRecordsManagedBean
        implements Serializable {

    private List lurrClientSideList;
    private List filteredLurrClientSideList;

    private final LibraryUsersRecordsRESTClient lurrClient;
    private final LibraryUsersRESTClient lurClient;

    public LibraryUserRecordsManagedBean() {
        this.lurrClient = new LibraryUsersRecordsRESTClient();
        this.lurClient = new LibraryUsersRESTClient();
    }

    @PostConstruct
    public void init() {
        getMembersRecords();
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

    private void getMembersRecords() {
        try {
            LibrarySessionRestLogin.getInstance().setPrincipal(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal());
            String userId = lurClient.findIdByUserName(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName());
            setLurrClientSideList(lurrClient.findByUserId(userId));
            filteredLurrClientSideList = lurrClientSideList;
        } catch (ClientErrorException e) {
            System.out.println("Error getMembersRecords:" + e.getLocalizedMessage());
        }

    }

}
