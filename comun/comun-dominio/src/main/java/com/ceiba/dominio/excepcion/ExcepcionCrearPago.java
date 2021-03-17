package com.ceiba.dominio.excepcion;

public class ExcepcionCrearPago extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCrearPago(String message) {
        super(message);
    }
}
