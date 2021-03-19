package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;

public class ServicioPagarInmpuestoPredial {

    private final RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial;

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";

    public ServicioPagarInmpuestoPredial(RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        this.repositorioPagoImpuestoPredial = repositorioPagoImpuestoPredial;
    }

    public Long ejecutar(PagoImpuestoPredial pagoImpuestoPredial) {

        this.validarExistenciaPrevia(pagoImpuestoPredial);

        return this.repositorioPagoImpuestoPredial.crear(pagoImpuestoPredial);
    }

    private void validarExistenciaPrevia(PagoImpuestoPredial pagoImpuestoPredial) {
        boolean existe = this.repositorioPagoImpuestoPredial.existe(pagoImpuestoPredial.getPropietario().getId(), pagoImpuestoPredial.getInmueble().getId(), pagoImpuestoPredial.getAnio());

        if (existe) {
            throw new ExcepcionDuplicidad(EL_PAGO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}