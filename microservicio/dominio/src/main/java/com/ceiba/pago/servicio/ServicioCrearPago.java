package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionCrearPago;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class ServicioCrearPago {

    private final RepositorioPago repositorioPago;

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";
    private static final String NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS = "No se permiten pagos los dias sabados o domingos";
    private static final LocalDate FECHA_ACTUAL = LocalDate.now();
    private static final int ANIO_ACTUAL = FECHA_ACTUAL.getYear();

    private static final int DIA_MAXIMO_DESCUENTO = 30;
    private static final Month MES_MAXIMO_DESCUENTO = Month.APRIL;

    private static final double PORCENTAJE_DESCUENTO = 0.1;
    private static final double PORCENTAJE_NO_DESCUENTO = 0;

    public ServicioCrearPago(RepositorioPago repositorioPago) {
        this.repositorioPago = repositorioPago;
    }

    public Long ejecutar(Pago pago) {

        this.validarDiasParaPago(pago);
        double descuentoAplicar = this.validarAplicarDescuento(pago);
        System.out.println("descuentoAplicar = " + descuentoAplicar);

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

    private double validarAplicarDescuento(Pago pago) {
        LocalDate fechaPago = pago.getFechaPago();
        int anio_a_pagar = pago.getAnio();

        if (ANIO_ACTUAL == anio_a_pagar) {
            LocalDate fechaMaximaParaDescuento = this.fechaMaximaDescuento();
            boolean aplicarDescuento = this.validarFechasParaDescuento(fechaPago, fechaMaximaParaDescuento);

            return aplicarDescuento ? PORCENTAJE_DESCUENTO : PORCENTAJE_NO_DESCUENTO;
        }

        return PORCENTAJE_NO_DESCUENTO;
    }

    private LocalDate fechaMaximaDescuento() {
        return LocalDate.of(ANIO_ACTUAL, MES_MAXIMO_DESCUENTO, DIA_MAXIMO_DESCUENTO);
    }

    private boolean validarFechasParaDescuento(LocalDate fechaPago, LocalDate fechaMaximaDescuento) {
        return !fechaPago.isAfter(fechaMaximaDescuento);
    }

}
