package dev.avanade.Fridge.repository;

import dev.avanade.Fridge.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 o JpaRepository é uma interface que herda de CrudRepository e PagingAndSortingRepository, fornecendo uma série de
 métodos prontos para manipulaçoes de entidades e dados no Banco de Dados.
 Entre os diamonds o JPA espera que passemos a classe que ele vai persistir e realizar as ações de manipulação de dados
 e, além disso, o tipo do identificador único (ID ⇾ chave primária).

                                               JpaRepository<T, ID>

                                save, findById, findAll, delete, existsById, etc.

Por que isso é importante?
Porque o Spring Data JPA gera automaticamente os métodos de CRUD com base nesses tipos. Ele precisa saber:
    - Qual entidade ele está a manipular (T)
    - Qual é o tipo da chave primária para métodos como findById(ID id), deleteById(ID id), etc.
 */
public interface FoodRepository extends JpaRepository<Food, Long> {
}
