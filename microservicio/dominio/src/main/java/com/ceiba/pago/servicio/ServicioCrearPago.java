package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.inmueble.puerto.dao.DaoInmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import com.ceiba.pago.servicio.impuesto.GestionarImpuestoPredial;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;

public class ServicioCrearPago {

    private final RepositorioPago repositorioPago;
    private final RepositorioInmueble repositorioInmueble;
    private final RepositorioTarifa repositorioTarifa;
    private final GestionarImpuestoPredial gestionarImpuestoPredial;
    private final DaoInmueble daoInmueble;
    private final DaoTarifa daoTarifa;

    public ServicioCrearPago(RepositorioPago repositorioPago, RepositorioInmueble repositorioInmueble, RepositorioTarifa repositorioTarifa, DaoInmueble daoInmueble, DaoTarifa daoTarifa) {
        this.repositorioPago = repositorioPago;
        this.repositorioInmueble = repositorioInmueble;
        this.repositorioTarifa = repositorioTarifa;
        this.daoInmueble = daoInmueble;
        this.daoTarifa = daoTarifa;
        this.gestionarImpuestoPredial = new GestionarImpuestoPredial(repositorioInmueble, repositorioTarifa, daoInmueble, daoTarifa);
    }

    private static final String EL_PAGO_YA_EXISTE_EN_EL_SISTEMA = "El pago ya existe en el sistema";


    public Long ejecutar(Pago pago) {

        this.gestionarImpuestoPredial.validarDiasParaPago(pago);
        this.gestionarImpuestoPredial.verificarValorPagado(pago);

        this.validarExistenciaPrevia(pago);

        return this.repositorioPago.crear(pago);
    }

    private void validarExistenciaPrevia(Pago pago) {
        boolean existe = this.repositorioPago.existe(pago.getIdPropietario(), pago.getIdInmueble(), pago.getAnio());

        if (existe) {
            throw new ExcepcionDuplicidad(EL_PAGO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


}