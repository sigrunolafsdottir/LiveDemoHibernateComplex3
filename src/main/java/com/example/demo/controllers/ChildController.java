package com.example.demo.controllers;


import com.example.demo.models.Capital;
import com.example.demo.models.Child;
import com.example.demo.models.Country;
import com.example.demo.repositories.ChildRepository;
import com.example.demo.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/child")
public class ChildController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ChildRepository childRepository;

    @GetMapping(path="/add")
    public String addCountry(@RequestParam String name, @RequestParam String country){

        Country existingCountry = countryRepository.findByName(country);
        Child c = new Child(name, existingCountry);
        childRepository.save(c);

        return name +" was added";
    }



    @GetMapping(path="/all")
    public Iterable<Child> getAllChildren(){
        return childRepository.findAll();
    }




}
