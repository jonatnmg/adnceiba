package com.ceiba.pago.puerto.repositorio;

import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;

public interface RepositorioPagoImpuestoPredial {
    /**
     * Permite crear un pagoImpuestoPredial
     *
     * @param pagoImpuestoPredial
     * @return el id generado
     */
    Long crear(PagoImpuestoPredial pagoImpuestoPredial);

    /**
     * Permite actualizar un pagoImpuestoPredial
     *
     * @param pagoImpuestoPredial
     */
    void actualizar(PagoImpuestoPredial pagoImpuestoPredial);

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
