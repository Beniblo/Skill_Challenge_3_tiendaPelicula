package com.metaphorce.tiendaPeliculas.excepciones;

public class ClienteNoEncontradoException extends RuntimeException {
    public ClienteNoEncontradoException(Integer id) {
        super("Cliente con ID " + id + " no encontrado.");
    }
}
