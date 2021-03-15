package com.ceiba.tarifa.comando.fabrica;

import com.ceiba.tarifa.comando.ComandoTarifa;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import org.springframework.stereotype.Component;

@Component
public class FabricaTarifa {

    public Tarifa crear(ComandoTarifa comandoTarifa) {
        return new Tarifa(comandoTarifa.getId(),
                comandoTarifa.getAvaluoMinimo(),
                comandoTarifa.getAvaluoMaximo(),
                comandoTarifa.getTarifa(),
                comandoTarifa.getAnio());
    }
}
