package com.ceiba.tarifa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.servicio.testdatabuilder.TarifaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearTarifaTest {

    private static final String ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA = "Este rango de avaluo ya existe en el sistema";
    private static final String SE_DEBE_INGRESAR_AVALUO_MINIMO = "Se debe ingresar un avaluo minimo";
    private static final String SE_DEBE_INGRESAR_AVALUO_MAXIMO = "Se debe ingresar un avaluo maximo";
    private static final String SE_DEBE_INGRESAR_UNA_TARIFA = "Se debe ingresar una tarifa";
    private static final String SE_DEBE_INGRESAR_UN_ANIO = "Se debe ingresar un año";
    private static final String EL_RANGO_DE_AVALUO_INCORRECTO = "Rango de avaluo incorrecto";

    private static final double VALOR_TARIFA_INCORRECTO = 0d;
    private static final int VALOR_ANIO_INCORRECTO = -2015;
    private static final long AVALUO_MINIMO_INCORRECTO = 20000000;
    private static final long AVALUO_MAXIMO_INCORRECTO = 10000000;

    @Test
    public void validarExistenciaTarifaTest() {

        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder().build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        Mockito.when(repositorioTarifa.existe(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyInt())).thenReturn(true);
        ServicioCrearTarifa servicioCrearTarifa = new ServicioCrearTarifa(repositorioTarifa);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioCrearTarifa.ejecutar(tarifa),
                ExcepcionDuplicidad.class, ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarAvaluoMinimoNuloTest() {
        // arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder()
                .conAvaluoMinimo(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> tarifaTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_AVALUO_MINIMO);
    }

    @Test
    public void validarAvaluoMaximoNuloTest() {
        // arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder()
                .conAvaluoMaximo(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> tarifaTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_AVALUO_MAXIMO);
    }


    @Test
    public void validarValorTarifaPositivoTest() {
        // arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder()
                .conValor(VALOR_TARIFA_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> tarifaTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UNA_TARIFA);
    }

    @Test
    public void validarAnioPositivoTest() {
        // arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder()
                .conAnio(VALOR_ANIO_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> tarifaTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UN_ANIO);
    }

    @Test
    public void validarRangoAvaluoIncorrectoTest() {
        // arrange
        TarifaTestDataBuilder tarifaTestDataBuilder = new TarifaTestDataBuilder()
                .conAvaluoMinimo(AVALUO_MINIMO_INCORRECTO)
                .conAvaluoMaximo(AVALUO_MAXIMO_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> tarifaTestDataBuilder.build(),
                ExcepcionValorInvalido.class, EL_RANGO_DE_AVALUO_INCORRECTO);
    }
}
