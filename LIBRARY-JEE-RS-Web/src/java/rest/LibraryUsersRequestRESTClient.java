/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import data.LibraryUsersRequest_ClientSide;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import web.LibrarySessionRestLogin;

/**
 * Jersey REST client generated for REST resource:LibraryUsersRequestFacadeREST
 * [entity.libraryusersrequest]<br>
 * USAGE:
 * <pre>
 *        LibraryUsersRequestRESTClient client = new LibraryUsersRequestRESTClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 */
public class LibraryUsersRequestRESTClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/LIBRARY-JEE-RS/webresources";

    public LibraryUsersRequestRESTClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entity.libraryusersrequest");
    }

    public void create(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getGuestRestAuth()).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public List<LibraryUsersRequest_ClientSide> findAll() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).get(new GenericType<List<LibraryUsersRequest_ClientSide>>() {
        });
    }

    public void remove(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).delete();
    }

    public void close() {
        client.close();
    }

}
