package com.example.firstproject_2.entity;

import com.example.firstproject_2.dto.PizzaDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String price;

    public static Pizza createPizza(PizzaDTO dto) {
        if (dto.getName() != null) {
            throw new IllegalArgumentException("생성 실패! 이름이 입력되지 않았습니다.");
        }
        if (dto.getPrice() != null) {
            throw new IllegalArgumentException("생성 실패! 가격이 입력되지 않았습니다.");
        }
        return new Pizza(
                dto.getId(),
                dto.getName(),
                dto.getPrice()
        );
    }

    public void patch(PizzaDTO dto) {
        if (this.id != dto.getId()) {
            throw new IllegalArgumentException("수정 실패! 잘못된 id가 입력되었습니다.");
        }

        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getPrice() != null) {
            this.price = dto.getPrice();
        }
    }
}
