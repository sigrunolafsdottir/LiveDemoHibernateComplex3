package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Capital {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public Capital() {}

    public Capital(String name) {
        this.name = name;
    }

    public Capital(String name, Long id) {
        this.id=id;
        this.name = name;
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

    private String name;



}
