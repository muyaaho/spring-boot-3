package com.example.firstproject_2.api;

import com.example.firstproject_2.dto.PizzaDTO;
import com.example.firstproject_2.service.PizzaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    public ResponseEntity<List<PizzaDTO>> index() {
        List<PizzaDTO> dtos = pizzaService.index();
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @GetMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDTO> show(@PathVariable Long id) {
        PizzaDTO dto = pizzaService.show(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/api/pizza")
    public ResponseEntity<PizzaDTO> create(@RequestBody PizzaDTO dto) {
        PizzaDTO createdDTO = pizzaService.create(dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDTO);
    }

    @PatchMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDTO> update(@PathVariable Long id, @RequestBody PizzaDTO dto) {
        PizzaDTO updatedDTO = pizzaService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDTO);
    }

    @DeleteMapping("/api/pizza/{id}")
    public ResponseEntity<PizzaDTO> delete(@PathVariable Long id) {
        PizzaDTO deletedDTO = pizzaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDTO);
    }


}
