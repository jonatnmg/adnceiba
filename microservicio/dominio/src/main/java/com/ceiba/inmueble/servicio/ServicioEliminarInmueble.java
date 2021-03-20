package com.ceiba.inmueble.servicio;

import com.ceiba.dominio.excepcion.ExcepcionCrearPago;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;

public class ServicioEliminarInmueble {

    private static final String EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El inmueble no existe en el sistema";

    private final RepositorioInmueble repositorioInmueble;

    public ServicioEliminarInmueble(RepositorioInmueble repositorioInmueble) {
        this.repositorioInmueble = repositorioInmueble;
    }

    public void ejecutar(Long id) {
        this.validarExisteInmueblePorId(id);
        this.repositorioInmueble.eliminar(id);
    }

    private void validarExisteInmueblePorId(Long idInmueble) {
        boolean existe = this.repositorioInmueble.existePorId(idInmueble);
        if (!existe) {
            throw new ExcepcionCrearPago(EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }
}
