package com.example.http;

import com.example.domain.ElementoTabelaPeriodicaDTO;
import com.example.domain.request.ElementoTabelaPeriodicaRequest;
import com.example.domain.response.ElementoTabelaPeriodicaResponse;
import com.example.domain.response.ElementosTabelaPeriodicaResponse;
import com.example.usecase.tabelaperiodica.AlterarElementoTabelaPeriodica;
import com.example.usecase.tabelaperiodica.ConsultarElementosTabelaPeriodica;
import com.example.usecase.tabelaperiodica.ExcluirElementoTabelaPeriodica;
import com.example.usecase.tabelaperiodica.SalvarElementoTabelaPeriodica;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/periodic/elements")
@AllArgsConstructor
public class ElementoTabelaPeriodicaWS {
    private final SalvarElementoTabelaPeriodica salvarElementoTabelaPeriodica;
    private final ConsultarElementosTabelaPeriodica consultarElementosTabelaPeriodica;
    private final ExcluirElementoTabelaPeriodica excluirElementoTabelaPeriodica;
    private final AlterarElementoTabelaPeriodica alterarElementoTabelaPeriodica;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ElementoTabelaPeriodicaResponse adicionarElemento(@Valid @RequestBody ElementoTabelaPeriodicaDTO request) {
        return new ElementoTabelaPeriodicaResponse(salvarElementoTabelaPeriodica.executar(request));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ElementosTabelaPeriodicaResponse consultar() {
        return new ElementosTabelaPeriodicaResponse(consultarElementosTabelaPeriodica.executar());
    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluirElemento(@PathVariable("id") Integer id) {
        excluirElementoTabelaPeriodica.executar(id);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void alterarElemento(@PathVariable("id") Integer id,
                                             @Valid @RequestBody ElementoTabelaPeriodicaDTO request) {
        alterarElementoTabelaPeriodica.executar(request, id);
    }
}
