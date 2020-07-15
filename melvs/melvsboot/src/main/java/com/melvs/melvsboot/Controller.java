package com.melvs.melvsboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//controller rest mapping
@RestController
public class Controller {

//request mapping
    @RequestMapping("/GetEnd")
    public List<GetList> getAllList() {
        return Arrays.asList(
            new GetList("1","Melvin","This is test"),
            new GetList("2","John","This is test again"),
            new GetList("3","Bana-ag","This is another test")
            );
        }

    }
