package com.example.domain.converter;

import com.example.database.entity.TabelaPeriodica;
import com.example.domain.ElementoTabelaPeriodicaDTO;
import org.springframework.stereotype.Component;

@Component
public class TabelaPeriodicaConverter {

    public ElementoTabelaPeriodicaDTO buildDTO(TabelaPeriodica elemento) {
        ElementoTabelaPeriodicaDTO tabelaPeriodica = new ElementoTabelaPeriodicaDTO();
        tabelaPeriodica.setId(elemento.getId());
        tabelaPeriodica.setName(elemento.getName());
        tabelaPeriodica.setWeight(elemento.getWeight());
        tabelaPeriodica.setSymbol(elemento.getSymbol());
        return tabelaPeriodica;
    }

    public TabelaPeriodica buildEntity(ElementoTabelaPeriodicaDTO elemento) {
        TabelaPeriodica tabelaPeriodica = new TabelaPeriodica();
        tabelaPeriodica.setName(elemento.getName());
        tabelaPeriodica.setSymbol(elemento.getSymbol());
        tabelaPeriodica.setWeight(elemento.getWeight());
        return tabelaPeriodica;
    }
}
