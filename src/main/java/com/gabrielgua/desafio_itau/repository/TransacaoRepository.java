package com.gabrielgua.desafio_itau.repository;

import com.gabrielgua.desafio_itau.model.Transacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class TransacaoRepository {

    private final List<Transacao> transacoes = new ArrayList<>();

    public List<Transacao> listAll() { return transacoes; }

    public void save(Transacao transacao) {
        transacoes.add(transacao);
        log.info("Transação adicionada");
    }

    public void clear() {
        transacoes.clear();
        log.warn("Transações limpadas");
    }

}
