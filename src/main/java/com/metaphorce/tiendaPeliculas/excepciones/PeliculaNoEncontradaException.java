package com.metaphorce.tiendaPeliculas.excepciones;

public class PeliculaNoEncontradaException extends RuntimeException {
    public PeliculaNoEncontradaException(Integer id) {
        super("Película con ID " + id + " no encontrada.");
    }
}
