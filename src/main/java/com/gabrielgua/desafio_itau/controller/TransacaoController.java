package com.gabrielgua.desafio_itau.controller;

import com.gabrielgua.desafio_itau.model.Transacao;
import com.gabrielgua.desafio_itau.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTransaction(@RequestBody Transacao transacao) {
        service.save(transacao);
    }


}
