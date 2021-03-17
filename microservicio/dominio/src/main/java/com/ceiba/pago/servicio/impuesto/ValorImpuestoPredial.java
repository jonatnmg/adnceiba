package com.ceiba.pago.servicio.impuesto;


public class ValorImpuestoPredial implements ImpuestoPredial {

    private final Long avaluoCatastral;
    private final double tarifa;
    private final int tarifaPorMil;

    public ValorImpuestoPredial(Long avaluoCatastral, double tarifa, int tarifaPorMil) {
        this.avaluoCatastral = avaluoCatastral;
        this.tarifa = tarifa;
        this.tarifaPorMil = tarifaPorMil;
    }

    @Override
    public double calcular() {
        // 135.343.000 (Avalúo Catastral) x 5,8 (Tarifa) / 1.000 = $ 785.000 | $ 784990.0
        return Math.ceil((this.avaluoCatastral * this.tarifa) / this.tarifaPorMil);
    }
}
