package dev.avanade.Fridge.adapters.outbound.repository;

import dev.avanade.Fridge.adapters.outbound.entities.JpaFoodEntity;
import dev.avanade.Fridge.domain.model.Food;
import dev.avanade.Fridge.domain.repository.FoodRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FoodRepositoryImpl implements FoodRepository {

    private final JpaFoodRepository jpaFoodRepository;

    public FoodRepositoryImpl(JpaFoodRepository jpaFoodRepository) {
        this.jpaFoodRepository = jpaFoodRepository;
    }

    @Override
    public Food create(Food food) {
        JpaFoodEntity foodEntity = new JpaFoodEntity(food);
        this.jpaFoodRepository.save(foodEntity);
        return new Food(
                foodEntity.getId(),
                foodEntity.getName(),
                foodEntity.getQuantity(),
                foodEntity.getExpirationDate());
    }


    @Override
    public List<Food> getAll() {
        return this.jpaFoodRepository.findAll()
                .stream()
                .map(entity -> new Food(
                        entity.getId(),
                        entity.getName(),
                        entity.getQuantity(),
                        entity.getExpirationDate()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.jpaFoodRepository.deleteById(id);
    }
}
