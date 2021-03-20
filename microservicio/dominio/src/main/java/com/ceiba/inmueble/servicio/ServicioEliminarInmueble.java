package com.ceiba.inmueble.servicio;

import com.ceiba.dominio.excepcion.ExcepcionRegistroVinculado;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;

public class ServicioEliminarInmueble {

    private static final String EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El inmueble no existe en el sistema";
    private static final String NO_SE_PUEDE_ELIMINAR_IMUEBLE_ASOCIADO_PAGO_IMPUESTO_PREDIAL = "No se puede eliminar inmueble esta asociado a un pago impuesto predial";

    private final RepositorioInmueble repositorioInmueble;
    private final RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial;

    public ServicioEliminarInmueble(RepositorioInmueble repositorioInmueble, RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        this.repositorioInmueble = repositorioInmueble;
        this.repositorioPagoImpuestoPredial = repositorioPagoImpuestoPredial;
    }

    public void ejecutar(Long id) {
        this.verificarExisteInmueble(id);
        this.verificarExisteInmuebleEnPagoImpuestoPredial(id);

        this.repositorioInmueble.eliminar(id);
    }

    private void verificarExisteInmueble(Long idInmueble) {
        boolean existe = this.repositorioInmueble.existePorId(idInmueble);
        if (!existe) {
            throw new ExcepcionSinDatos(EL_INMUEBLE_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }

    private void verificarExisteInmuebleEnPagoImpuestoPredial(Long idInmueble) {
        boolean existe = this.repositorioPagoImpuestoPredial.existeInmuebleEnPagoImpuestoPredial(idInmueble);

        if (existe) {
            throw new ExcepcionRegistroVinculado(NO_SE_PUEDE_ELIMINAR_IMUEBLE_ASOCIADO_PAGO_IMPUESTO_PREDIAL);
        }
    }
}
