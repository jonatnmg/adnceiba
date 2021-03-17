package com.ceiba.pago.servicio.testdatabuilder;

import com.ceiba.pago.comando.ComandoPago;

public class ComandoPagoTestDataBuilder {

    private static final Long ID_PROPIETARIO = 1L;
    private static final Long ID_INMUEBLE = 1L;
    private static final int ANIO = 2021;
    private static final Long VALOR_PAGADO = 704477l;
    private static final String FECHA_PAGO = "17/03/2021";

    private Long id;
    private Long idPropietario;
    private Long idInmueble;
    private int anio;
    private Long valorPagado;
    private String fecha;

    public ComandoPagoTestDataBuilder() {
        this.idPropietario = ID_PROPIETARIO;
        this.idInmueble = ID_INMUEBLE;
        this.anio = ANIO;
        this.valorPagado = VALOR_PAGADO;
        this.fecha = FECHA_PAGO;
    }

    public ComandoPagoTestDataBuilder conValorPagado(Long valorPagado) {
        this.valorPagado = valorPagado;
        return this;
    }

    public ComandoPago build() {
        return new ComandoPago(this.id, this.idPropietario, this.idInmueble, this.anio, this.valorPagado, this.fecha);
    }
}
