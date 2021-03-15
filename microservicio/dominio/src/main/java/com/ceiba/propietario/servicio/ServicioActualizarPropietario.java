package com.ceiba.propietario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;

public class ServicioActualizarPropietario {

    private static final String EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA = "El propietario ya existe en el sistema";

    private final RepositorioPropietario repositorioPropietario;

    public ServicioActualizarPropietario(RepositorioPropietario repositorioPropietario) {
        this.repositorioPropietario = repositorioPropietario;
    }

    public void ejecutar(Propietario propietario) {
        validarExistenciaPrevia(propietario);
        this.repositorioPropietario.actualizar(propietario);
    }

    private void validarExistenciaPrevia(Propietario propietario) {
        boolean existe = this.repositorioPropietario.existeExcluyendoId(propietario.getId(), propietario.getNumeroIdentificacion());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
