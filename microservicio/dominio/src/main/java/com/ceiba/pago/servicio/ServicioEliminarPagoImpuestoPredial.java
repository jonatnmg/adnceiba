package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;

public class ServicioEliminarPagoImpuestoPredial {

    private static final String PAGO_NO_ENCONTRADO_EN_EL_SISTEMA = "No se puede actualizar, el pago no se encontro en el sistema";

    private final RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial;

    public ServicioEliminarPagoImpuestoPredial(RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        this.repositorioPagoImpuestoPredial = repositorioPagoImpuestoPredial;
    }

    public void ejecutar(Long id) {
        this.validarExistePagoImpuestoPredial(id);
        this.repositorioPagoImpuestoPredial.eliminar(id);
    }

    private void validarExistePagoImpuestoPredial(Long id) {
        boolean existe = this.repositorioPagoImpuestoPredial.existePorId(id);

        if (!existe) {
            throw new ExcepcionSinDatos(PAGO_NO_ENCONTRADO_EN_EL_SISTEMA);
        }
    }
}
