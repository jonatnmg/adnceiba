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
}
