package com.gabrielgua.desafio_itau.controller;

import com.gabrielgua.desafio_itau.model.EstatisticaResponse;
import com.gabrielgua.desafio_itau.service.EstatisticaService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/estatistica",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
@AllArgsConstructor
public class EstatisticaController {

    private static final String DEFAULT_INTERVAL = "60";
    private final EstatisticaService service;

    @GetMapping
    public EstatisticaResponse calculate(@RequestParam(required = false, defaultValue = DEFAULT_INTERVAL) long interval) {
        return new EstatisticaResponse(service.calculate(interval));
    }
}
