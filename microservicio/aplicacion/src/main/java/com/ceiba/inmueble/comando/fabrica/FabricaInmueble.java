package com.ceiba.inmueble.comando.fabrica;

import com.ceiba.inmueble.comando.ComandoInmueble;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import org.springframework.stereotype.Component;

@Component
public class FabricaInmueble {

    public Inmueble crear(ComandoInmueble comandoInmueble) {
        return new Inmueble(comandoInmueble.getId(),
                comandoInmueble.getNumeroPredial(),
                comandoInmueble.getCodigoPostal(),
                comandoInmueble.getDireccion(),
                comandoInmueble.getAreaTotal(),
                comandoInmueble.getAreaConstruida(),
                comandoInmueble.getAvaluoCatastral(),
                comandoInmueble.getPropietario());
    }
}
