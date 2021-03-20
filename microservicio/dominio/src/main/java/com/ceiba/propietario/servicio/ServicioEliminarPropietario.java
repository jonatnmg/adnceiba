package com.ceiba.propietario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;

public class ServicioEliminarPropietario {

    private static final String EL_PROPIETARIO_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El propietario no se encontro en el sistema";

    private final RepositorioPropietario repositorioPropietario;

    public ServicioEliminarPropietario(RepositorioPropietario repositorioPropietario) {
        this.repositorioPropietario = repositorioPropietario;
    }

    public void ejecutar(Long id) {
        this.validarExistenciaPropietarioPorId(id);
        this.repositorioPropietario.eliminar(id);
    }

    private void validarExistenciaPropietarioPorId(Long id) {
        boolean existe = this.repositorioPropietario.existePorId(id);

        if (!existe) {
            throw new ExcepcionSinDatos(EL_PROPIETARIO_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }

}
