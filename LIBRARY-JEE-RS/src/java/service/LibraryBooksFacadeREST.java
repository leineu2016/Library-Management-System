/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.LibraryBooks;
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
@Path("entity.librarybooks")
public class LibraryBooksFacadeREST extends AbstractFacade<LibraryBooks> {

    @PersistenceContext(unitName = "LIBRARY-JEE-RSPU")
    private EntityManager em;

    public LibraryBooksFacadeREST() {
        super(LibraryBooks.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-ADMIN"})
    public void create(LibraryBooks entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-MEMBER"})
    public void edit(@PathParam("id") String id, LibraryBooks entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed({"LIBRARY-ADMIN"})
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-ADMIN", "LIBRARY-MEMBER"})
    public LibraryBooks find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-MEMBER"})
    public List<LibraryBooks> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML})
    @RolesAllowed({"LIBRARY-ADMIN"})
    public List<LibraryBooks> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
