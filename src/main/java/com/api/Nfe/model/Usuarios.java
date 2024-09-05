package com.api.Nfe.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    private long id;
    private String nome;
    private long cpf;
}
