package com.ceiba.inmueble.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.inmueble.testdatabuilder.InmuebleTestDataBuilder;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarInmuebleTest {

    private static final String EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El inmueble no existe en el sistema para actualizar";

    @Test
    public void eliminarInmuebleTest() {

        // arrange
        Inmueble inmueble = new InmuebleTestDataBuilder().build();
        RepositorioInmueble repositorioInmueble = Mockito.mock(RepositorioInmueble.class);
        RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial = Mockito.mock(RepositorioPagoImpuestoPredial.class);

        ServicioEliminarInmueble servicioEliminarInmueble = new ServicioEliminarInmueble(repositorioInmueble, repositorioPagoImpuestoPredial);
        Mockito.when(repositorioInmueble.existePorId(inmueble.getId())).thenReturn(true);
        Mockito.when(repositorioInmueble.existePropietarioEnInmueble(inmueble.getId())).thenReturn(false);

        // act
        servicioEliminarInmueble.ejecutar(inmueble.getId());

        // assert
        Mockito.verify(repositorioInmueble).eliminar(inmueble.getId());
    }

    @Test
    public void validarInmuebleNoExisteTest() {

        // arrange
        Inmueble inmueble = new InmuebleTestDataBuilder().build();
        RepositorioInmueble repositorioInmueble = Mockito.mock(RepositorioInmueble.class);
        Mockito.when(repositorioInmueble.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarInmueble servicioActualizarInmueble = new ServicioActualizarInmueble(repositorioInmueble);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarInmueble.ejecutar(inmueble),
                ExcepcionSinDatos.class, EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA);
    }
}
