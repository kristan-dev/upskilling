package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.ws.rs.core.Response;
import java.util.LinkedList;

public class RestService implements RestInterface {

    @Autowired
    private LinkedList<String> allStudents;

    @Override
    public Response getAllStudents() {
        String students = this.allStudents.toString();
        System.out.println(students);

        return Response.ok(students)
                .status(200)
                .build();
    }

    @Override
    public Response getTest() {
        System.out.println("GET method called");
        return Response.ok("GET method called")
                .build();
    }

    @Override
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

    @Override
    public Response putTest(String jsonInput) {
        System.out.println("PUT method called");
        System.out.println("Data received \n"+ jsonInput);
        return Response.ok("PUT method called")
                .build();
    }


    @Override
    public Response patchTest(String jsonInput) {
        System.out.println("PATCH method called");
        System.out.println("Data received \n"+ jsonInput);
        return Response.ok("PATCH method called")
                .build();
    }

    @Override
    public Response delTest(String jsonInput) {
        System.out.println("DELETE method called");
        System.out.println("Data received \n"+ jsonInput);
        return Response.ok("DELETE method called")
                .build();
    }

}
