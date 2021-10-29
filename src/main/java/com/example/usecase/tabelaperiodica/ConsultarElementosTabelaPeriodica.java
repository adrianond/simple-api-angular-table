package com.example.usecase.tabelaperiodica;

import com.example.database.repository.TabelaPeriodicaRepository;
import com.example.domain.ElementoTabelaPeriodicaDTO;
import com.example.domain.converter.TabelaPeriodicaConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarElementosTabelaPeriodica {
    private final TabelaPeriodicaConverter converter;
    private final TabelaPeriodicaRepository repository;

    public List<ElementoTabelaPeriodicaDTO> executar() {
        List<ElementoTabelaPeriodicaDTO> list = new ArrayList<>();

       repository.findAll().forEach(elementoTabelaPeriodicaDTO ->
                list.add(converter.buildDTO(elementoTabelaPeriodicaDTO)));

        return list;
    }
}
