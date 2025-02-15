package com.gabrielgua.desafio_itau.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @NotNull
    private BigDecimal valor;

    @NotNull
    private OffsetDateTime dataHora;
}
