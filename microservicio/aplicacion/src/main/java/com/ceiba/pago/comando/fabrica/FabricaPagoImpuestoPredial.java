package com.ceiba.pago.comando.fabrica;

import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import org.springframework.stereotype.Component;

@Component
public class FabricaPagoImpuestoPredial {

    public PagoImpuestoPredial crear(ComandoPago comandoPago, RepositorioPropietario repositorioPropietario, RepositorioInmueble repositorioInmueble, RepositorioTarifa repositorioTarifa) {

        Propietario propietario = repositorioPropietario.buscarPropietarioPorId(comandoPago.getIdPropietario());
        Inmueble inmueble = repositorioInmueble.buscarInmueblePorId(comandoPago.getIdInmueble());
        Tarifa tarifa = repositorioTarifa.buscarTarifaPorId(comandoPago.getIdTarifa());

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
