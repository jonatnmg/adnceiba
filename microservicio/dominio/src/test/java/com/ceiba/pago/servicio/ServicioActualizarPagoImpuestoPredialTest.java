package com.ceiba.pago.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.pago.testdatabuilder.PagoImpuestoPredialTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarPagoImpuestoPredialTest {

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";
    private static final Long VALOR_PAGADO = 396000L;

    @Test
    public void actualizarPagoImpuestoPredialTest() {

        // arrange
        Long id_esperado = 1L;
        PagoImpuestoPredial pagoImpuestoPredial = new PagoImpuestoPredialTestDataBuilder()
                .conValorPagado(VALOR_PAGADO)
                .build();

        RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial = Mockito.mock(RepositorioPagoImpuestoPredial.class);

        ServicioActualizarPagoImpuestoPredial servicioActualizarPagoImpuestoPredial = new ServicioActualizarPagoImpuestoPredial(repositorioPagoImpuestoPredial);

        Mockito.when(
                repositorioPagoImpuestoPredial.existeExcluyendoId(
                        pagoImpuestoPredial.getId(),
                        pagoImpuestoPredial.getPropietario().getId(),
                        pagoImpuestoPredial.getInmueble().getId(),
                        pagoImpuestoPredial.getAnio())).thenReturn(false);

        Mockito.when(repositorioPagoImpuestoPredial.crear(pagoImpuestoPredial)).thenReturn(id_esperado);

        // act
        servicioActualizarPagoImpuestoPredial.ejecutar(pagoImpuestoPredial);

        // assert
        Mockito.verify(repositorioPagoImpuestoPredial).actualizar(pagoImpuestoPredial);
    }

    @Test
    public void validarExistenciaPreviaPagoImpuestoPredialTest() {

        // arrange
        Long id_esperado = 1L;
        PagoImpuestoPredial pagoImpuestoPredial = new PagoImpuestoPredialTestDataBuilder()
                .conValorPagado(VALOR_PAGADO)
                .build();

        RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial = Mockito.mock(RepositorioPagoImpuestoPredial.class);

        ServicioActualizarPagoImpuestoPredial servicioActualizarPagoImpuestoPredial = new ServicioActualizarPagoImpuestoPredial(repositorioPagoImpuestoPredial);

        Mockito.when(
                repositorioPagoImpuestoPredial.existeExcluyendoId(
                        pagoImpuestoPredial.getId(),
                        pagoImpuestoPredial.getPropietario().getId(),
                        pagoImpuestoPredial.getInmueble().getId(),
                        pagoImpuestoPredial.getAnio())).thenReturn(true);

        Mockito.when(repositorioPagoImpuestoPredial.crear(pagoImpuestoPredial)).thenReturn(id_esperado);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioActualizarPagoImpuestoPredial.ejecutar(pagoImpuestoPredial),
                ExcepcionDuplicidad.class, EL_PAGO_YA_EXISTE_EN_EL_SISTEMA);
    }
}
