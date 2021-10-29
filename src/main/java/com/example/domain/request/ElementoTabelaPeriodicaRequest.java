package com.example.domain.request;

import com.example.domain.ElementoTabelaPeriodicaDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ElementoTabelaPeriodicaRequest {
    private List<ElementoTabelaPeriodicaDTO> elementos = new ArrayList<>();
}
