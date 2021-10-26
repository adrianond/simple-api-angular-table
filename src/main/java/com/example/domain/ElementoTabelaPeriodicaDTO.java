package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElementoTabelaPeriodicaDTO {
    private Integer id;
    private String name;
    private String symbol;
    private Double weight;
}
