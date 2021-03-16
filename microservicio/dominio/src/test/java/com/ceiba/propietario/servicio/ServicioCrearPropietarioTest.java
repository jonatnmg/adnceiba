package com.ceiba.propietario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.propietario.servicio.testdatabuilder.PropietarioTestDataBuilder;
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
    public void crearEntidadPropietarioTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder();

        // act
        Propietario propietario = propietarioTestDataBuilder.build();

        // assert
        assertEquals(PropietarioTestDataBuilder.NOMBRE_PROPIETARIO, propietario.getNombre());
        assertEquals(PropietarioTestDataBuilder.NUMERO_IDENTIFICACION, propietario.getNumeroIdentificacion());
        assertEquals(PropietarioTestDataBuilder.TELEFONO, propietario.getTelefono());
        assertEquals(PropietarioTestDataBuilder.CORREO, propietario.getCorreo());
        assertEquals(PropietarioTestDataBuilder.DIRECCION, propietario.getDireccion());
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

    @Test
    public void validarNombrePropietarioNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conNombre(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_NOMBRE);
    }

    @Test
    public void validarNumeroIdentificacionPropietarioNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conNumeroIdentificacion(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION);
    }

    @Test
    public void validarTelefonoPropietarioNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conTelefono(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_TELEFONO);
    }

    @Test
    public void validarCorreoPropietarioNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conCorreo(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_CORREO_ELECTRONICO);
    }

    @Test
    public void validarDireccionPropietarioNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conDireccion(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_DIRECCION);
    }

}
