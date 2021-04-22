package com.example.demo.controllers;

import com.example.demo.models.Capital;
import com.example.demo.models.Present;
import com.example.demo.repositories.CapitalRepository;
import com.example.demo.repositories.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/present")
public class PresentController {

    @Autowired
    PresentRepository presentRepository;

    @GetMapping(path="/add")
    public String addPresent(@RequestParam String name){
        Present c = new Present(name);
        presentRepository.save(c);
        return name +" was added";
    }

    @GetMapping(path="/all")
    public Iterable<Present> getAllPresents(){
        return presentRepository.findAll();
    }



}
