package com.gabrielgua.desafio_itau.service;

import com.gabrielgua.desafio_itau.model.Transacao;
import com.gabrielgua.desafio_itau.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransacaoService {

    private final TransacaoRepository repository;
    public void save(Transacao transacao) {

        // validateTransacao(transacao);
        repository.save(transacao);
    }

    public void clear() {
        repository.clear();
    }
}
