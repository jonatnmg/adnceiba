package com.ceiba.propietario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.propietario.testdatabuilder.PropietarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarPropietarioTest {

    private static final String EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA = "El propietario ya existe en el sistema";
    private static final String EL_PROPIETARIO_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El propietario no se encontro en el sistema";

    @Test
    public void validarActualizacionPropietarioTest() {

        // arrange
        Long id_esperado = 1L;
        Propietario propietario = new PropietarioTestDataBuilder().build();
        RepositorioPropietario repositorioPropietario = Mockito.mock(RepositorioPropietario.class);

        ServicioActualizarPropietario servicioActualizarPropietario = new ServicioActualizarPropietario(repositorioPropietario);

        Mockito.when(repositorioPropietario.existeExcluyendoId(propietario.getId(), propietario.getNumeroIdentificacion())).thenReturn(false);
        Mockito.when(repositorioPropietario.existePorId(propietario.getId())).thenReturn(true);
        Mockito.when(repositorioPropietario.crear(propietario)).thenReturn(id_esperado);

        // act
        servicioActualizarPropietario.ejecutar(propietario);

        // assert
        Mockito.verify(repositorioPropietario).actualizar(propietario);

    }

    @Test
    public void validarExistenciaPreviaTest() {

        // arrange
        Long id_esperado = 1L;
        Propietario propietario = new PropietarioTestDataBuilder().build();
        RepositorioPropietario repositorioPropietario = Mockito.mock(RepositorioPropietario.class);
        Mockito.when(repositorioPropietario.existeExcluyendoId(propietario.getId(), propietario.getNumeroIdentificacion())).thenReturn(true);
        Mockito.when(repositorioPropietario.existePorId(propietario.getId())).thenReturn(true);
        Mockito.when(repositorioPropietario.crear(propietario)).thenReturn(id_esperado);

        ServicioActualizarPropietario servicioActualizarPropietario = new ServicioActualizarPropietario(repositorioPropietario);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarPropietario.ejecutar(propietario),
                ExcepcionDuplicidad.class, EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarPropietarioNoExisteTest() {

        // arrange
        Long id_esperado = 1L;
        Propietario propietario = new PropietarioTestDataBuilder().build();
        RepositorioPropietario repositorioPropietario = Mockito.mock(RepositorioPropietario.class);
        Mockito.when(repositorioPropietario.existeExcluyendoId(propietario.getId(), propietario.getNumeroIdentificacion())).thenReturn(false);
        Mockito.when(repositorioPropietario.existePorId(propietario.getId())).thenReturn(false);
        Mockito.when(repositorioPropietario.crear(propietario)).thenReturn(id_esperado);

        ServicioActualizarPropietario servicioActualizarPropietario = new ServicioActualizarPropietario(repositorioPropietario);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarPropietario.ejecutar(propietario),
                ExcepcionSinDatos.class, EL_PROPIETARIO_NO_SE_ENCONTRO_EN_EL_SISTEMA);
    }
}
