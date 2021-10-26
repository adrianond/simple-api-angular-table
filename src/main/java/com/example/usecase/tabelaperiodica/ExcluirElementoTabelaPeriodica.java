package com.example.usecase.tabelaperiodica;

import com.example.database.entity.TabelaPeriodica;
import com.example.database.repository.TabelaPeriodicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExcluirElementoTabelaPeriodica {
    private final TabelaPeriodicaRepository repository;

    public void executar(Integer id) {
        TabelaPeriodica elemento = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Elemento não encontrado"));

        repository.delete(elemento);
    }
}
