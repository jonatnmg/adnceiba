package com.ceiba.propietario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.propietario.servicio.testdatabuilder.PropietarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPropietarioTest {

    private static final String EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA = "El propietario ya existe en el sistema";

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
