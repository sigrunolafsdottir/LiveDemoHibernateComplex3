package com.example.demo.controllers;


import com.example.demo.models.Capital;
import com.example.demo.models.Child;
import com.example.demo.models.Country;
import com.example.demo.models.Present;
import com.example.demo.repositories.ChildRepository;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.repositories.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/child")
public class ChildController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ChildRepository childRepository;

    @Autowired
    PresentRepository presentRepository;

    @GetMapping(path="/add")
    public String addChild(@RequestParam String name, @RequestParam String country){

        Country existingCountry = countryRepository.findByName(country);
        Child c = new Child(name, existingCountry);
        childRepository.save(c);

        return name +" was added";
    }

    @GetMapping(path="/addWithPresents")
    public String addChildWithPresents(@RequestParam String name, @RequestParam String country, @RequestParam String wishes){

        Country existingCountry = countryRepository.findByName(country);
        Present existingPresent= presentRepository.findByName(wishes);
        List<Present> presList = Arrays.asList(existingPresent);
        Child c = new Child(name, existingCountry, presList);
        childRepository.save(c);

        return name +" was added";
    }

    @GetMapping(path="/addWithPresentsAndGets")
    public String addChildWithPresentsAndGets(@RequestParam String name, @RequestParam String country, @RequestParam String wishes, @RequestParam String gets){

        Country existingCountry = countryRepository.findByName(country);
        Present existingPresent= presentRepository.findByName(wishes);
        Present getsInRepo= presentRepository.findByName(gets);
        List<Present> presList = Arrays.asList(existingPresent);
        List<Present> getList = Arrays.asList(getsInRepo);
        Child c = new Child(name, existingCountry, presList, getList);
        childRepository.save(c);

        return name +" was added";
    }



    @GetMapping(path="/all")
    public Iterable<Child> getAllChildren(){
        return childRepository.findAll();
    }




}
