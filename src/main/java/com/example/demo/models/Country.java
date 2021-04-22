package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    //@JoinColumn(name="capitalId", referencedColumnName="id")   //går att ta bort
    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)  //popagerar ALLA operationer

    //när ett land skapas skapas också huvudstaden i db
    //när ett land tas bort ligger huvudstaden kvar i db
    //@OneToOne(cascade = CascadeType.PERSIST)
    //tvärt om
    //@OneToOne(cascade = CascadeType.REMOVE)
    private Capital capital;

    @OneToMany(mappedBy="country", fetch=FetchType.LAZY)
   // @LazyToOne(LazyToOneOption.NO_PROXY)
   // @LazyGroup("child")
    //@Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Child> children;


    public Country() { }

    public Country(String name, Capital capital) {
        this.name = name;
        this.capital = capital;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
