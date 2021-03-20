package com.ceiba.propietario.servicio;

import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.propietario.testdatabuilder.PropietarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarPropietarioTest {

    @Test
    public void validarEliminarPropietarioTest() {

        // arrange
        Propietario propietario = new PropietarioTestDataBuilder().build();
        RepositorioPropietario repositorioPropietario = Mockito.mock(RepositorioPropietario.class);
        RepositorioInmueble repositorioInmueble = Mockito.mock(RepositorioInmueble.class);
        RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial = Mockito.mock(RepositorioPagoImpuestoPredial.class);

        ServicioEliminarPropietario servicioEliminarPropietario = new ServicioEliminarPropietario(repositorioPropietario, repositorioInmueble, repositorioPagoImpuestoPredial);

        Mockito.when(repositorioPropietario.existePorId(propietario.getId())).thenReturn(true);
        Mockito.when(repositorioInmueble.existePropietarioEnInmueble(propietario.getId())).thenReturn(false);
        Mockito.when(repositorioPagoImpuestoPredial.existePropietarioEnPagoImpuestoPredial(propietario.getId())).thenReturn(false);

        // act
        servicioEliminarPropietario.ejecutar(propietario.getId());

        // assert
        Mockito.verify(repositorioPropietario).eliminar(propietario.getId());
    }
}
