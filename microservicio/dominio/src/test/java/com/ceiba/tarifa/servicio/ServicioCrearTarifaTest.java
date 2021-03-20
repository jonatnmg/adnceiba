package com.ceiba.tarifa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.testdatabuilder.TarifaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearTarifaTest {

    private static final String ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA = "Este rango de avaluo ya existe en el sistema";

    @Test
    public void validarCreacionTarifaTest() {

        // arrange
        Long id_esperado = 1L;
        Tarifa tarifa = new TarifaTestDataBuilder().build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);

        ServicioCrearTarifa servicioCrearTarifa = new ServicioCrearTarifa(repositorioTarifa);

        Mockito.when(repositorioTarifa.existe(tarifa.getAvaluoMinimo(), tarifa.getAvaluoMinimo(), tarifa.getAnio())).thenReturn(false);
        Mockito.when(repositorioTarifa.crear(tarifa)).thenReturn(id_esperado);

        // act
        Long idTarifa = servicioCrearTarifa.ejecutar(tarifa);

        // assert
        BasePrueba.assertEqualsObject(id_esperado, idTarifa);
    }

    @Test
    public void validarExistenciaTarifaTest() {

        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder().build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        Mockito.when(repositorioTarifa.existe(tarifa.getAvaluoMinimo(), tarifa.getAvaluoMaximo(), tarifa.getAnio())).thenReturn(true);
        ServicioCrearTarifa servicioCrearTarifa = new ServicioCrearTarifa(repositorioTarifa);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioCrearTarifa.ejecutar(tarifa),
                ExcepcionDuplicidad.class, ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA);
    }


}
