package com.ceiba.pago.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.pago.testdatabuilder.PagoImpuestoPredialTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioPagarImpuestoPredialTest {

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";
    private static final Long VALOR_PAGADO = 396000L;

    @Test
    public void validarPagarImpuestoPredialTest() {

        // arrange
        Long id_esperado = 1L;
        PagoImpuestoPredial pagoImpuestoPredial = new PagoImpuestoPredialTestDataBuilder()
                .conValorPagado(VALOR_PAGADO)
                .build();

        RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial = Mockito.mock(RepositorioPagoImpuestoPredial.class);

        ServicioPagarImpuestoPredial servicioPagarImpuestoPredial = new ServicioPagarImpuestoPredial(repositorioPagoImpuestoPredial);

        Mockito.when(
                repositorioPagoImpuestoPredial.existe(
                        pagoImpuestoPredial.getPropietario().getId(),
                        pagoImpuestoPredial.getInmueble().getId(),
                        pagoImpuestoPredial.getAnio())).thenReturn(false);

        Mockito.when(repositorioPagoImpuestoPredial.crear(pagoImpuestoPredial)).thenReturn(id_esperado);

        // act
        Long idPagoImpuestoPredial = servicioPagarImpuestoPredial.ejecutar(pagoImpuestoPredial);

        // assert
        BasePrueba.assertEqualsObject(id_esperado, idPagoImpuestoPredial);
    }

    @Test
    public void validarExistenciaPreviaPagoImpuestoPredialTest() {

        // arrange
        Long id_esperado = 1L;
        PagoImpuestoPredial pagoImpuestoPredial = new PagoImpuestoPredialTestDataBuilder()
                .conValorPagado(VALOR_PAGADO)
                .build();

        RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial = Mockito.mock(RepositorioPagoImpuestoPredial.class);

        ServicioPagarImpuestoPredial servicioPagarImpuestoPredial = new ServicioPagarImpuestoPredial(repositorioPagoImpuestoPredial);

        Mockito.when(
                repositorioPagoImpuestoPredial.existe(
                        pagoImpuestoPredial.getPropietario().getId(),
                        pagoImpuestoPredial.getInmueble().getId(),
                        pagoImpuestoPredial.getAnio())).thenReturn(true);

        Mockito.when(repositorioPagoImpuestoPredial.crear(pagoImpuestoPredial)).thenReturn(id_esperado);

        // act - assert
        BasePrueba.assertThrows(
                () -> servicioPagarImpuestoPredial.ejecutar(pagoImpuestoPredial),
                ExcepcionDuplicidad.class, EL_PAGO_YA_EXISTE_EN_EL_SISTEMA);
    }
}
