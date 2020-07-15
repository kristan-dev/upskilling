package com.example.springboot;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.PATCH;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Path("/restservice")
public class RestControllers {

    @POST
    @Path("/posttest")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String posttest(String jsonInput) {
        return jsonInput;
    }

    @GET
    @Path("/gettest")
    @Produces(MediaType.APPLICATION_JSON)
    public String gettest() {
        return "This is a GET Test";
    }

    @PUT
    @Path("/puttest")
    @Produces(MediaType.APPLICATION_JSON)
    public String puttest() {
        return "This is a PUT Test";
    }

    @PATCH
    @Path("/patchtest")
    @Produces(MediaType.APPLICATION_JSON)
    public String patchtest() {
        return "This is a PATCH Test";
    }

    @DELETE
    @Path("/deltest")
    @Produces(MediaType.APPLICATION_JSON)
    public String deltest() {
        return "This is a DELETE Test";
    }
}
