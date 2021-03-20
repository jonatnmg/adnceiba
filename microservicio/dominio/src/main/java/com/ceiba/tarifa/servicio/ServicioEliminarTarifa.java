package com.ceiba.tarifa.servicio;

import com.ceiba.dominio.excepcion.ExcepcionRegistroVinculado;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;

public class ServicioEliminarTarifa {

    private static final String TARIFA_NO_SE_ENCONTRO_EN_EL_SISTEMA = "Tarifa no encontrada en el sistema";
    private static final String NO_SE_PUEDE_ELIMINAR_TARIFA_ASOCIADO_A_UN_PAGO_IMPUESTO_PREDIAL = "No se puede eliminar tarifa esta asociado a un pago impuesto predial";

    private final RepositorioTarifa repositorioTarifa;
    private final RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial;

    public ServicioEliminarTarifa(RepositorioTarifa repositorioTarifa, RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        this.repositorioTarifa = repositorioTarifa;
        this.repositorioPagoImpuestoPredial = repositorioPagoImpuestoPredial;
    }

    public void ejecutar(Long id) {
        this.validarExisteTarifaPorId(id);
        this.validarExisteTarifaEnPagoImpuestoPredial(id);

        this.repositorioTarifa.eliminar(id);
    }

    private void validarExisteTarifaPorId(Long idTarifa) {
        boolean existe = this.repositorioTarifa.existePorId(idTarifa);
        if (!existe) {
            throw new ExcepcionSinDatos(TARIFA_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }

    private void validarExisteTarifaEnPagoImpuestoPredial(Long idTarifa) {
        boolean existe = this.repositorioPagoImpuestoPredial.existeTarifaEnPagoImpuestoPredial(idTarifa);

        if (existe) {
            throw new ExcepcionRegistroVinculado(NO_SE_PUEDE_ELIMINAR_TARIFA_ASOCIADO_A_UN_PAGO_IMPUESTO_PREDIAL);
        }
    }
}
