package com.melvs.melvsboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;

//controller rest mapping
@RestController
public class Controller {

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

//for POST request
    @RequestMapping(method = RequestMethod.POST, value ="/PostEnd")
    public String testpost(){
        return "Sample return POST message!";
    }

//for PUT request
    @RequestMapping(method = RequestMethod.PUT, value = "/PutEnd")
    public String testput(){return "Sample return for Put message!";
    }

//for PATCH request
    @RequestMapping(method = RequestMethod.PATCH, value = "/PatchEnd")
    public String testpatch(){return "Sample return for Patch message";}

//for DELETE request
    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteEnd")
    public String testdelete(){
        return "Sample return for Delete message";
    }

    }
