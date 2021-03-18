package com.ceiba.propietario.puerto.repositorio;

import com.ceiba.propietario.modelo.entidad.Propietario;

public interface RepositorioPropietario {

    /**
     * Permite crear un propietario
     *
     * @param propietario
     * @return el id generado
     */
    Long crear(Propietario propietario);

    /**
     * Permite actualizar un propietario
     *
     * @param propietario
     */
    void actualizar(Propietario propietario);

    /**
     * Permite eliminar un propietario
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un propietario con un nombre
     *
     * @param nombre
     * @return si existe o no
     */
    boolean existePorNombre(String nombre);

    /**
     * Permite validar si existe un propietario con un numeroIdentificacion excluyendo un id
     *
     * @param numeroIdentificacion
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String numeroIdentificacion);

    /**
     * Permite validar si existe un propietario con un numero identificacion
     *
     * @param numeroIdentificacion
     * @return si existe o no
     */
    boolean existePorNumeroIdentificacion(String numeroIdentificacion);

    /**
     * Buscar propietario por idPropietario
     *
     * @param idPropietario
     * @return
     */
    Propietario buscarPropietarioPorId(Long idPropietario);

}
