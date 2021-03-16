package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;

import java.time.LocalDate;

public class ServicioCrearPago {

    private final RepositorioPago repositorioPago;

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";
    private static final LocalDate FECHA_ACTUAL = LocalDate.now();
    private final int anio_actual;

    public ServicioCrearPago(RepositorioPago repositorioPago) {
        this.repositorioPago = repositorioPago;
        this.anio_actual = FECHA_ACTUAL.getYear();
    }

    public Long ejecutar(Pago pago) {
        this.validarExistenciaPrevia(pago);
        return this.repositorioPago.crear(pago);
    }

    private void validarExistenciaPrevia(Pago pago) {
        boolean existe = this.repositorioPago.existe(pago.getIdPropietario(), pago.getIdInmueble(), pago.getAnio());

        if (existe) {
            throw new ExcepcionDuplicidad(EL_PAGO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


}
