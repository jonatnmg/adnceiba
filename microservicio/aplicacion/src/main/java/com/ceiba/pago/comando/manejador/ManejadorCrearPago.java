package com.ceiba.pago.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.comando.fabrica.FabricaPago;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.servicio.ServicioCrearPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPago implements ManejadorComandoRespuesta<ComandoPago, ComandoRespuesta<Long>> {

    private final FabricaPago fabricaPago;
    private final ServicioCrearPago servicioCrearPago;

    public ManejadorCrearPago(FabricaPago fabricaPago, ServicioCrearPago servicioCrearPago) {
        this.fabricaPago = fabricaPago;
        this.servicioCrearPago = servicioCrearPago;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPago comandoPago) {
        Pago pago = this.fabricaPago.crear(comandoPago);
        return new ComandoRespuesta<>(this.servicioCrearPago.ejecutar(pago));
    }
}
