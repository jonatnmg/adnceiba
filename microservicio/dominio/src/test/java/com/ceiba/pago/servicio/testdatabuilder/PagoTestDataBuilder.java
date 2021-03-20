package com.ceiba.pago.servicio.testdatabuilder;

import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.testdatabuilder.InmuebleTestDataBuilder;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.servicio.testdatabuilder.PropietarioTestDataBuilder;
import com.ceiba.tarifa.modelo.entidad.Tarifa;

import java.time.LocalDate;

public class PagoTestDataBuilder {

    private static final int ANIO = 2021;
    private static final Long VALOR_PAGADO = 750000L;
    private static final LocalDate FECHA_PAGO = LocalDate.now();

    private Long id;
    private Propietario propietario;
    private Inmueble inmueble;
    private Tarifa tarifa;
    private int anio;
    private Long valorPagado;
    private LocalDate fechaPago;

    public PagoTestDataBuilder() {

        Propietario propietario = new PropietarioTestDataBuilder().build();
        Inmueble inmueble = new InmuebleTestDataBuilder().build();

        this.propietario = propietario;
        this.inmueble = inmueble;
        this.anio = ANIO;
        this.valorPagado = VALOR_PAGADO;
        this.fechaPago = FECHA_PAGO;
    }

    public PagoTestDataBuilder conPropietario(Propietario propietario) {
        this.propietario = propietario;
        return this;
    }

    public PagoTestDataBuilder conInmueble(Inmueble idInmueble) {
        this.inmueble = inmueble;
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

    public PagoTestDataBuilder conFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
        return this;
    }

    public PagoTestDataBuilder conTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
        return this;
    }

    public PagoImpuestoPredial build() {
        return new PagoImpuestoPredial(this.id, this.propietario, this.inmueble, this.anio, this.valorPagado, this.fechaPago, this.tarifa);
    }
}
