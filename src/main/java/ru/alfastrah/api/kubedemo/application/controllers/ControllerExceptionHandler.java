package ru.alfastrah.api.kubedemo.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.alfastrah.api.kubedemo.domain.model.dto.ExceptionDTO;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleExceptions(Exception ex) {
        final ExceptionDTO exceptionDTO =
                new ExceptionDTO(ex.getClass().getSimpleName() + " | " + ex.getMessage());
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(exceptionDTO);
    }
}
