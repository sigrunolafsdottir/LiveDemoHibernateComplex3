package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country;

    public Child(String name, Country country) {
        this.name = name;
        this.country = country;
    }


    public Child() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }




}
