package dev.avanade.Fridge.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity // annotation obrigatória, diz ao JPA: "Essa classe deve ser mapeada como uma tabela no banco."
@Table(name = "food_table") // annotation opcional, usada para customizar o mapeamento da tabela (name, schema, catalog, uniqueConstraints)
@Data
public class Food {

    @Id // define o atributo abaixo como chave primária da tabela, porém o valor é atribuido manualmente.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define uma estratégia para geração automática do ID, IDENTITY = auto-incremento
    private Long Id;
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;
}
