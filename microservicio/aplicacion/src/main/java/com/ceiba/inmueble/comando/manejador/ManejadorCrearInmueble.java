package com.ceiba.inmueble.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inmueble.comando.ComandoInmueble;
import com.ceiba.inmueble.comando.fabrica.FabricaInmueble;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.servicio.ServicioCrearInmueble;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearInmueble implements ManejadorComandoRespuesta<ComandoInmueble, ComandoRespuesta<Long>> {

    private final FabricaInmueble fabricaInmueble;
    private final ServicioCrearInmueble servicioCrearInmueble;

    public ManejadorCrearInmueble(FabricaInmueble fabricaInmueble, ServicioCrearInmueble servicioCrearInmueble) {
        this.fabricaInmueble = fabricaInmueble;
        this.servicioCrearInmueble = servicioCrearInmueble;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoInmueble comandoInmueble) {
        Inmueble inmueble = this.fabricaInmueble.crear(comandoInmueble);
        return new ComandoRespuesta<>(this.servicioCrearInmueble.ejecutar(inmueble));
    }
}
