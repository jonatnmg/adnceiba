package com.ceiba.inmueble.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.inmueble.testdatabuilder.InmuebleTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearInmuebleTest {

    private static final String EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA = "El inmueble ya existe en el sistema";
    private static final Long NUMERO_PREDIAL_INCORRECTO = -1005554L;

    @Test
    public void validarCrearInmuebleTest() {

        // arrange
        Long id_esperado = 1L;
        Inmueble inmueble = new InmuebleTestDataBuilder().build();
        RepositorioInmueble repositorioInmueble = Mockito.mock(RepositorioInmueble.class);

        ServicioCrearInmueble servicioCrearInmueble = new ServicioCrearInmueble(repositorioInmueble);

        Mockito.when(repositorioInmueble.existe(inmueble.getNumeroPredial(), inmueble.getDireccion())).thenReturn(false);
        Mockito.when(repositorioInmueble.crear(inmueble)).thenReturn(id_esperado);

        // act
        Long idInmueble = servicioCrearInmueble.ejecutar(inmueble);

        // assert
        BasePrueba.assertEqualsObject(id_esperado, idInmueble);

    }

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

}
