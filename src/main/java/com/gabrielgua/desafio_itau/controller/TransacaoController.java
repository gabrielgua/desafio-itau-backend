package com.gabrielgua.desafio_itau.controller;

import com.gabrielgua.desafio_itau.model.Transacao;
import com.gabrielgua.desafio_itau.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(
        value = "/transacao",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class TransacaoController {

    private final TransacaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTransaction(@Valid @RequestBody Transacao transacao) {
        service.save(transacao);
    }
}
