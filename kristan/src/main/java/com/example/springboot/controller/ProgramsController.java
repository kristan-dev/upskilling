package com.example.springboot.controller;

import com.example.springboot.controller.SerializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProgramsController {

    @Autowired
    @Qualifier("serializer")
    private SerializerService serializerService;



}
