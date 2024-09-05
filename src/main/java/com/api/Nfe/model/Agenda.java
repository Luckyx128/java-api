package com.api.Nfe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "empresa", nullable = false)
    private long empresa;

    @Column(name= "status",nullable = true)
    private String status;

    @Column(name= "ramal",nullable = true)
    private String ramal;

    @Column(name= "escala",nullable = true)
    private String escala;
}
