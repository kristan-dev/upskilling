package com.kristan.jaxrsdemo.service;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kristan.jaxrsdemo.model.Student;
import org.springframework.web.bind.annotation.PatchMapping;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
public interface StudentService {

    @GET
    public Collection<Student> getAllStudents();

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id);
}
