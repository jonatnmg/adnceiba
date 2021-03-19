package com.ceiba.pago.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.comando.fabrica.FabricaPagoImpuestoPredial;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.servicio.ServicioPagarInmpuestoPredial;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPagarImpuestoPredial implements ManejadorComandoRespuesta<ComandoPago, ComandoRespuesta<Long>> {

    private final FabricaPagoImpuestoPredial fabricaPagoImpuestoPredial;
    private final ServicioPagarInmpuestoPredial servicioPagarInmpuestoPredial;
    private final RepositorioPropietario repositorioPropietario;
    private final RepositorioInmueble repositorioInmueble;
    private final RepositorioTarifa repositorioTarifa;

    public ManejadorPagarImpuestoPredial(FabricaPagoImpuestoPredial fabricaPagoImpuestoPredial, ServicioPagarInmpuestoPredial servicioPagarInmpuestoPredial, RepositorioPropietario repositorioPropietario, RepositorioInmueble repositorioInmueble, RepositorioTarifa repositorioTarifa) {
        this.fabricaPagoImpuestoPredial = fabricaPagoImpuestoPredial;
        this.servicioPagarInmpuestoPredial = servicioPagarInmpuestoPredial;
        this.repositorioPropietario = repositorioPropietario;
        this.repositorioInmueble = repositorioInmueble;
        this.repositorioTarifa = repositorioTarifa;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPago comandoPago) {
        PagoImpuestoPredial pagoImpuestoPredial = this.fabricaPagoImpuestoPredial.crear(comandoPago, this.repositorioPropietario, this.repositorioInmueble, this.repositorioTarifa);
        return new ComandoRespuesta<>(this.servicioPagarInmpuestoPredial.ejecutar(pagoImpuestoPredial));
    }
}
