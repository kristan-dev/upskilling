package com.example.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("serializer")
public class SerializerService {
    public String convertObjectToString(Object response) {
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

    public Map<String, String> convertStringToMap(String stringData) {
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
}
