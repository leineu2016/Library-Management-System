/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import web.LibrarySessionRestLogin;

/**
 * Jersey REST client generated for REST resource:LibraryUsersFacadeREST
 * [entity.libraryusers]<br>
 * USAGE:
 * <pre>
 *        LibraryUsersRESTClient client = new LibraryUsersRESTClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 */
public class LibraryUsersRESTClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/LIBRARY-JEE-RS/webresources";

    public LibraryUsersRESTClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entity.libraryusers");
    }

    public String findIdByUserName(String userName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("byUserName/{0}", new Object[]{userName}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("Authorization", LibrarySessionRestLogin.getInstance().getGuestRestAuth()).get(String.class);
    }

    public <T> T find(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).get(responseType);
    }

    public void create(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void close() {
        client.close();
    }

}
