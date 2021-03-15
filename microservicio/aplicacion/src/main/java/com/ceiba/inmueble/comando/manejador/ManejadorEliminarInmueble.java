package com.ceiba.inmueble.comando.manejador;

import com.ceiba.inmueble.servicio.ServicioEliminarInmueble;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarInmueble implements ManejadorComando<Long> {

    private final ServicioEliminarInmueble servicioEliminarInmueble;

    public ManejadorEliminarInmueble(ServicioEliminarInmueble servicioEliminarInmueble) {
        this.servicioEliminarInmueble = servicioEliminarInmueble;
    }

    @Override
    public void ejecutar(Long idInmueble) {
        this.servicioEliminarInmueble.ejecutar(idInmueble);
    }
}
