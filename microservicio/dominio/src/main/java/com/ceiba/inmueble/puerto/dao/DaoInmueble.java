package com.ceiba.inmueble.puerto.dao;

import com.ceiba.inmueble.modelo.dto.DtoInmueble;

import java.util.List;

public interface DaoInmueble {
    /**
     * Permite listar inmuebles
     *
     * @return los inmuebles
     */
    List<DtoInmueble> listar();

    /**
     * Permite obtener un inmueble por id
     *
     * @return listado de inmueble
     */
    DtoInmueble buscarPorId(Long id);

    /**
     * Obtener valor catastral por id inmueble
     *
     * @param id
     * @return
     */
    Long obtenerValorCatastral(Long id);
}
