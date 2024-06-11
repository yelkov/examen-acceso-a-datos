package edu.badpals.examen;

import edu.badpals.examen.domain.MagicalItem;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;
import java.security.Provider;
import java.util.List;
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

    @POST
    @Path("item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response post(MagicalItem magicalItem){
        Optional<MagicalItem> item = service.postItem(magicalItem);
        return item.isPresent()?
                Response.status(Response.Status.CREATED).entity(item).build():
                Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("items/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_items(@PathParam("name")String item_name){
        List<MagicalItem> items = service.getItems(item_name);
        return items.isEmpty()?
                Response.status(Response.Status.NOT_FOUND).build():
                Response.status(Response.Status.OK).entity(items).build();
    }


}
