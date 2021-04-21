package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    //@JoinColumn(name="capitalId", referencedColumnName="id")   //går att ta bort
    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Capital capital;

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
}
