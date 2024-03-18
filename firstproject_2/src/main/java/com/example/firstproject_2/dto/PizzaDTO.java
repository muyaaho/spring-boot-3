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

    public Pizza toEntity() {
        return new Pizza(id, name, price);
    }
}
