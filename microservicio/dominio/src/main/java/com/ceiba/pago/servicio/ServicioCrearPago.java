package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;

import java.util.Calendar;

public class ServicioCrearPago {

    private final RepositorioPago repositorioPago;

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";
    private static final double PORCENTAJE_DESCUENTO = 10;
    private static final double PORCENTAJE_MULTA_ANIO = 10;
    private static final String DIA_SABADO = "Sabado";
    private static final String DIA_DOMINGO = "Domingo";
    private static final int ANIO_ACTUAL = Calendar.YEAR;

    public ServicioCrearPago(RepositorioPago repositorioPago) {
        this.repositorioPago = repositorioPago;
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
