package com.ceiba.tarifa.servicio;

import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import com.ceiba.tarifa.testdatabuilder.TarifaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarTarifaTest {

    @Test
    public void validarEliminarTarifaTest() {

        // arrange
        Tarifa tarifa = new TarifaTestDataBuilder().build();
        RepositorioTarifa repositorioTarifa = Mockito.mock(RepositorioTarifa.class);
        RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial = Mockito.mock(RepositorioPagoImpuestoPredial.class);

        ServicioEliminarTarifa servicioEliminarTarifa = new ServicioEliminarTarifa(repositorioTarifa, repositorioPagoImpuestoPredial);

        Mockito.when(repositorioTarifa.existePorId(tarifa.getId())).thenReturn(true);
        Mockito.when(repositorioPagoImpuestoPredial.existeTarifaEnPagoImpuestoPredial(tarifa.getId())).thenReturn(false);

        // act
        servicioEliminarTarifa.ejecutar(tarifa.getId());

        // assert
        Mockito.verify(repositorioTarifa).eliminar(tarifa.getId());
    }

}
