package com.ceiba.inmueble.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inmueble.comando.ComandoInmueble;
import com.ceiba.inmueble.comando.fabrica.FabricaInmueble;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.servicio.ServicioCrearInmueble;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearInmueble implements ManejadorComandoRespuesta<ComandoInmueble, ComandoRespuesta<Long>> {

    private final FabricaInmueble fabricaInmueble;
    private final ServicioCrearInmueble servicioCrearInmueble;
    private final RepositorioPropietario repositorioPropietario;

    public ManejadorCrearInmueble(FabricaInmueble fabricaInmueble, ServicioCrearInmueble servicioCrearInmueble, RepositorioPropietario repositorioPropietario) {
        this.fabricaInmueble = fabricaInmueble;
        this.servicioCrearInmueble = servicioCrearInmueble;
        this.repositorioPropietario = repositorioPropietario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoInmueble comandoInmueble) {
        Inmueble inmueble = this.fabricaInmueble.crear(comandoInmueble, repositorioPropietario);
        return new ComandoRespuesta<>(this.servicioCrearInmueble.ejecutar(inmueble));
    }
}
