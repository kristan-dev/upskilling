package com.melvs.melvsboot.controller;

import com.melvs.melvsboot.services.BusinessService;
import com.melvs.melvsboot.model.GetList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

//controller rest mapping
@RestController
public class Controller {

    @GetMapping("/NewRepo")
    public String repo(){
        return "Sample save message!";
    }

//means needs another dependencies to map
    @Autowired
    private BusinessService bs;

//request mapping endpoint
    @RequestMapping("/")
    public String index(){
        return "This is a simple test SpringBoot";
    }


    @RequestMapping("/GetEnd")
    public List<GetList> getAllList() {
        return bs.getAllList();
        }


    @RequestMapping(method = RequestMethod.POST, value ="/PostEnd")
    public String testpost(){
        return "Sample return POST message!";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/PutEnd")
    public String testput(){return "Sample return for Put message!";
    }


    @RequestMapping(method = RequestMethod.PATCH, value = "/PatchEnd")
    public String testpatch(){return "Sample return for Patch message";}


    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteEnd")
    public String testdelete(){
        return "Sample return for Delete message";
    }

    }
