package com.ceiba.inmueble.servicio;

import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;

public class ServicioEliminarInmueble {

    private final RepositorioInmueble repositorioInmueble;

    public ServicioEliminarInmueble(RepositorioInmueble repositorioInmueble) {
        this.repositorioInmueble = repositorioInmueble;
    }

    public void ejecutar(Long id) {
        this.repositorioInmueble.eliminar(id);
    }
}
