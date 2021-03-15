package com.ceiba.tarifa.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.tarifa.comando.ComandoTarifa;
import com.ceiba.tarifa.comando.fabrica.FabricaTarifa;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.servicio.ServicioActualizarTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarTarifa implements ManejadorComando<ComandoTarifa> {

    private final FabricaTarifa fabricaTarifa;
    private final ServicioActualizarTarifa servicioActualizarTarifa;

    public ManejadorActualizarTarifa(FabricaTarifa fabricaTarifa, ServicioActualizarTarifa servicioActualizarTarifa) {
        this.fabricaTarifa = fabricaTarifa;
        this.servicioActualizarTarifa = servicioActualizarTarifa;
    }

    @Override
    public void ejecutar(ComandoTarifa comandoTarifa) {
        Tarifa tarifa = this.fabricaTarifa.crear(comandoTarifa);
        this.servicioActualizarTarifa.ejecutar(tarifa);
    }
}
