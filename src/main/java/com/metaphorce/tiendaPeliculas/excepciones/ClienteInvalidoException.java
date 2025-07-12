package com.metaphorce.tiendaPeliculas.excepciones;

public class ClienteInvalidoException extends RuntimeException {
    public ClienteInvalidoException(String mensaje) {
        super(mensaje);
    }
}
