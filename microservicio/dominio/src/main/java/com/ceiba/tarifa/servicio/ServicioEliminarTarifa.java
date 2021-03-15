package com.ceiba.tarifa.servicio;

import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;

public class ServicioEliminarTarifa {

    private final RepositorioTarifa repositorioTarifa;

    public ServicioEliminarTarifa(RepositorioTarifa repositorioTarifa) {
        this.repositorioTarifa = repositorioTarifa;
    }

    public void ejecutar(Long id) {
        this.repositorioTarifa.eliminar(id);
    }
}
