package edu.badpals.examen;

import edu.badpals.examen.domain.MagicalItem;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.security.Provider;
import java.util.Optional;

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

    @GET
    @Path("item/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response itemByName(@PathParam("name")String item_name){
        Optional<MagicalItem> item = service.getItem(item_name);
        return item.isPresent()?
                Response.status(Response.Status.OK).entity(item).build():
                Response.status(Response.Status.NOT_FOUND).build();

    }

}
