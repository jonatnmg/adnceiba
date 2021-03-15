package com.ceiba.propietario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;

public class ServicioCrearPropietario {

    private static final String EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA = "El propietario ya existe en el sistema";

    private final RepositorioPropietario repositorioPropietario;

    public ServicioCrearPropietario(RepositorioPropietario repositorioPropietario) {
        this.repositorioPropietario = repositorioPropietario;
    }

    public Long ejecutar(Propietario propietario) {
        validarExistenciaPrevia(propietario);
        return this.repositorioPropietario.crear(propietario);
    }

    private void validarExistenciaPrevia(Propietario propietario) {
        boolean existe = this.repositorioPropietario.existePorNumeroIdentificacion(propietario.getNumeroIdentificacion());

        if (existe) {
            throw new ExcepcionDuplicidad(EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
