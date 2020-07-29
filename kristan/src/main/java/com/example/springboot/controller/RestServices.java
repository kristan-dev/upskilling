package com.example.springboot.controller;

import com.example.springboot.model.Program;
import com.example.springboot.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.springboot.repository.Students;
import com.example.springboot.repository.Programs;

@RequestMapping(value = "/api")
@RestController
@Slf4j
public class RestServices {

    private Collection<Student> allStudents;
    private Collection<Program> allPrograms;

    public RestServices() {
        Students initStudentRepo = new Students();
        this.allStudents = initStudentRepo.getAllStudents();

        Programs initProgramsRepo = new Programs();
        this.allPrograms = initProgramsRepo.getAllPrograms();
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

    private Map<String, String> convertStringToMap(String stringData) {
        Map<String, String> responseObject = new HashMap<>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(stringData, Map.class);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        responseObject.put("status", "error");
        return responseObject;
    }

    @RequestMapping(method = RequestMethod.GET, value = "students", produces = "application/json")
    public ResponseEntity<String> allStudents() {
        String response = this.convertResponseToString(this.allStudents);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "programs", produces = "application/json")
    public ResponseEntity<String> allPrograms() {
        String response = this.convertResponseToString(this.allPrograms);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get", produces = "application/json")
    public ResponseEntity<String> getTest() {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "GET Method Called");
        String response = this.convertResponseToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "post", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> postTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();

        if (StringUtils.isEmpty(jsonStringInput)) {
            responseBody.put("status", "fail");
            responseBody.put("content", "empty request");

            String response = this.convertResponseToString(responseBody);
            log.info(response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        responseBody.put("status", "success");
        responseBody.put("content", jsonStringInput);

        String response = this.convertResponseToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "put", consumes = "application/json")
    public ResponseEntity<String> putTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "PUT Method Called");
        String response = this.convertResponseToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "patch", consumes = "application/json")
    public ResponseEntity<String> patchTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "PATCH Method Called");
        String response = this.convertResponseToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete", consumes = "application/json")
    public ResponseEntity<String> deltest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "Delete Method Called");
        String response = this.convertResponseToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
