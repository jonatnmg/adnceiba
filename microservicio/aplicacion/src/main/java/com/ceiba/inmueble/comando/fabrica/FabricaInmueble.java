package com.ceiba.inmueble.comando.fabrica;

import com.ceiba.inmueble.comando.ComandoInmueble;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import org.springframework.stereotype.Component;

@Component
public class FabricaInmueble {


    public Inmueble crear(ComandoInmueble comandoInmueble, RepositorioPropietario repositorioPropietario) {

        Propietario propietario = repositorioPropietario.buscarPropietarioPorId(comandoInmueble.getIdPropietario());

        return new Inmueble(comandoInmueble.getId(),
                comandoInmueble.getNumeroPredial(),
                comandoInmueble.getDireccion(),
                comandoInmueble.getAreaTotal(),
                comandoInmueble.getAreaConstruida(),
                comandoInmueble.getAvaluoCatastral(),
                propietario);
    }
}
