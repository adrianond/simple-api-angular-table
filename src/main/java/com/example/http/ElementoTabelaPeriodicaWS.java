package com.example.http;

import com.example.domain.ElementoTabelaPeriodicaDTO;
import com.example.domain.request.ElementoTabelaPeriodicaRequest;
import com.example.domain.response.ElementoTabelaPeriodicaResponse;
import com.example.usecase.tabelaperiodica.AlterarElementoTabelaPeriodica;
import com.example.usecase.tabelaperiodica.ConsultarElementosTabelaPeriodica;
import com.example.usecase.tabelaperiodica.ExcluirElementoTabelaPeriodica;
import com.example.usecase.tabelaperiodica.SalvarElementoTabelaPeriodica;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/periodic/table")
@AllArgsConstructor
public class ElementoTabelaPeriodicaWS {
    private final SalvarElementoTabelaPeriodica salvarElementoTabelaPeriodica;
    private final ConsultarElementosTabelaPeriodica consultarElementosTabelaPeriodica;
    private final ExcluirElementoTabelaPeriodica excluirElementoTabelaPeriodica;
    private final AlterarElementoTabelaPeriodica alterarElementoTabelaPeriodica;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ElementoTabelaPeriodicaResponse adicionarElemento(@Valid @RequestBody ElementoTabelaPeriodicaRequest elementoTabelaPeriodicaRequest) {
        return new ElementoTabelaPeriodicaResponse(salvarElementoTabelaPeriodica.executar(elementoTabelaPeriodicaRequest));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ElementoTabelaPeriodicaResponse consultar() {
        return new ElementoTabelaPeriodicaResponse(consultarElementosTabelaPeriodica.executar());
    }


    @DeleteMapping(path = "/element/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluirElemento(@PathVariable("id") Integer id) {
        excluirElementoTabelaPeriodica.executar(id);
    }

    @PutMapping(path = "/element/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void alterarElemento(@PathVariable("id") Integer id,
                                             @Valid @RequestBody ElementoTabelaPeriodicaDTO request) {
        alterarElementoTabelaPeriodica.executar(request, id);
    }
}
