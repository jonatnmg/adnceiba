package com.ceiba.propietario.consulta;

import com.ceiba.propietario.modelo.dto.DtoPropietario;
import com.ceiba.propietario.puerto.dao.DaoPropietario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPropietariosPorNumeroIdentificacion {

    private final DaoPropietario daoPropietario;

    public ManejadorListarPropietariosPorNumeroIdentificacion(DaoPropietario daoPropietario) {
        this.daoPropietario = daoPropietario;
    }

    public List<DtoPropietario> ejecutar(String numeroIdentificacion) {
        return this.daoPropietario.listarPorNumeroIdentificacion(numeroIdentificacion);
    }
}
