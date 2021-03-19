package com.ceiba.pago.comando.manejador;

import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pago.comando.ComandoPagoImpuestoPredial;
import com.ceiba.pago.comando.fabrica.FabricaPagoImpuestoPredial;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.servicio.ServicioActualizarPagoImpuestoPredial;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPagoImpuestoPredial implements ManejadorComando<ComandoPagoImpuestoPredial> {

    private final FabricaPagoImpuestoPredial fabricaPagoImpuestoPredial;
    private final ServicioActualizarPagoImpuestoPredial servicioActualizarPagoImpuestoPredial;
    private final RepositorioPropietario repositorioPropietario;
    private final RepositorioInmueble repositorioInmueble;
    private final RepositorioTarifa repositorioTarifa;

    public ManejadorActualizarPagoImpuestoPredial(FabricaPagoImpuestoPredial fabricaPagoImpuestoPredial, ServicioActualizarPagoImpuestoPredial servicioActualizarPagoImpuestoPredial, RepositorioPropietario repositorioPropietario, RepositorioInmueble repositorioInmueble, RepositorioTarifa repositorioTarifa) {
        this.fabricaPagoImpuestoPredial = fabricaPagoImpuestoPredial;
        this.servicioActualizarPagoImpuestoPredial = servicioActualizarPagoImpuestoPredial;
        this.repositorioPropietario = repositorioPropietario;
        this.repositorioInmueble = repositorioInmueble;
        this.repositorioTarifa = repositorioTarifa;
    }

    @Override
    public void ejecutar(ComandoPagoImpuestoPredial comandoPagoImpuestoPredial) {
        PagoImpuestoPredial pagoImpuestoPredial = this.fabricaPagoImpuestoPredial.crear(comandoPagoImpuestoPredial, repositorioPropietario, repositorioInmueble, repositorioTarifa);
        this.servicioActualizarPagoImpuestoPredial.ejecutar(pagoImpuestoPredial);
    }
}
