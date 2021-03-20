package com.ceiba.pago.testdatabuilder;

import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.testdatabuilder.InmuebleTestDataBuilder;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.testdatabuilder.PropietarioTestDataBuilder;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.testdatabuilder.TarifaTestDataBuilder;

import java.time.LocalDate;

public class PagoImpuestoPredialTestDataBuilder {

    private static final int ANIO = 2021;
    private static final Long VALOR_PAGADO = 750000L;
    private static final LocalDate FECHA_PAGO = LocalDate.of(2021, 3, 10);

    private Long id;
    private Propietario propietario;
    private Inmueble inmueble;
    private Tarifa tarifa;
    private int anio;
    private Long valorPagado;
    private LocalDate fechaPago;

    public PagoImpuestoPredialTestDataBuilder() {

        Propietario propietario = new PropietarioTestDataBuilder().build();
        Inmueble inmueble = new InmuebleTestDataBuilder().build();
        Tarifa tarifa = new TarifaTestDataBuilder().build();

        this.propietario = propietario;
        this.inmueble = inmueble;
        this.anio = ANIO;
        this.valorPagado = VALOR_PAGADO;
        this.fechaPago = FECHA_PAGO;
        this.tarifa = tarifa;
    }

    public PagoImpuestoPredialTestDataBuilder conPropietario(Propietario propietario) {
        this.propietario = propietario;
        return this;
    }

    public PagoImpuestoPredialTestDataBuilder conInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
        return this;
    }

    public PagoImpuestoPredialTestDataBuilder conAnio(int anio) {
        this.anio = anio;
        return this;
    }

    public PagoImpuestoPredialTestDataBuilder conValorPagado(Long valorPagado) {
        this.valorPagado = valorPagado;
        return this;
    }

    public PagoImpuestoPredialTestDataBuilder conFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
        return this;
    }

    public PagoImpuestoPredialTestDataBuilder conTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
        return this;
    }

    public PagoImpuestoPredial build() {
        return new PagoImpuestoPredial(this.id, this.propietario, this.inmueble, this.anio, this.valorPagado, this.fechaPago, this.tarifa);
    }
}
