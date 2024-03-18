package com.example.firstproject_2.api;

import com.example.firstproject_2.dto.PizzaDTO;
import com.example.firstproject_2.entity.Pizza;
import com.example.firstproject_2.service.PizzaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PizzaApiController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/api/pizza")
    public List<Pizza> index() {
        return pizzaService.index();
    }

    @GetMapping("/api/pizza/{id}")
    public Pizza show(@PathVariable Long id) {
        return pizzaService.show(id);
    }

    @PostMapping("/api/pizza")
    public ResponseEntity<Pizza> create(@RequestBody PizzaDTO dto) {
        Pizza created = pizzaService.create(dto);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
