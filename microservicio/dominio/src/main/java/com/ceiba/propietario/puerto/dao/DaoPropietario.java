package com.ceiba.propietario.puerto.dao;

import com.ceiba.propietario.modelo.dto.DtoPropietario;

import java.util.List;

public interface DaoPropietario {
    /**
     * Permite listar propietarios
     *
     * @return los propietarios
     */
    List<DtoPropietario> listar();

    /**
     * Permite lista un propietario
     *
     * @return un propietario
     */
    List<DtoPropietario> listarPorNumeroIdentificacion(String numeroIdentificacion);
}
