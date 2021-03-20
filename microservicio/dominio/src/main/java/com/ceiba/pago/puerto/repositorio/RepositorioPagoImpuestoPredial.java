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

    /**
     * Permite validar si existe un pago impuesto predial por id
     *
     * @param idPagoImpuestoPredial
     * @return
     */
    boolean existePorId(Long idPagoImpuestoPredial);

    /**
     * Verificar si idPropietario esta relacionado a un pago
     *
     * @param idPropietario
     * @return
     */

    boolean existePropietarioEnPagoImpuestoPredial(Long idPropietario);

    /**
     * Verificar si idInmueble esta relacionado a un pago
     *
     * @param idInmueble
     * @return
     */
    boolean existeInmuebleEnPagoImpuestoPredial(Long idInmueble);

    /**
     * Verificar si idTarifa esta relacionado a un pago
     *
     * @param idTarifa
     * @return
     */
    boolean existeTarifaEnPagoImpuestoPredial(Long idTarifa);
}
