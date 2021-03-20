package com.ceiba.tarifa.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;

public class ServicioActualizarTarifa {

    private static final String ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA = "Este rango de avaluo ya existe en el sistema";
    private static final String TARIFA_NO_SE_ENCONTRO_EN_EL_SISTEMA = "Tarifa no encontrada en el sistema";

    private final RepositorioTarifa repositorioTarifa;

    public ServicioActualizarTarifa(RepositorioTarifa repositorioTarifa) {
        this.repositorioTarifa = repositorioTarifa;
    }

    public void ejecutar(Tarifa tarifa) {
        this.validarExistenciaTarifaPorId(tarifa);
        this.validarExistenciaPrevia(tarifa);
        this.repositorioTarifa.actualizar(tarifa);
    }

    private void validarExistenciaPrevia(Tarifa tarifa) {
        boolean existe = this.repositorioTarifa.existeExcluyendoId(tarifa.getId(),
                tarifa.getAvaluoMinimo(),
                tarifa.getAvaluoMaximo(),
                tarifa.getAnio());

        if (existe) {
            throw new ExcepcionDuplicidad(ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaTarifaPorId(Tarifa tarifa) {
        boolean existe = this.repositorioTarifa.existePorId(tarifa.getId());

        if (!existe) {
            throw new ExcepcionSinDatos(TARIFA_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }
}
