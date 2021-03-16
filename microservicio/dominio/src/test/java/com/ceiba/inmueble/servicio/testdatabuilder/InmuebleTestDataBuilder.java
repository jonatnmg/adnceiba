package com.ceiba.inmueble.servicio.testdatabuilder;

import com.ceiba.inmueble.modelo.entidad.Inmueble;

public class InmuebleTestDataBuilder {

    private static final Long NUMERO_PREDIAL = 12694888L;
    private static final int CODIGO_POSTAL = 635897;
    private static final String DIRECCION = "Calle 49 15 - 69";
    private static final int AREA_TOTAL = 250;
    private static final int AREA_CONSTRUIDA = 150;
    private static final Long AVALUO_CATASTRAL = 80000000L;
    private static final Long ID_PROPIETARIO = 1L;

    private Long id;
    private Long numeroPredial;
    private int codigoPostal;
    private String direccion;
    private int areaTotal;
    private int areaConstruida;
    private long avaluoCatastral;
    private long idPropietario;

    public InmuebleTestDataBuilder() {

        this.numeroPredial = InmuebleTestDataBuilder.NUMERO_PREDIAL;
        this.codigoPostal = InmuebleTestDataBuilder.CODIGO_POSTAL;
        this.direccion = InmuebleTestDataBuilder.DIRECCION;
        this.areaTotal = InmuebleTestDataBuilder.AREA_TOTAL;
        this.areaConstruida = InmuebleTestDataBuilder.AREA_CONSTRUIDA;
        this.avaluoCatastral = InmuebleTestDataBuilder.AVALUO_CATASTRAL;
        this.idPropietario = InmuebleTestDataBuilder.ID_PROPIETARIO;
    }

    public InmuebleTestDataBuilder conNumeroPredial(Long numeroPredial) {
        this.numeroPredial = numeroPredial;
        return this;
    }

    public InmuebleTestDataBuilder conCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    public InmuebleTestDataBuilder conIdPropietario(long idPropietario) {
        this.idPropietario = idPropietario;
        return this;
    }

    public Inmueble build() {
        return new Inmueble(id, numeroPredial, codigoPostal, direccion, areaTotal, areaConstruida, avaluoCatastral, idPropietario);
    }
}
