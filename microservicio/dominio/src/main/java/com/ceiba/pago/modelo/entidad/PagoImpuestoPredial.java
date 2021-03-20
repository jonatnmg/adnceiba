package com.ceiba.pago.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionCrearPago;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.pago.servicio.impuestopredial.ValorImpuestoPredial;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

@Getter
public class PagoImpuestoPredial {

    private static final String SE_DEBE_INGRESAR_UN_PROPIETARIO = "Se debe ingresar un identificador de propietario";
    private static final String SE_DEBE_INGRESAR_UN_INMUEBLE = "Se debe ingresar un identificador de inmueble";
    private static final String SE_DEBE_INGRESAR_UNA_TARIFA = "Se debe ingresar un identificador de tarifa";
    private static final String SE_DEBE_INGRESAR_UN_ANIO = "Se debe ingresar un año";
    private static final String SE_DEBE_INGRESAR_UN_VALOR_PAGADO = "Se debe ingresar un valor pagado";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA = "Se debe ingresar una fecha";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA_CON_EL_FORMATO = "Se debe ingresar una fecha con el formato %s";

    private static final String EL_ANIO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El anio debe tener una longitud mayor o igual a %s";
    private static final String NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS = "No se permiten pagos los dias sabados o domingos";
    private static final String ERROR_AL_PAGAR_EL_VALOR_A_PAGAR_ES = "Error al pagar, el valor que debe pagar es %s, estas pagando %s";

    private static final int LONGITUD_MINIMA_ANIO = 4;
    private static final LocalDate FECHA_ACTUAL = LocalDate.now();
    private static final int ANIO_ACTUAL = FECHA_ACTUAL.getYear();

    private static final double PORCENTAJE_DESCUENTO = 0.1;
    private static final double PORCENTAJE_COBRO_ADICIONAL = 0.1;
    private static final int TARIFA_POR_MIL = 1000;

    private static final int DIA_MAXIMO_DESCUENTO = 30;
    private static final Month MES_MAXIMO_DESCUENTO = Month.APRIL;

    private Long id;
    private Propietario propietario;
    private Inmueble inmueble;
    private Tarifa tarifa;
    private int anio;
    private Long valorPagado;
    private LocalDate fechaPago;

    public PagoImpuestoPredial(Long id, Propietario propietario, Inmueble inmueble, int anio, Long valorPagado, LocalDate fechaPago, Tarifa tarifa) {
        
        ValidadorArgumento.validarObligatorio(propietario, SE_DEBE_INGRESAR_UN_PROPIETARIO);
        ValidadorArgumento.validarObligatorio(inmueble, SE_DEBE_INGRESAR_UN_INMUEBLE);
        ValidadorArgumento.validarObligatorio(valorPagado, SE_DEBE_INGRESAR_UN_VALOR_PAGADO);
        ValidadorArgumento.validarObligatorio(fechaPago, SE_DEBE_INGRESAR_UNA_FECHA);
        ValidadorArgumento.validarObligatorio(tarifa, SE_DEBE_INGRESAR_UNA_TARIFA);

        ValidadorArgumento.validarPositivo(anio, SE_DEBE_INGRESAR_UN_ANIO);
        ValidadorArgumento.validarPositivo(valorPagado, SE_DEBE_INGRESAR_UN_VALOR_PAGADO);

        ValidadorArgumento.validarLongitudMinima(anio, LONGITUD_MINIMA_ANIO, String.format(EL_ANIO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ANIO));

        this.validarDiasParaPago(fechaPago);
        this.verificarValorPagado(inmueble.getAvaluoCatastral(), tarifa.getValor(), valorPagado, fechaPago, anio);

        this.id = id;
        this.propietario = propietario;
        this.inmueble = inmueble;
        this.tarifa = tarifa;
        this.anio = anio;
        this.valorPagado = valorPagado;
        this.fechaPago = fechaPago;

    }

    private void verificarValorPagado(Long avaluoCatastral, double tarifa, Long valorPagado, LocalDate fechaPago, int anio) {

        int valorImpuesto = this.calcularImpuesto(avaluoCatastral, tarifa);
        int valorApagar = (int) this.obtenerValorApagar(fechaPago, anio, valorImpuesto);

        if (valorPagado != valorApagar) {
            throw new ExcepcionCrearPago(String.format(ERROR_AL_PAGAR_EL_VALOR_A_PAGAR_ES, valorApagar, valorPagado));
        }
    }

    private LocalDate fechaMaximaDescuento() {
        return LocalDate.of(ANIO_ACTUAL, MES_MAXIMO_DESCUENTO, DIA_MAXIMO_DESCUENTO);
    }

    private void validarDiasParaPago(LocalDate fechaPago) {
        if (fechaPago.getDayOfWeek() == DayOfWeek.SATURDAY || fechaPago.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ExcepcionCrearPago(NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS);
        }
    }

    private double obtenerValorApagar(LocalDate fechaPago, int anio_a_pagar, int valorImpuesto) {
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

        ValorImpuestoPredial impuestoPredial = new ValorImpuestoPredial(avaluoCatastral, tarifa, TARIFA_POR_MIL);
        return impuestoPredial.calcular();

    }
}
