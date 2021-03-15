package com.ceiba.tarifa.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;

public class ServicioCrearTarifa {

    private static final String ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA = "Este rango de avaluo ya existe en el sistema";

    private final RepositorioTarifa repositorioTarifa;

    public ServicioCrearTarifa(RepositorioTarifa repositorioTarifa) {
        this.repositorioTarifa = repositorioTarifa;
    }

    public Long ejecutar(Tarifa tarifa) {
        this.validarExistenciaPrevia(tarifa);
        return this.repositorioTarifa.crear(tarifa);
    }

    private void validarExistenciaPrevia(Tarifa tarifa) {
        boolean existe = this.repositorioTarifa.existe(tarifa.getAvaluoMinimo(),
                tarifa.getAvaluoMaximo(),
                tarifa.getAnio());

        if (existe) {
            throw new ExcepcionDuplicidad(ESTE_RANGO_AVALUO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
