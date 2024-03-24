package com.example.firstproject_2.dto;

import com.example.firstproject_2.entity.Pizza;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PizzaDTO {
    private Long id;
    private String name;
    private String price;

    public static PizzaDTO createPizzaDTO(Pizza pizza) {
        return new PizzaDTO(
                pizza.getId(),
                pizza.getName(),
                pizza.getPrice()
        );
    }

    public Pizza toEntity() {
        return new Pizza(id, name, price);
    }
}
