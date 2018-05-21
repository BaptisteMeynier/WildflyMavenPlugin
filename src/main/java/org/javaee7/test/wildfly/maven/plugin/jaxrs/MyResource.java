package org.javaee7.test.wildfly.maven.plugin.jaxrs;


import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/fruit")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    @GET
    public String get() {
        System.out.println("GET");
        return Database.getAll();
    }

    @GET
    @Path("{name}")
    public String get(@PathParam("name") String payload) {
        System.out.println("GET");
        return Database.get(payload);
    }

    @POST
    public void post(String payload) {
        System.out.println("POST");
        Database.add(payload);
    }

    @PUT
    public void put(String payload) {
        System.out.println("PUT");
        Database.add(payload);
    }

    @DELETE
    @Path("{name}")
    public void delete(@PathParam("name") String payload) {
        System.out.println("DELETE");
        Database.delete(payload);
    }
}