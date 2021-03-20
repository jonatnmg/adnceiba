package com.ceiba.tarifa.testdatabuilder;

import com.ceiba.tarifa.modelo.entidad.Tarifa;

public class TarifaTestDataBuilder {

    public static final Long AVALUO_MINIMO = 0L;
    public static final Long AVALUO_MAXIMO = 128000000L;
    public static final double VALOR_TARIFA = 5.5;
    public static final int ANIO_TARIFA = 2021;

    private Long id;
    private Long avaluoMinimo;
    private Long avaluoMaximo;
    private double valor;
    private int anio;

    public TarifaTestDataBuilder() {

        this.avaluoMinimo = TarifaTestDataBuilder.AVALUO_MINIMO;
        this.avaluoMaximo = TarifaTestDataBuilder.AVALUO_MAXIMO;
        this.valor = TarifaTestDataBuilder.VALOR_TARIFA;
        this.anio = TarifaTestDataBuilder.ANIO_TARIFA;
    }

    public TarifaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TarifaTestDataBuilder conAvaluoMinimo(Long avaluoMinimo) {
        this.avaluoMinimo = avaluoMinimo;
        return this;
    }

    public TarifaTestDataBuilder conAvaluoMaximo(Long avaluoMaximo) {
        this.avaluoMaximo = avaluoMaximo;
        return this;
    }

    public TarifaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public TarifaTestDataBuilder conAnio(Integer anio) {
        this.anio = anio;
        return this;
    }

    public Tarifa build() {
        return new Tarifa(id, avaluoMinimo, avaluoMaximo, valor, anio);
    }
}
