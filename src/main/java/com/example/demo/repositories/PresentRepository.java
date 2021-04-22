package com.example.demo.repositories;

import com.example.demo.models.Capital;
import com.example.demo.models.Present;
import org.springframework.data.repository.CrudRepository;

public interface PresentRepository extends CrudRepository<Present, Long> {

        Present findByName(String s);
}
