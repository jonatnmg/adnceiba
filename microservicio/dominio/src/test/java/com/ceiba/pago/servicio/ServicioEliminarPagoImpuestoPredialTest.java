package com.ceiba.pago.servicio;

import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.pago.testdatabuilder.PagoImpuestoPredialTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarPagoImpuestoPredialTest {

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";
    private static final String PAGO_NO_ENCONTRADO_EN_EL_SISTEMA = "No se puede actualizar, el pago no se encontro en el sistema";
    private static final Long VALOR_PAGADO = 396000L;

    @Test
    public void eliminarPagoImpuestoPredialTest() {

        // arrange
        Long id_esperado = 1L;
        PagoImpuestoPredial pagoImpuestoPredial = new PagoImpuestoPredialTestDataBuilder()
                .conValorPagado(VALOR_PAGADO)
                .build();

        RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial = Mockito.mock(RepositorioPagoImpuestoPredial.class);

        ServicioEliminarPagoImpuestoPredial servicioEliminarPagoImpuestoPredial = new ServicioEliminarPagoImpuestoPredial(repositorioPagoImpuestoPredial);

        Mockito.when(
                repositorioPagoImpuestoPredial.existeExcluyendoId(
                        pagoImpuestoPredial.getId(),
                        pagoImpuestoPredial.getPropietario().getId(),
                        pagoImpuestoPredial.getInmueble().getId(),
                        pagoImpuestoPredial.getAnio())).thenReturn(false);

        Mockito.when(repositorioPagoImpuestoPredial.existePorId(pagoImpuestoPredial.getId())).thenReturn(true);
        Mockito.when(repositorioPagoImpuestoPredial.crear(pagoImpuestoPredial)).thenReturn(id_esperado);

        // act
        servicioEliminarPagoImpuestoPredial.ejecutar(pagoImpuestoPredial.getId());

        // assert
        Mockito.verify(repositorioPagoImpuestoPredial).eliminar(pagoImpuestoPredial.getId());
    }
}
