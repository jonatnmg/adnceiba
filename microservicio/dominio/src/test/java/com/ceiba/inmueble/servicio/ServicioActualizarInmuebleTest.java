package com.ceiba.inmueble.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.inmueble.testdatabuilder.InmuebleTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarInmuebleTest {

    private static final String EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA = "El inmueble ya existe en el sistema";
    private static final String EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El inmueble no existe en el sistema para actualizar";

    @Test
    public void validarActualizarInmuebleTest() {

        // arrange
        Inmueble inmueble = new InmuebleTestDataBuilder().build();
        RepositorioInmueble repositorioInmueble = Mockito.mock(RepositorioInmueble.class);

        ServicioActualizarInmueble servicioActualizarInmueble = new ServicioActualizarInmueble(repositorioInmueble);
        Mockito.when(repositorioInmueble.existeExcluyendoId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioInmueble.existePorId(Mockito.anyLong())).thenReturn(true);

        // act
        servicioActualizarInmueble.ejecutar(inmueble);

        // assert
        Mockito.verify(repositorioInmueble).actualizar(inmueble);
    }

    @Test
    public void validarInmuebleExistenciaPreviaTest() {

        // arrange
        Inmueble inmueble = new InmuebleTestDataBuilder().build();
        RepositorioInmueble repositorioInmueble = Mockito.mock(RepositorioInmueble.class);
        Mockito.when(repositorioInmueble.existeExcluyendoId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioInmueble.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarInmueble servicioActualizarInmueble = new ServicioActualizarInmueble(repositorioInmueble);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarInmueble.ejecutar(inmueble),
                ExcepcionDuplicidad.class, EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarInmuebleNoExisteTest() {

        // arrange
        Inmueble inmueble = new InmuebleTestDataBuilder().build();
        RepositorioInmueble repositorioInmueble = Mockito.mock(RepositorioInmueble.class);
        Mockito.when(repositorioInmueble.existeExcluyendoId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioInmueble.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarInmueble servicioActualizarInmueble = new ServicioActualizarInmueble(repositorioInmueble);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarInmueble.ejecutar(inmueble),
                ExcepcionSinDatos.class, EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA);
    }
}
