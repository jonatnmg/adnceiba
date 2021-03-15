package com.ceiba.inmueble.comando.manejador;

import com.ceiba.inmueble.comando.ComandoInmueble;
import com.ceiba.inmueble.comando.fabrica.FabricaInmueble;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.servicio.ServicioActualizarInmueble;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarInmueble implements ManejadorComando<ComandoInmueble> {

    private final FabricaInmueble fabricaInmueble;
    private final ServicioActualizarInmueble servicioActualizarInmueble;

    public ManejadorActualizarInmueble(FabricaInmueble fabricaInmueble, ServicioActualizarInmueble servicioActualizarInmueble) {
        this.fabricaInmueble = fabricaInmueble;
        this.servicioActualizarInmueble = servicioActualizarInmueble;
    }

    @Override
    public void ejecutar(ComandoInmueble comandoInmueble) {
        Inmueble inmueble = this.fabricaInmueble.crear(comandoInmueble);
        this.servicioActualizarInmueble.ejecutar(inmueble);
    }
}
