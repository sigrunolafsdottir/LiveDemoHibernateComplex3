package com.example.demo.repositories;

import com.example.demo.models.Capital;
import com.example.demo.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByName(String s);
    void deleteByName(String s);

}
