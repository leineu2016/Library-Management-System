/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import data.LibraryUsersRecords_ClientSide;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import web.LibrarySessionRestLogin;

/**
 * Jersey REST client generated for REST resource:LibraryUsersRecordsFacadeREST
 * [entity.libraryusersrecords]<br>
 * USAGE:
 * <pre>
 *        LibraryUsersRecordsRESTClient client = new LibraryUsersRecordsRESTClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 */
public class LibraryUsersRecordsRESTClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/LIBRARY-JEE-RS/webresources";

    public LibraryUsersRecordsRESTClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entity.libraryusersrecords");
    }

    public List<LibraryUsersRecords_ClientSide> findByUserId(String userId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("byUserId/{0}", new Object[]{userId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).get(new GenericType<List<LibraryUsersRecords_ClientSide>>() {
        });
    }

    public void create(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public List<LibraryUsersRecords_ClientSide> findAll() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).get(new GenericType<List<LibraryUsersRecords_ClientSide>>() {
        });
    }

    public void close() {
        client.close();
    }
}
