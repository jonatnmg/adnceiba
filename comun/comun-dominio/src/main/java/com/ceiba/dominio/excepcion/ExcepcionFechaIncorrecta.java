package com.ceiba.dominio.excepcion;

public class ExcepcionFechaIncorrecta extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionFechaIncorrecta(String message) {
        super(message);
    }
}
