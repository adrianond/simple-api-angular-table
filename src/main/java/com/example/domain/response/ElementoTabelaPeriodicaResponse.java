package com.example.domain.response;

import com.example.domain.ElementoTabelaPeriodicaDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ElementoTabelaPeriodicaResponse {
    private List<ElementoTabelaPeriodicaDTO> elementos;

    public ElementoTabelaPeriodicaResponse(List<ElementoTabelaPeriodicaDTO> elementos) {
        this.elementos = elementos;
    }
}
