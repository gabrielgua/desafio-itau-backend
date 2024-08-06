package com.gabrielgua.desafio_itau.service;

import com.gabrielgua.desafio_itau.exception.InvalidTransacaoException;
import com.gabrielgua.desafio_itau.model.Transacao;
import com.gabrielgua.desafio_itau.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class TransacaoService {

    private final TransacaoRepository repository;
    public void save(Transacao transacao) {
        validateTransacao(transacao);
        repository.save(transacao);
    }

    public void clear() {
        repository.clear();
    }

    private void validateTransacao(Transacao transacao) {
        if (transacao.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidTransacaoException("Valor não pode ser menor que zero");
        }

        if (transacao.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new InvalidTransacaoException("Transação não pode acontecer no futuro");
        }
    }
}
