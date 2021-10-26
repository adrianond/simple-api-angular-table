package com.example.usecase.tabelaperiodica;


import com.example.database.entity.TabelaPeriodica;
import com.example.database.repository.TabelaPeriodicaRepository;
import com.example.domain.ElementoTabelaPeriodicaDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class AlterarElementoTabelaPeriodica {
    private final TabelaPeriodicaRepository repository;

    @Transactional
    public void executar(ElementoTabelaPeriodicaDTO request, Integer id) {
        TabelaPeriodica elemento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Elemento não encontrado"));
        elemento.setName(request.getName());
        elemento.setSymbol(request.getSymbol());
        elemento.setWeight(request.getWeight());
    }
}
