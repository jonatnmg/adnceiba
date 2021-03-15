package com.ceiba.inmueble.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;

public class ServicioCrearInmueble {

    private static final String EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA = "El inmueble ya existe en el sistema";

    private final RepositorioInmueble repositorioInmueble;

    public ServicioCrearInmueble(RepositorioInmueble repositorioInmueble) {
        this.repositorioInmueble = repositorioInmueble;
    }

    public Long ejecutar(Inmueble inmueble) {
        this.validarExistenciaPrevia(inmueble);
        return this.repositorioInmueble.crear(inmueble);
    }

    private void validarExistenciaPrevia(Inmueble inmueble) {
        boolean existe = this.repositorioInmueble.existe(inmueble.getNumeroPredial(), inmueble.getDireccion());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
