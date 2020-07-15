package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/greet")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/somescript")
    public String somescript() {
        return "execute some script here";
    }
}
