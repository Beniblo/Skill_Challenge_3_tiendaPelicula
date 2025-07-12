package com.metaphorce.tiendaPeliculas.excepciones;

public class RentaNoEncontradaException extends RuntimeException {
    public RentaNoEncontradaException(Integer id) {
        super("Renta con ID " + id + " no encontrada.");
    }
}
