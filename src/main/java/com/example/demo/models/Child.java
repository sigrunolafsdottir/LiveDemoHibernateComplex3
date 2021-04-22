package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.List;

@Entity
public class Child {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
   // @LazyToOne(LazyToOneOption.NO_PROXY)
    @JsonBackReference
    private Country country;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "wishes", joinColumns = {@JoinColumn(referencedColumnName = "id")}
            , inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private List<Present> wishes;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Present> gets;


    public Child(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Child(String name, Country country, List<Present> wishes) {
        this.name = name;
        this.country = country;
        this.wishes= wishes;
    }

    public Child(String name, Country country, List<Present> wishes, List<Present> gets) {
        this.name = name;
        this.country = country;
        this.wishes= wishes;
        this.gets = gets;
    }

    public List<Present> getGets() {
        return gets;
    }

    public void setGets(List<Present> gets) {
        this.gets = gets;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Present> getWishes() {
        return wishes;
    }

    public void setWishes(List<Present> wishes) {
        this.wishes = wishes;
    }
}
