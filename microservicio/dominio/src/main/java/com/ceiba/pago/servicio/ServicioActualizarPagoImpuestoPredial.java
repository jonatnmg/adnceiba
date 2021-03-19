package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;

public class ServicioActualizarPagoImpuestoPredial {

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";

    private final RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial;

    public ServicioActualizarPagoImpuestoPredial(RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        this.repositorioPagoImpuestoPredial = repositorioPagoImpuestoPredial;
    }

    public void ejecutar(PagoImpuestoPredial pagoImpuestoPredial) {
        this.validarExistenciaPrevia(pagoImpuestoPredial);
        repositorioPagoImpuestoPredial.actualizar(pagoImpuestoPredial);
    }

    private void validarExistenciaPrevia(PagoImpuestoPredial pagoImpuestoPredial) {
        boolean existe = this.repositorioPagoImpuestoPredial.existeExcluyendoId(
                pagoImpuestoPredial.getId(),
                pagoImpuestoPredial.getPropietario().getId(),
                pagoImpuestoPredial.getInmueble().getId(),
                pagoImpuestoPredial.getAnio());

        if (existe) {
            throw new ExcepcionDuplicidad(EL_PAGO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
