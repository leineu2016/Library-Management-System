/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.LibraryUsersRequest;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("entity.libraryusersrequest")
public class LibraryUsersRequestFacadeREST extends AbstractFacade<LibraryUsersRequest> {

    @PersistenceContext(unitName = "LIBRARY-JEE-RSPU")
    private EntityManager em;

    public LibraryUsersRequestFacadeREST() {
        super(LibraryUsersRequest.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    public void create(LibraryUsersRequest entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-ADMIN"})
    public void edit(@PathParam("id") Integer id, LibraryUsersRequest entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed({"LIBRARY-ADMIN"})
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-ADMIN"})
    public LibraryUsersRequest find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-ADMIN"})
    public List<LibraryUsersRequest> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-ADMIN"})
    public List<LibraryUsersRequest> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"LIBRARY-ADMIN"})
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
