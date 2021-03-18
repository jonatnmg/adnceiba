package com.ceiba.pago.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.comando.fabrica.FabricaPagoImpuestoPredial;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.servicio.ServicioPagoInmpuestoPredial;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPago implements ManejadorComandoRespuesta<ComandoPago, ComandoRespuesta<Long>> {

    private final FabricaPagoImpuestoPredial fabricaPagoImpuestoPredial;
    private final ServicioPagoInmpuestoPredial servicioPagoInmpuestoPredial;

    public ManejadorCrearPago(FabricaPagoImpuestoPredial fabricaPagoImpuestoPredial, ServicioPagoInmpuestoPredial servicioPagoInmpuestoPredial) {
        this.fabricaPagoImpuestoPredial = fabricaPagoImpuestoPredial;
        this.servicioPagoInmpuestoPredial = servicioPagoInmpuestoPredial;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPago comandoPago) {
        PagoImpuestoPredial pagoImpuestoPredial = this.fabricaPagoImpuestoPredial.crear(comandoPago);
        return new ComandoRespuesta<>(this.servicioPagoInmpuestoPredial.ejecutar(pagoImpuestoPredial));
    }
}
