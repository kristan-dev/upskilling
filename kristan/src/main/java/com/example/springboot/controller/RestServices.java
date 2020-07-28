package com.example.springboot.controller;

import com.example.springboot.model.Program;
import com.example.springboot.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

import com.example.springboot.repository.Students;
import com.example.springboot.repository.Programs;

@RequestMapping(value = "/api")
@RestController
public class RestServices {

    private Collection<Student> allStudents;
    private Collection<Program> allPrograms;

    public RestServices() {
        Students initStudentRepo = new Students();
        this.allStudents = initStudentRepo.getAllStudents();

        Programs initProgramsRepo = new Programs();
        this.allPrograms = initProgramsRepo.getAllPrograms();
    }

    @RequestMapping(method = RequestMethod.GET, value = "students", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String allStudents() {
        Collection<Student> response = this.allStudents;
        String responseString = this.convertResponseToString(response);
        System.out.println(responseString);
        return responseString;
    }

    @RequestMapping(method = RequestMethod.GET, value = "programs", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String allPrograms() {
        Collection<Program> response = this.allPrograms;
        String responseString = this.convertResponseToString(response);
        System.out.println(responseString);
        return responseString;
    }

    private String convertResponseToString(Object response) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonResponse = mapper.writeValueAsString(response);
            return jsonResponse;
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Server Error";
    }

    @RequestMapping(method = RequestMethod.GET, value = "get", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String getTest() {
        System.out.println("GET method called");
        return "GET Method Called";
    }

    @RequestMapping(method = RequestMethod.POST, value = "post", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String postTest( @RequestBody String jsonStringInput) {

        if (StringUtils.isEmpty(jsonStringInput)) {
            return "invalid request";
        }
        jsonStringInput = "{\n" +
                "\"json_sent\":" +
                jsonStringInput +
                "}";
        System.out.println("Data to be returned\n" + jsonStringInput);
        System.out.println("POST method called");
        return jsonStringInput;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "put", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String puttest(@RequestBody String jsonStringInput) {
        System.out.println("Data to be Put\n"+ jsonStringInput);
        System.out.println("PUT method called");
        return jsonStringInput;
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "patch", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String patchtest(@RequestBody String jsonStringInput) {
        System.out.println("Data to be Patched\n"+ jsonStringInput);
        System.out.println("PATCH method called");
        return "PATCH method called";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String deltest(@RequestBody String jsonStringInput) {
        System.out.println("Data to be deleted\n" +jsonStringInput);
        System.out.println("DELETE method called");
        return "DELETE method Called";
    }
}
