package com.ceiba.pago.comando.fabrica;

import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import org.springframework.stereotype.Component;

@Component
public class FabricaPagoImpuestoPredial {

    RepositorioPropietario repositorioPropietario;

    public PagoImpuestoPredial crear(ComandoPago comandoPago) {

        Propietario propietario = repositorioPropietario.buscarPropietarioPorId(comandoPago.getIdPropietario());
        Inmueble inmueble = null;
        Tarifa tarifa = null;

        return new PagoImpuestoPredial(comandoPago.getId(),
                propietario,
                inmueble,
                comandoPago.getAnio(),
                comandoPago.getValorPagado(),
                comandoPago.getFecha(),
                tarifa
        );

    }
}
