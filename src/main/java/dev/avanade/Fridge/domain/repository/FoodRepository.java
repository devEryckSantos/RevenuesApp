package dev.avanade.Fridge.domain.repository;

import dev.avanade.Fridge.domain.model.Food;

import java.util.List;

public interface FoodRepository {

    Food create(Food food);
    List<Food> getAll();
    void deleteById(Long id);
}
