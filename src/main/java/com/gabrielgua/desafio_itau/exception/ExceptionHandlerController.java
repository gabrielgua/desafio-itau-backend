package com.gabrielgua.desafio_itau.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidTransacaoException.class)
    public ResponseEntity<?> handleInvalidTransacao() {
        return ResponseEntity
                .unprocessableEntity()
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid() {
        return ResponseEntity
                .badRequest()
                .build();
    }
}
