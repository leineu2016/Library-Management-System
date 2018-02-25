/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import data.LibraryBooks_ClientSide;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import web.LibrarySessionRestLogin;

/**
 * Jersey REST client generated for REST resource:LibraryBooksFacadeREST
 * [entity.librarybooks]<br>
 * USAGE:
 * <pre>
 *        LibraryBooksRESTClient client = new LibraryBooksRESTClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 */
public class LibraryBooksRESTClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/LIBRARY-JEE-RS/webresources";

    public LibraryBooksRESTClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("entity.librarybooks");
    }

    public void edit(Object requestEntity, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public <T> T find(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).get(responseType);
    }

    public List<LibraryBooks_ClientSide> findAll() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).header("Authorization", LibrarySessionRestLogin.getInstance().getRestAuth()).get(new GenericType<List<LibraryBooks_ClientSide>>() {
        });
    }

    public void close() {
        client.close();
    }

}
