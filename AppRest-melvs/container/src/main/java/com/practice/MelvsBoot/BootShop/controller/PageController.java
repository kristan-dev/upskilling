package com.practice.MelvsBoot.BootShop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.MelvsBoot.BootShop.model.Accessories;
import com.practice.MelvsBoot.BootShop.model.MyBike;
import com.practice.MelvsBoot.BootShop.repository.MyAccessoriesService;
import com.practice.MelvsBoot.BootShop.repository.MyBikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;


@RestController
public class PageController {

    MyBikeService mybike = new MyBikeService();
    @RequestMapping(method = RequestMethod.GET, value = "/Bike")
    @ResponseStatus(HttpStatus.OK)
    public List<MyBike> getAllList() {
        return mybike.getBikeList();
    }

    private Collection<Accessories> allaccessories;
    public PageController(){
        MyAccessoriesService acrepo = new MyAccessoriesService();
        this.allaccessories = acrepo.getAcc();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/Accessories")
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
    @ResponseStatus(HttpStatus.OK)
    public String index(){
        return "This is a simple test SpringBoot";
    }

    @RequestMapping(method = RequestMethod.POST, value ="/PostEnd")
    @ResponseStatus(HttpStatus.OK)
    public String testpost(){
        return "Sample return POST message!";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/PutEnd")
    @ResponseStatus(HttpStatus.OK)
    public String testput(){
        return "Sample return for Put message!";
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/PatchEnd")
    @ResponseStatus(HttpStatus.OK)
    public String testpatch(){
        return "Sample return for Patch message";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteEnd")
    @ResponseStatus(HttpStatus.OK)
    public String testdelete(){
        return "Sample return for Delete message";
    }

}
