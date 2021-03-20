package com.ceiba.tarifa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.testdatabuilder.TarifaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarTarifaTest {

    private static final String ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA = "Este rango de avaluo ya existe en el sistema";
    private static final String TARIFA_NO_SE_ENCONTRO_EN_EL_SISTEMA = "Tarifa no encontrada en el sistema";

    @Test
    public void validarActualizarTarifaTest() {

        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder().build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);

        ServicioActualizarTarifa servicioActualizarTarifa = new ServicioActualizarTarifa(repositorioTarifa);

        Mockito.when(repositorioTarifa.existeExcluyendoId(tarifa.getId(), tarifa.getAvaluoMinimo(), tarifa.getAvaluoMinimo(), tarifa.getAnio())).thenReturn(false);
        Mockito.when(repositorioTarifa.existePorId(tarifa.getId())).thenReturn(true);

        // act
        servicioActualizarTarifa.ejecutar(tarifa);

        // assert
        Mockito.verify(repositorioTarifa).actualizar(tarifa);
    }

    @Test
    public void validarExistenciaPreviaTest() {

        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder().build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);

        Mockito.when(repositorioTarifa.existePorId(tarifa.getId())).thenReturn(true);
        Mockito.when(repositorioTarifa.existeExcluyendoId(tarifa.getId(), tarifa.getAvaluoMinimo(), tarifa.getAvaluoMaximo(), tarifa.getAnio())).thenReturn(true);

        ServicioActualizarTarifa servicioActualizarTarifa = new ServicioActualizarTarifa(repositorioTarifa);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarTarifa.ejecutar(tarifa),
                ExcepcionDuplicidad.class, ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarTarifaNoExisteTest() {

        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder().build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);

        Mockito.when(repositorioTarifa.existePorId(tarifa.getId())).thenReturn(false);

        ServicioActualizarTarifa servicioActualizarTarifa = new ServicioActualizarTarifa(repositorioTarifa);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarTarifa.ejecutar(tarifa),
                ExcepcionSinDatos.class, TARIFA_NO_SE_ENCONTRO_EN_EL_SISTEMA);
    }

}
