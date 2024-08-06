package com.gabrielgua.desafio_itau.exception;

public class InvalidTransacaoException extends RuntimeException {

    public InvalidTransacaoException(String message) {
        super(message);
    }
}
