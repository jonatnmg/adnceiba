package com.ceiba.pago.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pago.servicio.testdatabuilder.PagoTestDataBuilder;
import org.junit.Test;

public class ServicioPagoInmpuestoPredialImpuestoPredialTest {

    private static final String SE_DEBE_INGRESAR_UN_PROPIETARIO = "Se debe ingresar un identificador de propietario";
    private static final String SE_DEBE_INGRESAR_UN_INMUEBLE = "Se debe ingresar un identificador de inmueble";
    private static final String SE_DEBE_INGRESAR_UN_ANIO = "Se debe ingresar un año";
    private static final String SE_DEBE_INGRESAR_UN_VALOR_PAGADO = "Se debe ingresar un valor pagado";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA = "Se debe ingresar una fecha";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA_CON_EL_FORMATO = "Se debe ingresar una fecha con el formato %s";

    private static final int ANIO_INCORRECTO = 0;
    private static final String FORMATO_FECHA_CORRECTO = "d/MM/yyyy";

    @Test
    public void validarPropietarioNuloTest() {
        // arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder()
                .conIdPropietario(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_PROPIETARIO);
    }

    @Test
    public void validarInmuebleNuloTest() {
        // arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder()
                .conIdInmueble(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_INMUEBLE);
    }

    @Test
    public void validarValorPagadoNuloTest() {
        // arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder()
                .conValorPagado(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_VALOR_PAGADO);
    }


    @Test
    public void validarAnioPositivoTest() {
        // arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder()
                .conAnio(ANIO_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> pagoTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UN_ANIO);
    }
}
