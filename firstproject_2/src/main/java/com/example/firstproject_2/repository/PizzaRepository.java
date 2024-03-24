package com.example.firstproject_2.repository;

import com.example.firstproject_2.entity.Pizza;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {
    @Override
    ArrayList<Pizza> findAll();
}
