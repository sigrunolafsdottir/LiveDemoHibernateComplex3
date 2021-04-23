package com.example.demo.controllers;

import com.example.demo.models.Capital;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(path="/")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="/esp")
    public String helloWorldSpanish(){
        return "Hola Mundo";
    }


}
