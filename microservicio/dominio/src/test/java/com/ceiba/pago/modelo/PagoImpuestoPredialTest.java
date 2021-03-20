package com.ceiba.pago.modelo;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionCrearPago;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pago.testdatabuilder.PagoImpuestoPredialTestDataBuilder;
import org.junit.Test;

import java.time.LocalDate;

public class PagoImpuestoPredialTest {

    private static final String SE_DEBE_INGRESAR_UN_PROPIETARIO = "Se debe ingresar un identificador de propietario";
    private static final String SE_DEBE_INGRESAR_UN_INMUEBLE = "Se debe ingresar un identificador de inmueble";
    private static final String SE_DEBE_INGRESAR_UN_ANIO = "Se debe ingresar un año";
    private static final String SE_DEBE_INGRESAR_UN_VALOR_PAGADO = "Se debe ingresar un valor pagado";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA = "Se debe ingresar una fecha";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA_CON_EL_FORMATO = "Se debe ingresar una fecha con el formato %s";
    private static final String SE_DEBE_INGRESAR_UNA_TARIFA = "Se debe ingresar un identificador de tarifa";
    private static final String EL_ANIO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El anio debe tener una longitud mayor o igual a %s";
    private static final String NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS = "No se permiten pagos los dias sabados o domingos";

    private static final int ANIO_INCORRECTO = -2021;
    private static final int LONGITUD_MINIMA_ANIO = 4;
    private static final int LONGITUD_ANIO_INCORRECTO = 157;
    private static final Long VALOR_PAGADO_INCORRECTO = -120000000L;

    private static final LocalDate FECHA_NO_PERMITIDA = LocalDate.of(2021, 3, 20);

    @Test
    public void validarPropietarioNuloTest() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conPropietario(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_PROPIETARIO);
    }


    @Test
    public void validarValorPagadoNuloTest() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conValorPagado(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_VALOR_PAGADO);
    }

    @Test
    public void validarInmuebleNuloTest() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conInmueble(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_INMUEBLE);
    }

    @Test
    public void validarFechaPagoNuloTest() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conFechaPago(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UNA_FECHA);
    }

    @Test
    public void validarValorTarifaNuloTest() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conTarifa(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UNA_TARIFA);
    }

    @Test
    public void verificarDiasParaPagoTest() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conFechaPago(FECHA_NO_PERMITIDA);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionCrearPago.class, NO_SE_PERMITEN_PAGOS_LOS_DIAS_SABADOS_O_DOMINGOS);
    }

    @Test
    public void verificarAnioPositivoTest() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conAnio(ANIO_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UN_ANIO);
    }

    @Test
    public void validarValorPagadoPositivoTest() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conValorPagado(VALOR_PAGADO_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UN_VALOR_PAGADO);
    }

    @Test
    public void verificarLongitudAnio4Test() {
        // arrange
        PagoImpuestoPredialTestDataBuilder pagoImpuestoPredialTestDataBuilder = new PagoImpuestoPredialTestDataBuilder()
                .conAnio(LONGITUD_ANIO_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoImpuestoPredialTestDataBuilder.build(),
                ExcepcionLongitudValor.class, String.format(EL_ANIO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ANIO));
    }

}
