package com.ceiba.inmueble.testdatabuilder;

import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.testdatabuilder.PropietarioTestDataBuilder;

public class InmuebleTestDataBuilder {

    private static final Long NUMERO_PREDIAL = 12694888L;
    private static final String DIRECCION = "Calle 49 15 - 69";
    private static final int AREA_TOTAL = 250;
    private static final int AREA_CONSTRUIDA = 150;
    private static final Long AVALUO_CATASTRAL = 80000000L;

    private Long id;
    private Long numeroPredial;
    private String direccion;
    private int areaTotal;
    private int areaConstruida;
    private long avaluoCatastral;
    private Propietario propietario;

    public InmuebleTestDataBuilder() {

        this.numeroPredial = InmuebleTestDataBuilder.NUMERO_PREDIAL;
        this.direccion = InmuebleTestDataBuilder.DIRECCION;
        this.areaTotal = InmuebleTestDataBuilder.AREA_TOTAL;
        this.areaConstruida = InmuebleTestDataBuilder.AREA_CONSTRUIDA;
        this.avaluoCatastral = InmuebleTestDataBuilder.AVALUO_CATASTRAL;
        this.propietario = new PropietarioTestDataBuilder().build();
    }

    public InmuebleTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public InmuebleTestDataBuilder conNumeroPredial(Long numeroPredial) {
        this.numeroPredial = numeroPredial;
        return this;
    }

    public InmuebleTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public InmuebleTestDataBuilder conAreaTotal(int areaTotal) {
        this.areaTotal = areaTotal;
        return this;
    }

    public InmuebleTestDataBuilder conAreaConstruida(int areaConstruida) {
        this.areaConstruida = areaConstruida;
        return this;
    }

    public InmuebleTestDataBuilder conAvaluoCatastral(long avaluoCatastral) {
        this.avaluoCatastral = avaluoCatastral;
        return this;
    }

    public InmuebleTestDataBuilder conPropietario(Propietario propietario) {
        this.propietario = propietario;
        return this;
    }

    public Inmueble build() {
        return new Inmueble(id, numeroPredial, direccion, areaTotal, areaConstruida, avaluoCatastral, propietario);
    }
}
