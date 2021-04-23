package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiniController {

    @RequestMapping(path="/")
    public String helloWorld(){
        return "Hello World";
    }
}
