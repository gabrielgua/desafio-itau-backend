package com.gabrielgua.desafio_itau.repository;

import com.gabrielgua.desafio_itau.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    private final List<Transacao> transacoes = new ArrayList<>();


    public void save(Transacao transacao) {
        System.out.println("Added - " + transacao.getValor() + ", " + transacao.getDataHora());
        transacoes.add(transacao);
    }

    public void clear() {
        transacoes.clear();
    }
    public List<Transacao> listAll() {
        return transacoes;
    }
}
