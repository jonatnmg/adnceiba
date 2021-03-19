package com.ceiba.pago.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pago.servicio.ServicioEliminarPagoImpuestoPredial;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPagoImpuestoPredial implements ManejadorComando<Long> {
    private final ServicioEliminarPagoImpuestoPredial servicioEliminarPagoImpuestoPredial;

    public ManejadorEliminarPagoImpuestoPredial(ServicioEliminarPagoImpuestoPredial servicioEliminarPagoImpuestoPredial) {
        this.servicioEliminarPagoImpuestoPredial = servicioEliminarPagoImpuestoPredial;
    }

    @Override
    public void ejecutar(Long idPagoImpuestoPredial) {
        this.servicioEliminarPagoImpuestoPredial.ejecutar(idPagoImpuestoPredial);
    }
}
