package com.example.firstproject_2.service;

import com.example.firstproject_2.dto.PizzaDTO;
import com.example.firstproject_2.entity.Pizza;
import com.example.firstproject_2.repository.PizzaRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> index() {
        return pizzaRepository.findAll();
    }

    public Pizza show(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public Pizza create(PizzaDTO dto) {
        Pizza pizza = dto.toEntity();
        if (pizza.getId() != null) {
            return null;
        }
        return pizzaRepository.save(pizza);
    }
}
