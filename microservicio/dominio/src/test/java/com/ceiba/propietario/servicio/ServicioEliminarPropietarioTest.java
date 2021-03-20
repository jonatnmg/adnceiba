package com.ceiba.propietario.servicio;

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

        ServicioEliminarPropietario servicioEliminarPropietario = new ServicioEliminarPropietario(repositorioPropietario);
        Mockito.when(repositorioPropietario.existePorId(propietario.getId())).thenReturn(true);

        // act
        servicioEliminarPropietario.ejecutar(propietario.getId());

        // assert
        Mockito.verify(repositorioPropietario).eliminar(propietario.getId());
    }
}
