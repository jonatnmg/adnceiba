package com.ceiba.tarifa.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.tarifa.servicio.ServicioEliminarTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarTarifa implements ManejadorComando<Long> {

    private final ServicioEliminarTarifa servicioEliminarTarifa;

    public ManejadorEliminarTarifa(ServicioEliminarTarifa servicioEliminarTarifa) {
        this.servicioEliminarTarifa = servicioEliminarTarifa;
    }

    @Override
    public void ejecutar(Long idTarifa) {
        this.servicioEliminarTarifa.ejecutar(idTarifa);
    }
}
