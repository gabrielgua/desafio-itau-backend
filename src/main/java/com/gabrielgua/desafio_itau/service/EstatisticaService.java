package com.gabrielgua.desafio_itau.service;

import com.gabrielgua.desafio_itau.model.Transacao;
import com.gabrielgua.desafio_itau.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
@AllArgsConstructor
@Slf4j
public class EstatisticaService {

    private final TransacaoRepository repository;

    public DoubleSummaryStatistics calculate(long interval) {
        log.info("Calculando estatísticas");
        var transacoes = repository.listAll();

        return transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(interval)) || t.getDataHora().equals(OffsetDateTime.now()))
                .map(Transacao::getValor)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();
    }
}
