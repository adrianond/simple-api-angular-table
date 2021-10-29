package com.example.usecase.tabelaperiodica;

import com.example.database.entity.TabelaPeriodica;
import com.example.database.repository.TabelaPeriodicaRepository;
import com.example.domain.ElementoTabelaPeriodicaDTO;
import com.example.domain.converter.TabelaPeriodicaConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SalvarElementoTabelaPeriodica {
    private final TabelaPeriodicaRepository repository;
    private final TabelaPeriodicaConverter converter;

    public ElementoTabelaPeriodicaDTO executar(ElementoTabelaPeriodicaDTO request) {
        if (null == request)
            return null;
        return salvarElemento(request);
    }

    private ElementoTabelaPeriodicaDTO salvarElemento(ElementoTabelaPeriodicaDTO elemento) {
        TabelaPeriodica elementosSalvo = repository.save(converter.buildEntity(elemento));
        return converter.buildDTO(elementosSalvo);
    }
}
