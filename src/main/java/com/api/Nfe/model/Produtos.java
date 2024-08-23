package com.api.Nfe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@Table(name = "produtos")
public class Produtos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome", nullable = false, length = 100)  // Mapeamento para a coluna "nome" no banco de dados
        private String nome;

        @Column(name = "preco", nullable = false, precision = 10, scale = 2)  // Mapeamento para a coluna "preco" com precisão e escala
        private BigDecimal preco;

        @Column(name = "data_inclusao", nullable = false, updatable = false)
        private LocalDateTime dataInclusao;

        @PrePersist
        protected void onCreate() {
                this.dataInclusao = LocalDateTime.now();
        }

        @Column(name = "quantidae",nullable = false)
        private  int quantaidade;
}
