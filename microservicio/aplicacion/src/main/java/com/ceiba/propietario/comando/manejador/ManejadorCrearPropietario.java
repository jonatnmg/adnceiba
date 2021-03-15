package com.ceiba.propietario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.propietario.comando.ComandoPropietario;
import com.ceiba.propietario.comando.fabrica.FabricaPropietario;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.servicio.ServicioCrearPropietario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPropietario implements ManejadorComandoRespuesta<ComandoPropietario, ComandoRespuesta<Long>> {

    private final FabricaPropietario fabricaPropietario;
    private final ServicioCrearPropietario servicioCrearPropietario;

    public ManejadorCrearPropietario(FabricaPropietario fabricaPropietario, ServicioCrearPropietario servicioCrearPropietario) {
        this.fabricaPropietario = fabricaPropietario;
        this.servicioCrearPropietario = servicioCrearPropietario;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPropietario comandoPropietario) {
        Propietario propietario = this.fabricaPropietario.crear(comandoPropietario);
        return new ComandoRespuesta<>(this.servicioCrearPropietario.ejecutar(propietario));
    }
}
