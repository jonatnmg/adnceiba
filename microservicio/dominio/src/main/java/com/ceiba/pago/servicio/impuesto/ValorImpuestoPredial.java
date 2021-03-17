package com.ceiba.pago.servicio.impuesto;


public class ValorImpuestoPredial implements ImpuestoPredial {

    private final Long avaluoCatastral;
    private final Double tarifa;
    private final int tarifaPorMil;

    public ValorImpuestoPredial(Long avaluoCatastral, double tarifa, int tarifaPorMil) {
        this.avaluoCatastral = avaluoCatastral;
        this.tarifa = tarifa;
        this.tarifaPorMil = tarifaPorMil;
    }

    @Override
    public int calcular() {
        double valor = Math.ceil((this.avaluoCatastral * this.tarifa) / this.tarifaPorMil);
        return (int) valor;
    }
}
