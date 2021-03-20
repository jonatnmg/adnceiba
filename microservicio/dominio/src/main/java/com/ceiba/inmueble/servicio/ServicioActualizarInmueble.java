package com.ceiba.inmueble.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;

public class ServicioActualizarInmueble {

    private static final String EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA = "El inmueble ya existe en el sistema";
    private static final String EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El inmueble no existe en el sistema para actualizar";

    private final RepositorioInmueble repositorioInmueble;

    public ServicioActualizarInmueble(RepositorioInmueble repositorioInmueble) {
        this.repositorioInmueble = repositorioInmueble;
    }

    public void ejecutar(Inmueble inmueble) {
        this.validarExisteInmueblePorId(inmueble);
        this.validarExistenciaPrevia(inmueble);
        this.repositorioInmueble.actualizar(inmueble);
    }

    private void validarExistenciaPrevia(Inmueble inmueble) {
        boolean existe = this.repositorioInmueble.existeExcluyendoId(inmueble.getId(), inmueble.getNumeroPredial(), inmueble.getDireccion());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_INMUEBLE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExisteInmueblePorId(Inmueble inmueble) {
        boolean existe = this.repositorioInmueble.existePorId(inmueble.getId());
        if (!existe) {
            throw new ExcepcionSinDatos(EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }
}
