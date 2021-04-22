package com.example.demo.controllers;

import com.example.demo.models.Capital;
import com.example.demo.repositories.CapitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(CapitalController.class);

    @GetMapping(path="/add")
    public String addCapital(@RequestParam String name){
        Capital c = new Capital(name);
        capitalRepository.save(c);
        log.info("A capital has been added "+name);
        log.debug("Debugging add Capitals");
        return name +"was added";
    }

    @GetMapping(path="/all")
    public Iterable<Capital> getAllCapitals(){
        log.info("Someone wanted to see all the capitals");
        return capitalRepository.findAll();
    }



}
