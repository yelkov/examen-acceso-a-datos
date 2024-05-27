package edu.badpals.examen;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.security.Provider;

@Path("/")
public class Resource {

    @Inject
    ServiceItem service;

    @GET
    @Path("itemcrudos")
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        String body = "CRUD de Items!";
        return Response.status(Response.Status.OK).entity(body).build();
    }
}
