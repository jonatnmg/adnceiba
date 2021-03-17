package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionCrearPago;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioCrearPago {

    private final RepositorioPago repositorioPago;

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";
    private static final String NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS = "No se permiten pagos los dias sabados o domingos";
    private static final LocalDate FECHA_ACTUAL = LocalDate.now();
    private static final int anioActual = FECHA_ACTUAL.getYear();

    public ServicioCrearPago(RepositorioPago repositorioPago) {
        this.repositorioPago = repositorioPago;
    }

    public Long ejecutar(Pago pago) {
        this.validarDiasParaPago(pago);
        this.validarExistenciaPrevia(pago);
        return this.repositorioPago.crear(pago);
    }

    private void validarExistenciaPrevia(Pago pago) {
        boolean existe = this.repositorioPago.existe(pago.getIdPropietario(), pago.getIdInmueble(), pago.getAnio());

        if (existe) {
            throw new ExcepcionDuplicidad(EL_PAGO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarDiasParaPago(Pago pago) {
        LocalDate fechaPago = pago.getFechaPago();

        if (fechaPago.getDayOfWeek() == DayOfWeek.SATURDAY || fechaPago.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ExcepcionCrearPago(NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS);
        }
    }

}
