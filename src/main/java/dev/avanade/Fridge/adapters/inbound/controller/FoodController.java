package dev.avanade.Fridge.adapters.inbound.controller;

import dev.avanade.Fridge.domain.model.Food;
import dev.avanade.Fridge.application.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Define essa classe como um RESTful Controller (Combinação de @Controller + @ResponseBody)
// Essa junção faz com que todos os métodos retornem dados diretamente no corpo da resposta (JSON, XML, etc.).
@RestController
@RequestMapping("/food") // Define o caminho "/food" como ponto de partida para o mapeamento das requisições
public class FoodController {

    private final FoodService foodService; // injeção de dependência

    // Inicializando o Service
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAll() { return foodService.getAll(); }

    @PostMapping
    /*
     @RequestBody → mapeia o corpo da requisição (normalmente JSON) para um objeto (DTO). Ele usa os conversores de
     mensagem do Spring (como Jackson) para desserializar JSON → Java.

     - É muito comum em métodos POST, PUT e PATCH, onde o cliente envia dados para o servidor.

     Não precisamos passar cada atributo separadamente para criar uma entidade Food. O Spring faz esse trabalho por
     nós. Basta que passemos a própria classe no paramêtro.
    */
    public Food create(@RequestBody Food food) { return foodService.save(food); }

    /*
     A anotação @PathVariable é usada para extrair valores diretamente da URL e vinculá-los a parâmetros da função
     no Controller.
     O ("/{id}") é um placeholder na URL que representa um valor variável.
    */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) { foodService.deleteById(id); }
}
