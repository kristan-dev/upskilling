package com.example.springboot.controller;

import com.example.springboot.model.Program;
import com.example.springboot.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import lombok.extern.slf4j.Slf4j;

import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.springboot.repository.Students;
import com.example.springboot.repository.Programs;
import com.example.springboot.controller.SerializerService;

@RequestMapping(value = "/students")
@Controller
@Slf4j
public class StudentsController {

    private Collection<Student> allStudents;

    @Autowired
    @Qualifier("serializer")
    private SerializerService serializerService;

    public StudentsController() {
        Students initStudentRepo = new Students();
        this.allStudents = initStudentRepo.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "", produces = "application/json")
    public ResponseEntity<String> allStudents() {
        String response = serializerService.convertObjectToString(this.allStudents);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "get", produces = "application/json")
    public ResponseEntity<String> getTest() {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "GET Method Called");
        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "post", produces = "application/json", consumes = "application/json")
    public ResponseEntity<String> postTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();

        if (StringUtils.isEmpty(jsonStringInput)) {
            responseBody.put("status", "fail");
            responseBody.put("content", "empty request");

            String response = serializerService.convertObjectToString(responseBody);
            log.info(response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        responseBody.put("status", "success");
        responseBody.put("content", jsonStringInput);

        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "put", consumes = "application/json")
    public ResponseEntity<String> putTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "PUT Method Called");
        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "patch", consumes = "application/json")
    public ResponseEntity<String> patchTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "PATCH Method Called");
        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete", consumes = "application/json")
    public ResponseEntity<String> deltest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "Delete Method Called");
        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
