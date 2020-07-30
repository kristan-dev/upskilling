package com.practice.MelvsBoot.BootShop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.MelvsBoot.BootShop.model.Accessories;
import com.practice.MelvsBoot.BootShop.model.MyBike;
import com.practice.MelvsBoot.BootShop.repository.MyAccessoriesService;
import com.practice.MelvsBoot.BootShop.repository.MyBikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/page")
public class PageController {

    MyBikeService mybike = new MyBikeService();
    @RequestMapping(method = RequestMethod.GET, value = "/bikes")
    @ResponseStatus(HttpStatus.OK)
    public List<MyBike> getAllList() {
        return mybike.getBikeList();
    }

    private Collection<Accessories> allaccessories;
    public PageController(){
        MyAccessoriesService acrepo = new MyAccessoriesService();
        this.allaccessories = acrepo.getAcc();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/accessories")
    @ResponseStatus(HttpStatus.OK)
    public String allaccesories(){
        Collection<Accessories> response = this.allaccessories;
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

    @RequestMapping(method = RequestMethod.GET, value = "/")
    ResponseEntity<String> index () {
        return new ResponseEntity<>("This is a simple Spring Boot Application", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value ="/postEnd", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> postend (){
        return new ResponseEntity<>("This is a sample message for Post Request", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/putEnd")
    ResponseEntity<String> putend (){
        return new ResponseEntity<>("This is a sample message for Put Request", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/patchEnd")
    ResponseEntity<String> patchend (){
        return new ResponseEntity<>("This is a sample message for Patch Request", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteEnd")
    ResponseEntity<String> deleteend (){
        return new ResponseEntity<>("This is a sample message for Delete Request", HttpStatus.OK);
    }

}
