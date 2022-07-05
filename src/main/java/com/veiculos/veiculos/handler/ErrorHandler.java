package com.veiculos.veiculos.handler;

import com.veiculos.veiculos.exception.NotFoundException;
import com.veiculos.veiculos.exception.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> notFoundExceptionHandler(NotFoundException exception) {
        return new ResponseEntity<NotFoundExceptionDetails>(new NotFoundExceptionDetails(
                "Objeto não encontrado",
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()),
                HttpStatus.NOT_FOUND
        );
    }
}
