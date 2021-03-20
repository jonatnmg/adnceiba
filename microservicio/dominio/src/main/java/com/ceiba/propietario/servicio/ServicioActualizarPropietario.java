package com.ceiba.propietario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;

public class ServicioActualizarPropietario {

    private static final String EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA = "El propietario ya existe en el sistema";
    private static final String EL_PROPIETARIO_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El propietario no se encontro en el sistema";

    private final RepositorioPropietario repositorioPropietario;

    public ServicioActualizarPropietario(RepositorioPropietario repositorioPropietario) {
        this.repositorioPropietario = repositorioPropietario;
    }

    public void ejecutar(Propietario propietario) {
        this.validarExistenciaPropietarioPorId(propietario);
        this.validarExistenciaPrevia(propietario);
        this.repositorioPropietario.actualizar(propietario);
    }

    private void validarExistenciaPrevia(Propietario propietario) {
        boolean existe = this.repositorioPropietario.existeExcluyendoId(propietario.getId(), propietario.getNumeroIdentificacion());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_PROPIETARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPropietarioPorId(Propietario propietario) {
        boolean existe = this.repositorioPropietario.existePorId(propietario.getId());

        if (!existe) {
            throw new ExcepcionSinDatos(EL_PROPIETARIO_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }
}
