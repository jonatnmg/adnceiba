package com.ceiba.tarifa.puerto.dao;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;

import java.util.List;

public interface DaoTarifa {

    /**
     * Permite listar tarifas
     *
     * @return los tarifas
     */
    List<DtoTarifa> listar();
}
