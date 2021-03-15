package com.ceiba.tarifa.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.tarifa.comando.ComandoTarifa;
import com.ceiba.tarifa.comando.fabrica.FabricaTarifa;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.servicio.ServicioCrearTarifa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTarifa implements ManejadorComandoRespuesta<ComandoTarifa, ComandoRespuesta<Long>> {

    private final FabricaTarifa fabricaTarifa;
    private final ServicioCrearTarifa servicioCrearTarifa;

    public ManejadorCrearTarifa(FabricaTarifa fabricaTarifa, ServicioCrearTarifa servicioCrearTarifa) {
        this.fabricaTarifa = fabricaTarifa;
        this.servicioCrearTarifa = servicioCrearTarifa;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoTarifa comandoTarifa) {
        Tarifa tarifa = this.fabricaTarifa.crear(comandoTarifa);
        return new ComandoRespuesta<>(this.servicioCrearTarifa.ejecutar(tarifa));
    }
}
