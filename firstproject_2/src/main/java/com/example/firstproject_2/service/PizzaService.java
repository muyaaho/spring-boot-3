package com.example.firstproject_2.service;

import com.example.firstproject_2.dto.PizzaDTO;
import com.example.firstproject_2.entity.Pizza;
import com.example.firstproject_2.repository.PizzaRepository;
import jakarta.transaction.Transactional;
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

    public PizzaDTO create(PizzaDTO dto) {
        Pizza pizza = Pizza.createPizza(dto);
        Pizza created = pizzaRepository.save(pizza);
        return PizzaDTO.createPizzaDTO(created);
    }

    public PizzaDTO update(Long id, PizzaDTO dto) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("수정 실패! 대상이 없습니다."));
        target.patch(dto);
        Pizza updated = pizzaRepository.save(target);
        return PizzaDTO.createPizzaDTO(updated);
    }

    @Transactional
    public PizzaDTO delete(Long id) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제 실패. 대상이 없습니다."));
        pizzaRepository.delete(target);
        return PizzaDTO.createPizzaDTO(target);
    }
}
