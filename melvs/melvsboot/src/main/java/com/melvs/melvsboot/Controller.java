package com.melvs.melvsboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

//controller rest mapping
@RestController
public class GetEnd {

//request mapping
    @RequestMapping("/GetEnd")
    public String getend() {
        return "This is a value return back";}
}
