package com.example.firstproject_2.repository;

import com.example.firstproject_2.entity.Coffee;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {

    @Override
    ArrayList<Coffee> findAll();
}
