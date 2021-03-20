package com.ceiba.inmueble.modelo;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.inmueble.testdatabuilder.InmuebleTestDataBuilder;
import org.junit.Test;

public class InmuebleTest {

    private static final String SE_DEBE_INGRESAR_NUMERO_PREDIAL = "Se debe ingresar el numero predial";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar una direccion";
    private static final String SE_DEBE_INGRESAR_AREA_TOTAL = "Se debe ingresar area total";
    private static final String SE_DEBE_INGRESAR_AVALUO_CATASTRAL = "Se debe ingresar avaluo catastral";
    private static final String EL_AREA_CONSTRUIDA_NO_DEBE_SER_MAYOR_A_AREA_TOTAL = "El area construida no debe ser mayor al area total";
    private static final String EL_PROPIETARIO_ES_OBLIGATORIO = "Debe ingresar un ID de propietario";

    private static final String EL_NUMERO_PREDIAL_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El numero predial debe tener una longitud mayor o igual a %s";
    private static final String LA_LONGITUD_DE_LADIRECCION_DEBE_SER_MAYOR_O_IGUAL_ADIRECCION_DEBE_SER_MAYOR_O_IGUAL_A = "La longitud de la direccion debe ser mayor o igual a %s";

    private static final long AVALUO_CATASTRAL_INCORRECTO = -1000000L;
    private static final Long NUMERO_PREDIAL_INCORRECTO = -1005554L;
    private static final Long NUMERO_PREDIAL_INCORRECTO_LONGITUD = 123L;
    private static final int LONGITUD_MINIMA_NUMERO_PREDIAL = 6;
    private static final int AREA_CONSTRUIDA_INCORRECTO = -140;
    private static final int AREA_TOTAL_INCORRECTO = -140;
    private static final String DIRECCION_INCORRECTA_LONGITUD = "Di";
    private static final int AREA_TOTAL = 120;
    private static final int AREA_CONSTRUIDA = 130;
    private static final int LONGITUD_MINIMA_DIRECCION = 3;


    @Test
    public void validarPropietarioNuloTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conPropietario(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, EL_PROPIETARIO_ES_OBLIGATORIO);
    }

    @Test
    public void validarNumeroPredialNuloTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conNumeroPredial(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_NUMERO_PREDIAL);
    }

    @Test
    public void validarNumeroPredialPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conNumeroPredial(NUMERO_PREDIAL_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_NUMERO_PREDIAL);
    }

    @Test
    public void validarDireccionNuloTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conDireccion(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_DIRECCION);
    }


    @Test
    public void validarAreaTotalPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conAreaTotal(AREA_TOTAL_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_AREA_TOTAL);
    }

    @Test
    public void validaDireccionLongitudMinima3Test() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conDireccion(DIRECCION_INCORRECTA_LONGITUD);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionLongitudValor.class, String.format(LA_LONGITUD_DE_LADIRECCION_DEBE_SER_MAYOR_O_IGUAL_ADIRECCION_DEBE_SER_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_DIRECCION));
    }

    @Test
    public void validaNumeroPredialLongitudMinima6Test() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conNumeroPredial(NUMERO_PREDIAL_INCORRECTO_LONGITUD);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionLongitudValor.class, String.format(EL_NUMERO_PREDIAL_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_NUMERO_PREDIAL));
    }

    @Test
    public void validarAreaConstruidaPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conAreaTotal(AREA_CONSTRUIDA_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_AREA_TOTAL);
    }

    @Test
    public void validarAvaluoCatastralPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conAvaluoCatastral(AVALUO_CATASTRAL_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_AVALUO_CATASTRAL);
    }

    @Test
    public void validarAreaConstruidaMenorAreaTotalPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conAreaConstruida(AREA_CONSTRUIDA)
                .conAreaTotal(AREA_TOTAL);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, EL_AREA_CONSTRUIDA_NO_DEBE_SER_MAYOR_A_AREA_TOTAL);
    }
}
