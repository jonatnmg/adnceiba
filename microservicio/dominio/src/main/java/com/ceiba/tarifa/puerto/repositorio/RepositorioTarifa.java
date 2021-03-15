package com.ceiba.tarifa.puerto.repositorio;

import com.ceiba.tarifa.modelo.entidad.Tarifa;

public interface RepositorioTarifa {

    /**
     * Permite crear un tarifa
     *
     * @param tarifa
     * @return el id generado
     */
    Long crear(Tarifa tarifa);

    /**
     * Permite actualizar un tarifa
     *
     * @param tarifa
     */
    void actualizar(Tarifa tarifa);

    /**
     * Permite eliminar un tarifa
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un rango de avaluos
     *
     * @param avaluoMinimo
     * @param avaluoMaximo
     * @return si existe o no
     */
    boolean existe(Long avaluoMinimo, Long avaluoMaximo, int anio);

    /**
     * Permite validar si existe un rango de avaluos excluyendo el id
     *
     * @param avaluoMinimo
     * @param avaluoMaximo
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, Long avaluoMinimo, Long avaluoMaximo, int anio);

}
