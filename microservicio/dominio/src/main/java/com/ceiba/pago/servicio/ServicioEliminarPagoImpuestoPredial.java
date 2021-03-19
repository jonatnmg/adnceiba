package com.ceiba.pago.servicio;

import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;

public class ServicioEliminarPagoImpuestoPredial {
    private final RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial;

    public ServicioEliminarPagoImpuestoPredial(RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        this.repositorioPagoImpuestoPredial = repositorioPagoImpuestoPredial;
    }

    public void ejecutar(Long id) {
        this.repositorioPagoImpuestoPredial.eliminar(id);
    }
}
