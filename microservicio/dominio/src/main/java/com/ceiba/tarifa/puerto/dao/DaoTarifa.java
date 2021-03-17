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

    /**
     * obtener tarifa por avaluo catastral y año
     *
     * @param avaluoCatastral
     * @param anio
     * @return
     */

    double obtenerTarifaPorAvaluoYAnio(Long avaluoCatastral, int anio);

}
