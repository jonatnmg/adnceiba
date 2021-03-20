package com.ceiba.propietario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionRegistroVinculado;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;

public class ServicioEliminarPropietario {

    private static final String EL_PROPIETARIO_NO_SE_ENCONTRO_EN_EL_SISTEMA = "El propietario no se encontro en el sistema";
    private static final String NO_SE_PUEDE_ELIMINAR_EL_PROPIETARIO_ASOCIADO_INMUEBLE = "No se puede eliminar el propietario, esta asociado a un inmueble";
    private static final String NO_SE_PUEDE_ELIMINAR_EL_PROPIETARIO_ASOCIADO_PAGO_IMPUESTO = "No se puede eliminar el propietario, esta asociado a un pago impuesto predial";

    private final RepositorioPropietario repositorioPropietario;
    private final RepositorioInmueble repositorioInmueble;
    private final RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial;


    public ServicioEliminarPropietario(RepositorioPropietario repositorioPropietario, RepositorioInmueble repositorioInmueble, RepositorioPagoImpuestoPredial repositorioPagoImpuestoPredial) {
        this.repositorioPropietario = repositorioPropietario;
        this.repositorioInmueble = repositorioInmueble;
        this.repositorioPagoImpuestoPredial = repositorioPagoImpuestoPredial;
    }

    public void ejecutar(Long id) {
        this.validarExistenciaPropietarioPorId(id);
        this.validarExistenciaPropietarioEnInmueble(id);
        this.validarExistenciaPropietarioEnPagoImpuestoPredial(id);

        this.repositorioPropietario.eliminar(id);
    }

    private void validarExistenciaPropietarioPorId(Long id) {
        boolean existe = this.repositorioPropietario.existePorId(id);

        if (!existe) {
            throw new ExcepcionSinDatos(EL_PROPIETARIO_NO_SE_ENCONTRO_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPropietarioEnInmueble(Long id) {
        boolean existe = this.repositorioInmueble.existePropietarioEnInmueble(id);

        if (existe) {
            throw new ExcepcionRegistroVinculado(NO_SE_PUEDE_ELIMINAR_EL_PROPIETARIO_ASOCIADO_INMUEBLE);
        }
    }

    private void validarExistenciaPropietarioEnPagoImpuestoPredial(Long id) {
        boolean existe = this.repositorioPagoImpuestoPredial.existePropietarioEnPagoImpuestoPredial(id);

        if (existe) {
            throw new ExcepcionRegistroVinculado(NO_SE_PUEDE_ELIMINAR_EL_PROPIETARIO_ASOCIADO_PAGO_IMPUESTO);
        }
    }

}
