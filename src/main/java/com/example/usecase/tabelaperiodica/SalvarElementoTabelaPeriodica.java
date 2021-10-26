package com.example.usecase.tabelaperiodica;

import com.example.database.entity.TabelaPeriodica;
import com.example.database.repository.TabelaPeriodicaRepository;
import com.example.domain.ElementoTabelaPeriodicaDTO;
import com.example.domain.converter.TabelaPeriodicaConverter;
import com.example.domain.request.ElementoTabelaPeriodicaRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class SalvarElementoTabelaPeriodica {
    private final TabelaPeriodicaRepository repository;
    private final TabelaPeriodicaConverter converter;

    public List<ElementoTabelaPeriodicaDTO> executar(ElementoTabelaPeriodicaRequest request) {
        if (CollectionUtils.isEmpty(request.getElementosTabelaPeriodica()))
            return Collections.emptyList();
        return salvarElementos(request.getElementosTabelaPeriodica());
    }

    private List<ElementoTabelaPeriodicaDTO> salvarElementos(List<ElementoTabelaPeriodicaDTO> elementos) {
        Iterable<TabelaPeriodica> elementosSalvos = repository.saveAll(converter.buildEntity(elementos));
        return converter.buildDTO(elementosSalvos);
    }
}
