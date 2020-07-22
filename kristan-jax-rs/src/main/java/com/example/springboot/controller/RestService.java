package com.example.springboot.controller;

import com.example.springboot.repository.StudentRepository;
import com.example.springboot.model.Student;
import org.springframework.util.StringUtils;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PATCH;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import java.util.Collection;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
public class RestService {

    private Collection<Student> allStudents;

    public RestService() {
        StudentRepository students =  new StudentRepository();
        allStudents = students.getAllStudents();
    }

    @GET
    public Response getAllStudents() {
        Response response = Response.ok(allStudents).build();
        return response;
    }

    @Path("get")
    @GET
    public Response getTest() {
        System.out.println("GET method called");
        return Response.ok("GET method called")
                .build();
    }

    @Path("post")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postTest(String jsonInput) {
        if (StringUtils.isEmpty(jsonInput)) {
            return Response.ok("invalid request").build();
        }
        jsonInput = "{\n" +
                "\"json_sent\":" +
                jsonInput +
                "}";
        System.out.println("Data to be returned\n" + jsonInput);
        System.out.println("POST method called");

        return Response.ok(jsonInput)
                .build();
    }

    @Path("put")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putTest(String jsonInput) {
        System.out.println("PUT method called");
        System.out.println("Data received \n"+ jsonInput);
        return Response.ok("PUT method called")
                .build();
    }

    @Path("patch")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    public Response patchTest(String jsonInput) {
        System.out.println("PATCH method called");
        System.out.println("Data received \n"+ jsonInput);
        return Response.ok("PATCH method called")
                .build();
    }

    @Path("delete")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delTest(String jsonInput) {
        System.out.println("DELETE method called");
        System.out.println("Data received \n"+ jsonInput);
        return Response.ok("DELETE method called")
                .build();
    }

}
