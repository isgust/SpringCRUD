package com.ufma.rocha.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Informa que se trata de uma tabela
@Data //Getters e Setters
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor // Contrutor completo
public class Funcionario {

    @Id //Chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cargo;
    private Double salario;
}
