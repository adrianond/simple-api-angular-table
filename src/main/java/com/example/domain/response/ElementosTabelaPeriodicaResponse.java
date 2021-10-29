package com.example.domain.response;

import com.example.domain.ElementoTabelaPeriodicaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ElementosTabelaPeriodicaResponse {
    private List<ElementoTabelaPeriodicaDTO> elementos;
}
