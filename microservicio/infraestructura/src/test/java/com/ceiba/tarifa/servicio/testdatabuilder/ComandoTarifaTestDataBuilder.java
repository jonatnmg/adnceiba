package com.ceiba.tarifa.servicio.testdatabuilder;

import com.ceiba.tarifa.comando.ComandoTarifa;

public class ComandoTarifaTestDataBuilder {

    private static final Long AVALUO_MINIMO = 0L;
    private static final Long AVALUO_MAXIMO = 128000000L;
    private static final double VALOR_TARIFA = 5.5;
    private static final int ANIO_TARIFA = 2021;

    private Long id;
    private Long avaluoMinimo;
    private Long avaluoMaximo;
    private double tarifa;
    private int anio;

    public ComandoTarifaTestDataBuilder() {
        this.avaluoMinimo = AVALUO_MINIMO;
        this.avaluoMaximo = AVALUO_MAXIMO;
        this.tarifa = VALOR_TARIFA;
        this.anio = ANIO_TARIFA;
    }

    public ComandoTarifaTestDataBuilder conAvaluoMinimo(Long avaluoMinimo) {
        this.avaluoMinimo = avaluoMinimo;
        return this;
    }

    public ComandoTarifaTestDataBuilder conAvaluoMaximo(Long avaluoMaximo) {
        this.avaluoMaximo = avaluoMaximo;
        return this;
    }

    public ComandoTarifaTestDataBuilder conTarifa(double tarifa) {
        this.tarifa = tarifa;
        return this;
    }

    public ComandoTarifaTestDataBuilder conAnio(int anio) {
        this.anio = anio;
        return this;
    }

    public ComandoTarifa build() {
        return new ComandoTarifa(this.id, this.avaluoMinimo, this.avaluoMaximo, this.tarifa, this.anio);
    }
}
