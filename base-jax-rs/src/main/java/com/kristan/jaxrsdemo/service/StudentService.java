package com.kristan.jaxrsdemo.service;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kristan.jaxrsdemo.model.Student;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
interface StudentService {

    @GET
    public Collection<Student> getAllStudents();

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id);
}
