package com.example.springboot.controller;

import com.example.springboot.controller.SerializerService;
import com.example.springboot.model.Program;
import com.example.springboot.repository.Programs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/programs")
@RestController
@Slf4j
public class ProgramsController {

    @Autowired
    @Qualifier("serializer")
    private SerializerService serializerService;

    private Collection<Program> allPrograms;

    public ProgramsController(){
        Programs initProgramsRepo = new Programs();
        this.allPrograms = initProgramsRepo.getAllPrograms();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String allPrograms() {
        String response = serializerService.convertObjectToString(this.allPrograms);
        log.info(response);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "get", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String getTest() {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "GET Method Called");
        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "post", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String postTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();

        if (StringUtils.isEmpty(jsonStringInput)) {
            responseBody.put("status", "fail");
            responseBody.put("content", "empty request");

            String response = serializerService.convertObjectToString(responseBody);
            log.info(response);
            return response;
        }

        responseBody.put("status", "success");
        responseBody.put("content", jsonStringInput);

        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return response;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "put", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String putTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "PUT Method Called");
        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return response;
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "patch", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String patchTest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "PATCH Method Called");
        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String deltest(@RequestBody String jsonStringInput) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("content", "Delete Method Called");
        String response = serializerService.convertObjectToString(responseBody);
        log.info(response);
        return response;
    }

}
