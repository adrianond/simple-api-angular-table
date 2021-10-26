package com.example.domain.converter;

import com.example.database.entity.TabelaPeriodica;
import com.example.domain.ElementoTabelaPeriodicaDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class TabelaPeriodicaConverter {

    public List<ElementoTabelaPeriodicaDTO> buildDTO(Iterable<TabelaPeriodica> elementos) {
        List<TabelaPeriodica> list =
                StreamSupport.stream(elementos.spliterator(), false)
                        .collect(Collectors.toList());

        return list.stream()
                .map(this::buildTabelaPeriodocaDTO)
                .collect(Collectors.toList());
    }

    private ElementoTabelaPeriodicaDTO buildTabelaPeriodocaDTO(TabelaPeriodica elemento) {
        ElementoTabelaPeriodicaDTO tabelaPeriodica = new ElementoTabelaPeriodicaDTO();
        tabelaPeriodica.setId(elemento.getId());
        tabelaPeriodica.setName(elemento.getName());
        tabelaPeriodica.setSymbol(elemento.getSymbol());
        tabelaPeriodica.setWeight(elemento.getWeight());
        return tabelaPeriodica;
    }

    public List<TabelaPeriodica> buildEntity(List<ElementoTabelaPeriodicaDTO> elementos) {
        return elementos.stream()
                .map(this::buildTabelaPeriodoca)
                .collect(Collectors.toList());
    }

    private TabelaPeriodica buildTabelaPeriodoca(ElementoTabelaPeriodicaDTO elemento) {
        TabelaPeriodica tabelaPeriodica = new TabelaPeriodica();
        tabelaPeriodica.setId(elemento.getId());
        tabelaPeriodica.setName(elemento.getName());
        tabelaPeriodica.setSymbol(elemento.getSymbol());
        tabelaPeriodica.setWeight(elemento.getWeight());
        return tabelaPeriodica;
    }
}
