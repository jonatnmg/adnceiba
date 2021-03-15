package com.ceiba.pago.comando.fabrica;

import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.modelo.entidad.Pago;
import org.springframework.stereotype.Component;

@Component
public class FabricaPago {

    public Pago crear(ComandoPago comandoPago) {
        return new Pago(comandoPago.getId(),
                comandoPago.getIdPropietario(),
                comandoPago.getIdInmueble(),
                comandoPago.getAnio(),
                comandoPago.getValorPagado(),
                comandoPago.getFecha());
    }
}
