package dev.avanade.Fridge.adapters.outbound.entities;


import dev.avanade.Fridge.domain.model.Food;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Entity // annotation obrigatória, diz ao JPA: "Essa classe deve ser mapeada como uma tabela no banco."
@Table(name = "food_table") // annotation opcional, usada para customizar o mapeamento da tabela (name, schema, catalog, uniqueConstraints)
@NoArgsConstructor
@AllArgsConstructor
public class JpaFoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;

    public JpaFoodEntity(Food food) {
        this.id = food.getId();
        this.name = food.getName();
        this.quantity = food.getQuantity();
        this.expirationDate = food.getExpirationDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}