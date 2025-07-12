package com.metaphorce.tiendaPeliculas.excepciones;

public class ClienteDatosInvalidosException extends RuntimeException {
    public ClienteDatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
