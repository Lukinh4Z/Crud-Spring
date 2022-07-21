package com.lucas.crudspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// @Getter
// @Setter
@Data
@Entity
public class Course {
    
    @Id
    //estratégia depende do banco de dados que utilizamos
    @GeneratedValue(strategy = GenerationType.AUTO)
    //esse json property é que vai ser passado dentro do response body
    //é uma propriedade da biblioteca jckson
    @JsonProperty("_id")
    private Long id;

    // Teoricamente não precisava dessa anotação,
    // mas quanto mais informação melhor pra gerar o SQL
    // @Column(name = "Nome") poderia fazer o link pra esse "Nome"
    // "nullable = false" para tornar esse campo obrigatório
    @Column(length = 200, nullable = false)
    private String name;
    
    // length padrão é 255, a gente coloca para 
    // o banco de dados não tem um tamanho maior do que ele precisa
    @Column(length = 10, nullable = false)
    private String category;

}
