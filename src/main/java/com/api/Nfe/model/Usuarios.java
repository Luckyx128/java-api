package com.api.Nfe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome",nullable = false,length = 50)
    private String nome;

    @Column(name = "senha",nullable = false)
    private String senha;
}
