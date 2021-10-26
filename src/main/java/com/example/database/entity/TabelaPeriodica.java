package com.example.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tabela_periodica")
public class TabelaPeriodica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String symbol;

    @Column(nullable = false, unique = true)
    private Double weight;
}
