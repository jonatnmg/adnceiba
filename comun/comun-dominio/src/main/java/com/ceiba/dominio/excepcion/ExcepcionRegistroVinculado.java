package com.ceiba.dominio.excepcion;

public class ExcepcionRegistroVinculado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionRegistroVinculado(String message) {
        super(message);
    }
}
