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

    public Pizza create(PizzaDTO dto) {
        Pizza pizza = dto.toEntity();
        if (pizza.getId() != null) {
            return null;
        }
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Long id, PizzaDTO dto) {
        Pizza pizza = dto.toEntity();
        log.info("id: {}, pizza: {}", id, pizza.toString());
        Pizza target = pizzaRepository.findById(id).orElse(null);
        log.info("target: {}", target.toString());
        if (target == null || !id.equals(pizza.getId())) {
            log.info("잘못된 요청, id: {}, pizza: {}", id, pizza.toString());
            return null;
        }
        target.patch(pizza);
        Pizza updated = pizzaRepository.save(target);
        return updated;
    }

    @Transactional
    public PizzaDTO delete(Long id) {
        Pizza target = pizzaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("삭제 실패. 대상이 없습니다."));
        pizzaRepository.delete(target);
        return PizzaDTO.createPizzaDTO(target);
    }
}
