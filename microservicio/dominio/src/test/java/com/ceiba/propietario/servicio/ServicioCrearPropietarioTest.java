package com.ceiba.propietario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.propietario.testdatabuilder.PropietarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPropietarioTest {

    private static final String EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA = "El propietario ya existe en el sistema";

    @Test
    public void validarCreacionPropietarioTest() {

        // arrange
        Long id_esperado = 1L;
        Propietario propietario = new PropietarioTestDataBuilder().build();
        RepositorioPropietario repositorioPropietario = Mockito.mock(RepositorioPropietario.class);

        ServicioCrearPropietario servicioCrearPropietario = new ServicioCrearPropietario(repositorioPropietario);

        Mockito.when(repositorioPropietario.existePorNumeroIdentificacion(propietario.getNumeroIdentificacion())).thenReturn(false);
        Mockito.when(repositorioPropietario.crear(propietario)).thenReturn(id_esperado);

        // act
        Long idPropietario = servicioCrearPropietario.ejecutar(propietario);

        // assert
        BasePrueba.assertEqualsObject(id_esperado, idPropietario);

    }

    @Test
    public void validarPropietarioExistenciaPreviaTest() {
        // arrange
        Propietario propietario = new PropietarioTestDataBuilder().build();
        RepositorioPropietario repositorioPropietario = Mockito.mock(RepositorioPropietario.class);
        Mockito.when(repositorioPropietario.existePorNumeroIdentificacion(Mockito.anyString())).thenReturn(true);
        ServicioCrearPropietario servicioCrearPropietario = new ServicioCrearPropietario(repositorioPropietario);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioCrearPropietario.ejecutar(propietario),
                ExcepcionDuplicidad.class, EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA);
    }

}
