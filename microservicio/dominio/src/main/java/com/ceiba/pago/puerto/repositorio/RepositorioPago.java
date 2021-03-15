package com.ceiba.pago.puerto.repositorio;

import com.ceiba.pago.modelo.entidad.Pago;

public interface RepositorioPago {
    /**
     * Permite crear un pago
     *
     * @param pago
     * @return el id generado
     */
    Long crear(Pago pago);

    /**
     * Permite actualizar un pago
     *
     * @param pago
     */
    void actualizar(Pago pago);

    /**
     * Permite eliminar un pago
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un pago con un idPropietario, idInmueble y anio
     *
     * @param idPropietario
     * @param idInmueble
     * @param anio
     * @return si existe o no
     */
    boolean existe(Long idPropietario, Long idInmueble, int anio);

    /**
     * Permite validar si existe un pago con un idPropietario, idInmueble y anio excluyendo un id
     *
     * @param idPropietario
     * @param idInmueble
     * @param anio
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, Long idPropietario, Long idInmueble, int anio);
}
