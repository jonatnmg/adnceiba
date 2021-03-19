package com.ceiba.inmueble.comando.manejador;

import com.ceiba.inmueble.comando.ComandoInmueble;
import com.ceiba.inmueble.comando.fabrica.FabricaInmueble;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.servicio.ServicioActualizarInmueble;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarInmueble implements ManejadorComando<ComandoInmueble> {

    private final FabricaInmueble fabricaInmueble;
    private final ServicioActualizarInmueble servicioActualizarInmueble;
    private final RepositorioPropietario repositorioPropietario;

    public ManejadorActualizarInmueble(FabricaInmueble fabricaInmueble, ServicioActualizarInmueble servicioActualizarInmueble, RepositorioPropietario repositorioPropietario) {
        this.fabricaInmueble = fabricaInmueble;
        this.servicioActualizarInmueble = servicioActualizarInmueble;
        this.repositorioPropietario = repositorioPropietario;
    }

    @Override
    public void ejecutar(ComandoInmueble comandoInmueble) {
        Inmueble inmueble = this.fabricaInmueble.crear(comandoInmueble, repositorioPropietario);
        this.servicioActualizarInmueble.ejecutar(inmueble);
    }
}
