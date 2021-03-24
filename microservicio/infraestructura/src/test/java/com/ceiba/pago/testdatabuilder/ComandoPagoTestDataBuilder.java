package com.ceiba.pago.testdatabuilder;

import com.ceiba.pago.comando.ComandoPagoImpuestoPredial;

import java.time.LocalDate;

public class ComandoPagoTestDataBuilder {

    private static final Long ID_PROPIETARIO = 1L;
    private static final Long ID_INMUEBLE = 1L;
    private static final int ANIO = 2021;
    private static final long ID_TARIFA = 1L;
    private static final Long VALOR_PAGADO = 782753L;
    private static final LocalDate FECHA_PAGO = LocalDate.of(2021, 5, 12);

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
        this.idTarifa = ID_TARIFA;
        this.anio = ANIO;
        this.valorPagado = VALOR_PAGADO;
        this.fecha = FECHA_PAGO;
    }

    public ComandoPagoTestDataBuilder conValorPagado(Long valorPagado) {
        this.valorPagado = valorPagado;
        return this;
    }

    public ComandoPagoTestDataBuilder conIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
        return this;
    }

    public ComandoPagoTestDataBuilder conIdInmueble(Long idInmueble) {
        this.idInmueble = idInmueble;
        return this;
    }

    public ComandoPagoTestDataBuilder conIdTarifa(Long idTarifa) {
        this.idTarifa = idTarifa;
        return this;
    }

    public ComandoPagoTestDataBuilder conAnio(int anio) {
        this.anio = anio;
        return this;
    }

    public ComandoPagoImpuestoPredial build() {
        return new ComandoPagoImpuestoPredial(this.id, this.idPropietario, this.idInmueble, this.idTarifa, this.anio, this.valorPagado, this.fecha);
    }
}
