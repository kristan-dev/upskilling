package com.practice.MelvsBoot.BootShop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.MelvsBoot.BootShop.model.Accessories;
import com.practice.MelvsBoot.BootShop.model.MyBike;
import com.practice.MelvsBoot.BootShop.repository.MyAccessoriesService;
import com.practice.MelvsBoot.BootShop.repository.MyBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/page")
public class PageController {

    private Collection<Accessories> allaccessories;
    private List<MyBike> bk;
    @Autowired
    private ObjectMapper mapper;

    public PageController(){
        MyAccessoriesService acrepo = new MyAccessoriesService();
        this.allaccessories = acrepo.getAcc();

        MyBikeService mybike = new MyBikeService();
        this.bk = mybike.getBikeList();
    }

    @GetMapping(value = "bikes")
    public ResponseEntity<String> allbikes (){
        List<MyBike> rs = this.bk;
        String responseString1 = this.convertResponseToString(rs);
        return new ResponseEntity<>(responseString1, HttpStatus.OK);
    }

    @GetMapping(value = "accessories")
    public ResponseEntity<String> allaccessories (){
        Collection<Accessories> response = this.allaccessories;
        String responseString = this.convertResponseToString(response);
        return new ResponseEntity<>(responseString, HttpStatus.OK);
    }

    private String convertResponseToString(Object response) {
        try{
            String jsonResponse = mapper.writeValueAsString(response);
            return jsonResponse;
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Server Error";
    }

    @PostMapping(value ="postEnd")
    public ResponseEntity<String> postend (){
        return new ResponseEntity<>("This is a sample message for Post Request", HttpStatus.OK);
    }

    @PutMapping(value = "putEnd")
    public ResponseEntity<String> putend (){
        return new ResponseEntity<>("This is a sample message for Put Request", HttpStatus.OK);
    }

    @PatchMapping(value = "patchEnd")
    public ResponseEntity<String> patchend (){
        return new ResponseEntity<>("This is a sample message for Patch Request", HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteEnd")
    public ResponseEntity<String> deleteend (){
        return new ResponseEntity<>("This is a sample message for Delete Request", HttpStatus.OK);
    }

}
