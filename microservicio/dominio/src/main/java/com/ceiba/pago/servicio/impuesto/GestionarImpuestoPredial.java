package com.ceiba.pago.servicio.impuesto;

import com.ceiba.dominio.excepcion.ExcepcionCrearPago;
import com.ceiba.inmueble.puerto.dao.DaoInmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class GestionarImpuestoPredial {

    private final RepositorioInmueble repositorioInmueble;
    private final RepositorioTarifa repositorioTarifa;
    private final DaoInmueble daoInmueble;
    private final DaoTarifa daoTarifa;

    private static final String NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS = "No se permiten pagos los dias sabados o domingos";
    private static final String ERROR_AL_PAGAR_EL_VALOR_A_PAGAR_ES = "Error al pagar, el valor que debe pagar es %s, estas pagando %s";
    private static final String NO_SE_ENCONTRO_TARIFAS = "No se encontro tarifas";

    private static final int DIA_MAXIMO_DESCUENTO = 30;
    private static final Month MES_MAXIMO_DESCUENTO = Month.APRIL;
    private static final double PORCENTAJE_DESCUENTO = 0.1;
    private static final double PORCENTAJE_COBRO_ADICIONAL = 0.1;
    private static final int TARIFA_POR_MIL = 1000;

    private static final LocalDate FECHA_ACTUAL = LocalDate.now();
    private static final int ANIO_ACTUAL = FECHA_ACTUAL.getYear();

    public GestionarImpuestoPredial(RepositorioInmueble repositorioInmueble, RepositorioTarifa repositorioTarifa, DaoInmueble daoInmueble, DaoTarifa daoTarifa) {
        this.repositorioInmueble = repositorioInmueble;
        this.repositorioTarifa = repositorioTarifa;
        this.daoInmueble = daoInmueble;
        this.daoTarifa = daoTarifa;
    }

    public void validarDiasParaPago(Pago pago) {
        LocalDate fechaPago = pago.getFechaPago();

        if (fechaPago.getDayOfWeek() == DayOfWeek.SATURDAY || fechaPago.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ExcepcionCrearPago(NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS);
        }
    }

    public void verificarValorPagado(Pago pago) {

        Long avaluoCatastral = this.obtenerAvaluoCatastralInmueble(pago);
        double tarifa = this.obtenerTarifa(avaluoCatastral, pago.getAnio());

        Long valorPagado = pago.getValorPagado();
        int valorImpuesto = this.calcularImpuesto(avaluoCatastral, tarifa);
        int valorApagar = (int) this.verificarAplicaDescuentoMulta(pago, valorImpuesto);

        if (valorPagado != valorApagar) {
            throw new ExcepcionCrearPago(String.format(ERROR_AL_PAGAR_EL_VALOR_A_PAGAR_ES, valorApagar, valorPagado));
        }
    }

    private double verificarAplicaDescuentoMulta(Pago pago, int valorImpuesto) {
        LocalDate fechaPago = pago.getFechaPago();
        int anio_a_pagar = pago.getAnio();
        double valorApagar = valorImpuesto;

        if (ANIO_ACTUAL == anio_a_pagar) {
            LocalDate fechaMaximaParaDescuento = this.fechaMaximaDescuento();
            boolean aplicarDescuento = this.validarFechasParaDescuento(fechaPago, fechaMaximaParaDescuento);

            if (aplicarDescuento) {
                double descuento = (valorImpuesto * PORCENTAJE_DESCUENTO);
                valorApagar = valorImpuesto - descuento;
            }

        } else {
            double multa = (valorImpuesto * PORCENTAJE_COBRO_ADICIONAL);
            valorApagar = valorImpuesto + multa;
        }

        return valorApagar;
    }


    private boolean validarFechasParaDescuento(LocalDate fechaPago, LocalDate fechaMaximaDescuento) {
        return !fechaPago.isAfter(fechaMaximaDescuento);
    }

    private int calcularImpuesto(Long avaluoCatastral, double tarifa) {

        ImpuestoPredial impuestoPredial = new ValorImpuestoPredial(avaluoCatastral, tarifa, TARIFA_POR_MIL);
        return impuestoPredial.calcular();

    }

    public LocalDate fechaMaximaDescuento() {
        return LocalDate.of(ANIO_ACTUAL, MES_MAXIMO_DESCUENTO, DIA_MAXIMO_DESCUENTO);
    }

    public double obtenerTarifa(Long avaluoCatastral, int anio) {
        double tarifa = daoTarifa.obtenerTarifaPorAvaluoYAnio(avaluoCatastral, anio);

        if (tarifa <= 0) {
            throw new ExcepcionCrearPago(NO_SE_ENCONTRO_TARIFAS);
        }

        return tarifa;
    }

    private Long obtenerAvaluoCatastralInmueble(Pago pago) {
        Long idInmueble = pago.getIdInmueble();

        return this.daoInmueble.obtenerValorCatastral(idInmueble);
    }
}
