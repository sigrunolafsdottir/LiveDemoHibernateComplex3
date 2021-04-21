package com.example.demo.controllers;

import com.example.demo.models.Capital;
import com.example.demo.repositories.CapitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capital")
public class CapitalController {

    @Autowired
    CapitalRepository capitalRepository;

    @GetMapping(path="/add")
    public String addCapital(@RequestParam String name){
        Capital c = new Capital(name);
        capitalRepository.save(c);
        return name +"was added";
    }

    @GetMapping(path="/all")
    public Iterable<Capital> getAllCapitals(){
        return capitalRepository.findAll();
    }



}
