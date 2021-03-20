package com.ceiba.inmueble.testdatabuilder;

import com.ceiba.inmueble.comando.ComandoInmueble;

public class ComandoInmuebleTestDataBuilder {

    private static final Long NUMERO_PREDIAL = 12694888L;
    private static final String DIRECCION = "Calle 49 15 - 69";
    private static final int AREA_TOTAL = 250;
    private static final int AREA_CONSTRUIDA = 150;
    private static final Long AVALUO_CATASTRAL = 80000000L;
    private static final int ID_PROPIETARIO = 1;

    private Long id;
    private Long numeroPredial;
    private String direccion;
    private int areaTotal;
    private int areaConstruida;
    private long avaluoCatastral;
    private int idPropietario;

    public ComandoInmuebleTestDataBuilder() {
        this.numeroPredial = NUMERO_PREDIAL;
        this.direccion = DIRECCION;
        this.areaTotal = AREA_TOTAL;
        this.areaConstruida = AREA_CONSTRUIDA;
        this.avaluoCatastral = AVALUO_CATASTRAL;
        this.idPropietario = ID_PROPIETARIO;
    }

    public ComandoInmuebleTestDataBuilder conNumeroPredial(Long numeroPredial) {
        this.numeroPredial = numeroPredial;
        return this;
    }


    public ComandoInmuebleTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ComandoInmuebleTestDataBuilder conAreaTotal(int areaTotal) {
        this.areaTotal = areaTotal;
        return this;
    }

    public ComandoInmuebleTestDataBuilder conAreaConstruida(int areaConstruida) {
        this.areaConstruida = areaConstruida;
        return this;
    }

    public ComandoInmuebleTestDataBuilder conAvaluoCatastral(long avaluoCatastral) {
        this.avaluoCatastral = avaluoCatastral;
        return this;
    }

    public ComandoInmuebleTestDataBuilder conIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
        return this;
    }

    public ComandoInmueble build() {
        return new ComandoInmueble(this.id,
                this.numeroPredial,
                this.direccion,
                this.areaTotal,
                this.areaConstruida,
                this.avaluoCatastral,
                this.idPropietario);
    }
}
