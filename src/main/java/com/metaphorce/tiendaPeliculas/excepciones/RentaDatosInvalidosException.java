package com.metaphorce.tiendaPeliculas.excepciones;

public class RentaDatosInvalidosException extends RuntimeException {
    public RentaDatosInvalidosException(String mensaje) {
        super(mensaje);
    }
}
