package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Controller {

    @Value("${aaa.bbb}")
    private String aaa;

    @RequestMapping("hello")
    public String hello(){
        return  aaa;
    }

}
