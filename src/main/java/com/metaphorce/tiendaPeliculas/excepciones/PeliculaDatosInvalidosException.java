package com.metaphorce.tiendaPeliculas.excepciones;

public class PeliculaDatosInvalidosException extends RuntimeException {
    public PeliculaDatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
