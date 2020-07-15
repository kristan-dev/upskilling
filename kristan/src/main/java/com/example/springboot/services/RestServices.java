package com.example.springboot.services;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.util.StringUtils;

@RestController
public class RestServices {

    @GetMapping(path = "/gettest", produces = "application/json")
    public String getTest() {
        System.out.println("GET method called");
        return "GET Method Called";
    }

    @PostMapping(path = "/posttest", consumes = "application/json", produces = "application/json")
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

    @PutMapping(path = "/puttest", consumes = "application/json", produces = "application/json")
    public String puttest(@RequestBody String jsonStringInput) {
        System.out.println("Data to be Put\n"+ jsonStringInput);
        System.out.println("PUT method called");
        return jsonStringInput;
    }

    @PatchMapping(path = "/patchtest", consumes = "application/json", produces = "application/json")
    public String patchtest(@RequestBody String jsonStringInput) {
        System.out.println("Data to be Patched\n"+ jsonStringInput);
        System.out.println("PATCH method called");
        return "PATCH method called";
    }

    @DeleteMapping(path = "/deltest", produces = "application/json")
    public String deltest(@RequestBody String jsonStringInput) {
        System.out.println("Data to be deleted\n" +jsonStringInput);
        System.out.println("DELETE method called");
        return "DELETE method Called";
    }
}
