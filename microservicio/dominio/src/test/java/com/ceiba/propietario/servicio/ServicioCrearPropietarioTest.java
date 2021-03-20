package com.ceiba.propietario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.propietario.testdatabuilder.PropietarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class ServicioCrearPropietarioTest {

    private static final String EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA = "El propietario ya existe en el sistema";
    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre del propietario";
    private static final String SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION = "Se debe ingresar el numero identificacion del propietario";
    private static final String SE_DEBE_INGRESAR_TELEFONO = "Se debe ingresar el numero de telefono del propietario";
    private static final String SE_DEBE_INGRESAR_CORREO_ELECTRONICO = "Se debe ingresar el correo electronico del propietario";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar la dirección del propietario";


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
