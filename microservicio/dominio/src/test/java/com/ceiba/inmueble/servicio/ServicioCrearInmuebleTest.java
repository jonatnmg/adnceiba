package com.ceiba.inmueble.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.inmueble.servicio.testdatabuilder.InmuebleTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearInmuebleTest {

    private static final String EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA = "El inmueble ya existe en el sistema";

    private static final String SE_DEBE_INGRESAR_NUMERO_PREDIAL = "Se debe ingresar el numero predial";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar una direccion";
    private static final String SE_DEBE_INGRESAR_AVALUO_CATASTRAL = "Se debe ingresar avaluo catastral";

    private static final String EL_PROPIETARIO_ES_OBLIGATORIO = "Debe ingresar un ID de propietario";
    private static final String EL_AREA_CONSTRUIDA_DEBE_SER_MAYOR_O_IGUAL_A = "El area construida debe ser mayor o igual a %s";
    private static final int VALOR_MINIMO_AREA_CONSTRUIDA = 0;
    private static final String EL_AREA_TOTAL_DEBE_SER_MAYOR_O_IGUAL_A = "El area total debe ser mayor o igual a %s";

    private static final int AVALUO_CATASTRAL_INCORRECTO = -1000000;
    private static final Long NUMERO_PREDIAL_INCORRECTO = -1005554L;
    private static final Long ID_PROPIETARIO_INCORRECTO = 0L;
    private static final int AREA_CONSTRUIDA_INCORRECTO = -140;
    private static final int AREA_TOTAL_INCORRECTO = -140;
    private static final int VALOR_MINIMO_AREA_TOTAL = 1;

    @Test
    public void validarInmuebleExistenciaPreviaTest() {

        // arrange
        Inmueble inmueble = new InmuebleTestDataBuilder().build();
        RepositorioInmueble repositorioInmueble = Mockito.mock(RepositorioInmueble.class);
        Mockito.when(repositorioInmueble.existe(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioCrearInmueble servicioCrearInmueble = new ServicioCrearInmueble(repositorioInmueble);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioCrearInmueble.ejecutar(inmueble),
                ExcepcionDuplicidad.class, EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarDireccionNuloTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conDireccion(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_DIRECCION);
    }

    @Test
    public void validarNumeroPredialNuloTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conNumeroPredial(null);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_NUMERO_PREDIAL);
    }


    @Test
    public void validarNumeroPredialPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conNumeroPredial(NUMERO_PREDIAL_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_NUMERO_PREDIAL);
    }


    @Test
    public void validarAvaluoCatastralPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conAvaluoCatastral(AVALUO_CATASTRAL_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_AVALUO_CATASTRAL);
    }


    @Test
    public void validarAreaConstruidaPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conAreaConstruida(AREA_CONSTRUIDA_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, String.format(EL_AREA_CONSTRUIDA_DEBE_SER_MAYOR_O_IGUAL_A, VALOR_MINIMO_AREA_CONSTRUIDA));
    }

    @Test
    public void validarAreaTotalPositivoTest() {
        // arrange
        InmuebleTestDataBuilder inmuebleTestDataBuilder = new InmuebleTestDataBuilder()
                .conAreaTotal(AREA_TOTAL_INCORRECTO);

        // act - assert
        BasePrueba.assertThrows(
                () -> inmuebleTestDataBuilder.build(),
                ExcepcionValorInvalido.class, String.format(EL_AREA_TOTAL_DEBE_SER_MAYOR_O_IGUAL_A, VALOR_MINIMO_AREA_TOTAL));
    }
}
