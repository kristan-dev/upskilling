package com.melvs.melvsboot.controller;

import com.melvs.melvsboot.model.GetListBuilder;
import com.melvs.melvsboot.repository.BusinessService;
import com.melvs.melvsboot.model.GetList;
import com.melvs.melvsboot.repository.BusinessServiceNew2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//controller rest mapping
@RestController
public class Controller {

    @Autowired
    private BusinessServiceNew2 bsn;

    @RequestMapping(method = RequestMethod.GET, value = "/NewRepo")
    public List<GetListBuilder> getmyList() {return bsn.getAllList2(); }


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(){
        return "This is a simple test SpringBoot";
    }


    //means needs another dependencies to map
    @Autowired
    private BusinessService bs;

    @RequestMapping(method = RequestMethod.GET, value = "/GetEnd")
    public List<GetList> getAllList() {
        return bs.getAllList();
        }


    @RequestMapping(method = RequestMethod.POST, value ="/PostEnd")
    public String testpost(){
        return "Sample return POST message!";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/PutEnd")
    public String testput(){return "Sample return for Put message!";}


    @RequestMapping(method = RequestMethod.PATCH, value = "/PatchEnd")
    public String testpatch(){return "Sample return for Patch message";}


    @RequestMapping(method = RequestMethod.DELETE, value = "DeleteEnd")
    public String testdelete(){return "Sample return for Delete message";}

    }
