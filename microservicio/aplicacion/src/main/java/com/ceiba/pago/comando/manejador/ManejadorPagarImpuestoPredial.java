package com.ceiba.pago.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pago.comando.ComandoPagoImpuestoPredial;
import com.ceiba.pago.comando.fabrica.FabricaPagoImpuestoPredial;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.servicio.ServicioPagarImpuestoPredial;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPagarImpuestoPredial implements ManejadorComandoRespuesta<ComandoPagoImpuestoPredial, ComandoRespuesta<Long>> {

    private final FabricaPagoImpuestoPredial fabricaPagoImpuestoPredial;
    private final ServicioPagarImpuestoPredial servicioPagarImpuestoPredial;
    private final RepositorioPropietario repositorioPropietario;
    private final RepositorioInmueble repositorioInmueble;
    private final RepositorioTarifa repositorioTarifa;

    public ManejadorPagarImpuestoPredial(FabricaPagoImpuestoPredial fabricaPagoImpuestoPredial, ServicioPagarImpuestoPredial servicioPagarImpuestoPredial, RepositorioPropietario repositorioPropietario, RepositorioInmueble repositorioInmueble, RepositorioTarifa repositorioTarifa) {
        this.fabricaPagoImpuestoPredial = fabricaPagoImpuestoPredial;
        this.servicioPagarImpuestoPredial = servicioPagarImpuestoPredial;
        this.repositorioPropietario = repositorioPropietario;
        this.repositorioInmueble = repositorioInmueble;
        this.repositorioTarifa = repositorioTarifa;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPagoImpuestoPredial comandoPagoImpuestoPredial) {
        PagoImpuestoPredial pagoImpuestoPredial = this.fabricaPagoImpuestoPredial.crear(comandoPagoImpuestoPredial, this.repositorioPropietario, this.repositorioInmueble, this.repositorioTarifa);
        return new ComandoRespuesta<>(this.servicioPagarImpuestoPredial.ejecutar(pagoImpuestoPredial));
    }
}
