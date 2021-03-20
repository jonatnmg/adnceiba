package com.ceiba.inmueble.puerto.repositorio;

import com.ceiba.inmueble.modelo.entidad.Inmueble;

public interface RepositorioInmueble {
    /**
     * Permite crear un inmueble
     *
     * @param inmueble
     * @return el id generado
     */
    Long crear(Inmueble inmueble);

    /**
     * Permite actualizar un inmueble
     *
     * @param inmueble
     */
    void actualizar(Inmueble inmueble);

    /**
     * Permite eliminar un inmueble
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un inmueble con un numeroPredial y direccion
     *
     * @param numeroPredial
     * @param direccion
     * @return si existe o no
     */
    boolean existe(Long numeroPredial, String direccion);

    /**
     * Permite validar si existe un inmueble con un numeroPredial y direccion excluyendo un id
     *
     * @param id
     * @param numeroPredial
     * @param direccion
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, Long numeroPredial, String direccion);

    /**
     * Buscar inmueble por id inmueble
     *
     * @param id
     * @return
     */
    Inmueble buscarInmueblePorId(Long id);

    /**
     * Permite validar si existe un inmueble por id
     *
     * @param idInmueble
     * @return si existe o no
     */
    boolean existePorId(Long idInmueble);

    /**
     * Verifica si el id propietario existe en un inmueble creado
     *
     * @param idPropietario
     * @return
     */
    boolean existePropietarioEnInmueble(Long idPropietario);
}
