package com.ceiba.pago.testdatabuilder;

import com.ceiba.pago.comando.ComandoPagoImpuestoPredial;

import java.time.LocalDate;

public class ComandoPagoTestDataBuilder {

    private static final Long ID_PROPIETARIO = 1L;
    private static final Long ID_INMUEBLE = 1L;
    private static final int ANIO = 2021;
    private static final Long VALOR_PAGADO = 704477l;
    private static final LocalDate FECHA_PAGO = LocalDate.now();

    private Long id;
    private Long idPropietario;
    private Long idInmueble;
    private Long idTarifa;
    private int anio;
    private Long valorPagado;
    private LocalDate fecha;

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

    public ComandoPagoImpuestoPredial build() {
        return new ComandoPagoImpuestoPredial(this.id, this.idPropietario, this.idInmueble, this.idTarifa, this.anio, this.valorPagado, this.fecha);
    }
}
