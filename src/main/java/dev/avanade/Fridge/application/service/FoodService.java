package dev.avanade.Fridge.application.service;

import dev.avanade.Fridge.adapters.outbound.entities.JpaFoodEntity;
import dev.avanade.Fridge.domain.model.Food;
import dev.avanade.Fridge.adapters.outbound.repository.JpaFoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final JpaFoodRepository jpaFoodRepository;

    public FoodService(JpaFoodRepository jpaFoodRepository) {
        this.jpaFoodRepository = jpaFoodRepository;
    }

    public List<JpaFoodEntity> getAll() { return jpaFoodRepository.findAll(); }

    public JpaFoodEntity save(JpaFoodEntity foodEntity) {return jpaFoodRepository.save(foodEntity);}

    public void deleteById(Long id) { jpaFoodRepository.deleteById(id);}
}
