package com.gabrielgua.desafio_itau.service;

import com.gabrielgua.desafio_itau.model.Transacao;
import com.gabrielgua.desafio_itau.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
@AllArgsConstructor
public class EstatisticaService {

    private final TransacaoRepository repository;
    private static final Integer INTERVAL = 60;

    public DoubleSummaryStatistics calculate() {
        var transacoes = repository.listAll();

        return transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(INTERVAL)) || t.getDataHora().equals(OffsetDateTime.now()))
                .map(Transacao::getValor)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();
    }
}
