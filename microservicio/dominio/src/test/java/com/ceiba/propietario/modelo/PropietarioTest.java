package com.ceiba.propietario.modelo;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.testdatabuilder.PropietarioTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PropietarioTest {

    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre del propietario";
    private static final String SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION = "Se debe ingresar el numero identificacion del propietario";
    private static final String SE_DEBE_INGRESAR_TELEFONO = "Se debe ingresar el numero de telefono del propietario";
    private static final String SE_DEBE_INGRESAR_CORREO_ELECTRONICO = "Se debe ingresar el correo electronico del propietario";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar la dirección del propietario";

    private static final String EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El nombre debe tener una longitud mayor o igual a %s";
    private static final String EL_NUMERO_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El numero identificacion debe tener una longitud mayor o igual a %s";
    private static final String EL_NUMERO_TELEFONO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El numero telefono debe tener una longitud mayor o igual a %s";

    private static final String DEBE_INGRESAR_CORREO_ELECTRONICO_VALIDO = "Debe ingresar un formato de correo valido";

    private static final int LONGITUD_MINIMA_ARGUMENTOS = 3;
    private static final String FORMATO_CORREO_INCORRECTO = "defaultmail.com";
    private static final String NOMBRE_LONGITUD_INCORRECTA = "Li";
    private static final String NUMERO_IDENTIFICACION_LONGITUD_INCORRECTA = "Li";
    private static final String TELEFONO_LONGITUD_INCORRECTA = "21";

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
    public void validarNombreNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conNombre(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_NOMBRE);
    }

    @Test
    public void validarNumeroIdentificacionNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conNumeroIdentificacion(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION);
    }

    @Test
    public void validarTelefonoNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conTelefono(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_TELEFONO);
    }

    @Test
    public void validarCorreoNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conCorreo(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_CORREO_ELECTRONICO);
    }

    @Test
    public void validarDireccionNuloTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conDireccion(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_DIRECCION);
    }

    @Test
    public void validarFormatoCorreoTest() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conCorreo(FORMATO_CORREO_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionValorInvalido.class, DEBE_INGRESAR_CORREO_ELECTRONICO_VALIDO);
    }

    @Test
    public void validarLongitudNombre3Test() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conNombre(NOMBRE_LONGITUD_INCORRECTA);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionLongitudValor.class, String.format(EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ARGUMENTOS));
    }

    @Test
    public void validarLongitudNumeroIdentificacion3Test() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conNumeroIdentificacion(NUMERO_IDENTIFICACION_LONGITUD_INCORRECTA);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionLongitudValor.class, String.format(EL_NUMERO_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ARGUMENTOS));
    }

    @Test
    public void validarLongitudTelefono3Test() {
        // arrange
        PropietarioTestDataBuilder propietarioTestDataBuilder = new PropietarioTestDataBuilder()
                .conTelefono(TELEFONO_LONGITUD_INCORRECTA);

        // act - assert
        BasePrueba.assertThrows(
                () -> propietarioTestDataBuilder.build(),
                ExcepcionLongitudValor.class, String.format(EL_NUMERO_TELEFONO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ARGUMENTOS));
    }
}
