package com.ceiba.pago.servicio.testdatabuilder;

import com.ceiba.pago.modelo.entidad.Pago;

public class PagoTestDataBuilder {

    private static final Long ID_PROPIETARIO = 1L;
    private static final Long ID_INMUEBLE = 1L;
    private static final int ANIO = 2021;
    private static final Long VALOR_PAGADO = 750000L;
    private static final String FECHA_PAGO = "17/03/2021";

    private Long id;
    private Long idPropietario;
    private Long idInmueble;
    private int anio;
    private Long valorPagado;
    private String fechaPago;

    public PagoTestDataBuilder() {
        this.idPropietario = ID_PROPIETARIO;
        this.idInmueble = ID_INMUEBLE;
        this.anio = ANIO;
        this.valorPagado = VALOR_PAGADO;
        this.fechaPago = FECHA_PAGO;
    }

    public PagoTestDataBuilder conIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
        return this;
    }

    public PagoTestDataBuilder conIdInmueble(Long idInmueble) {
        this.idInmueble = idInmueble;
        return this;
    }

    public PagoTestDataBuilder conAnio(int anio) {
        this.anio = anio;
        return this;
    }

    public PagoTestDataBuilder conValorPagado(Long valorPagado) {
        this.valorPagado = valorPagado;
        return this;
    }

    public PagoTestDataBuilder conFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
        return this;
    }

    public Pago build() {
        return new Pago(this.id, this.idPropietario, this.idInmueble, this.anio, this.valorPagado, this.fechaPago);
    }
}
