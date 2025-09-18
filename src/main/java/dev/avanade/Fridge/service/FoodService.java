package dev.avanade.Fridge.service;

import dev.avanade.Fridge.model.Food;
import dev.avanade.Fridge.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAll() { return foodRepository.findAll(); }

    public Food save(Food food) {return foodRepository.save(food);}

    public void deleteById(Long id) { foodRepository.deleteById(id);}
}
