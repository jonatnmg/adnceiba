package com.ceiba.tarifa.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;

public class ServicioEliminarTarifa {

    private static final String TARIFA_NO_SE_ENCONTRO_EN_EL_SISTEMA = "Tarifa no encontrada en el sistema";
    private final RepositorioTarifa repositorioTarifa;

    public ServicioEliminarTarifa(RepositorioTarifa repositorioTarifa) {
        this.repositorioTarifa = repositorioTarifa;
    }

    public void ejecutar(Long id) {
        this.validarExisteTarifaPorId(id);
        this.repositorioTarifa.eliminar(id);
    }

    private void validarExisteTarifaPorId(Long idTarifa) {
        boolean existe = this.repositorioTarifa.existePorId(idTarifa);
        if (!existe) {
            throw new ExcepcionSinDatos(TARIFA_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }
}
