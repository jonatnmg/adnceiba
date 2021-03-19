package com.ceiba.pago.comando.fabrica;

import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.pago.comando.ComandoPagoImpuestoPredial;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import org.springframework.stereotype.Component;

@Component
public class FabricaPagoImpuestoPredial {

    public PagoImpuestoPredial crear(ComandoPagoImpuestoPredial comandoPagoImpuestoPredial, RepositorioPropietario repositorioPropietario, RepositorioInmueble repositorioInmueble, RepositorioTarifa repositorioTarifa) {

        Propietario propietario = repositorioPropietario.buscarPropietarioPorId(comandoPagoImpuestoPredial.getIdPropietario());
        Inmueble inmueble = repositorioInmueble.buscarInmueblePorId(comandoPagoImpuestoPredial.getIdInmueble());
        Tarifa tarifa = repositorioTarifa.buscarTarifaPorId(comandoPagoImpuestoPredial.getIdTarifa());

        return new PagoImpuestoPredial(comandoPagoImpuestoPredial.getId(),
                propietario,
                inmueble,
                comandoPagoImpuestoPredial.getAnio(),
                comandoPagoImpuestoPredial.getValorPagado(),
                comandoPagoImpuestoPredial.getFecha(),
                tarifa
        );

    }
}
