package com.ceiba.propietario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.propietario.servicio.ServicioEliminarPropietario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPropietario implements ManejadorComando<Long> {
    private final ServicioEliminarPropietario servicioEliminarPropietario;

    public ManejadorEliminarPropietario(ServicioEliminarPropietario servicioEliminarPropietario) {
        this.servicioEliminarPropietario = servicioEliminarPropietario;
    }

    @Override
    public void ejecutar(Long idPropietario) {
        this.servicioEliminarPropietario.ejecutar(idPropietario);
    }
}
