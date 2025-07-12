package com.metaphorce.tiendaPeliculas.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleClienteNoEncontrado(ClienteNoEncontradoException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Cliente no encontrado");
        respuesta.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClienteDatosInvalidosException.class)
    public ResponseEntity<Map<String, String>> handleClienteInvalido(ClienteDatosInvalidosException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Datos inválidos");
        respuesta.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OperacionNoPermitidaException.class)
    public ResponseEntity<Map<String, String>> handleOperacionNoPermitida(OperacionNoPermitidaException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Operación no permitida");
        respuesta.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errores.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Error interno");
        respuesta.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PeliculaNoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handlePeliculaNoEncontrada(PeliculaNoEncontradaException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Película no encontrada");
        respuesta.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PeliculaDatosInvalidosException.class)
    public ResponseEntity<Map<String, String>> handlePeliculaDatosInvalidos(PeliculaDatosInvalidosException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Datos inválidos");
        respuesta.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RentaNoEncontradaException.class)
    public ResponseEntity<Map<String, String>> handleRentaNoEncontrada(RentaNoEncontradaException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Renta no encontrada");
        respuesta.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RentaDatosInvalidosException.class)
    public ResponseEntity<Map<String, String>> handleRentaDatosInvalidos(RentaDatosInvalidosException ex) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", "Datos inválidos");
        respuesta.put("mensaje", ex.getMessage());
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}

