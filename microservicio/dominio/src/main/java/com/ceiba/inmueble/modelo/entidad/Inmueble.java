package com.ceiba.inmueble.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.propietario.modelo.entidad.Propietario;
import lombok.Getter;

@Getter
public class Inmueble {

    private static final String SE_DEBE_INGRESAR_NUMERO_PREDIAL = "Se debe ingresar el numero predial";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar una direccion";
    private static final String SE_DEBE_INGRESAR_AREA_TOTAL = "Se debe ingresar area total";
    private static final String SE_DEBE_INGRESAR_AREA_CONSTRUIDA = "Se debe ingresar area construida";
    private static final String SE_DEBE_INGRESAR_AVALUO_CATASTRAL = "Se debe ingresar avaluo catastral";

    private static final String EL_PROPIETARIO_ES_OBLIGATORIO = "Debe ingresar un ID de propietario";

    private static final String EL_AREA_TOTAL_DEBE_SER_MAYOR_O_IGUAL_A = "El area total debe ser mayor o igual a %s";
    private static final String EL_AREA_CONSTRUIDA_DEBE_SER_MAYOR_O_IGUAL_A = "El area construida debe ser mayor o igual a %s";
    private static final String EL_AREA_CONSTRUIDA_NO_DEBE_SER_MAYOR_A_AREA_TOTAL = "El area construida no debe ser mayor al area total";
    private static final String LA_LONGITUD_DE_LADIRECCION_DEBE_SER_MAYOR_O_IGUAL_ADIRECCION_DEBE_SER_MAYOR_O_IGUAL_A = "La longitud de la direccion debe ser mayor o igual a %s";

    private static final String EL_NUMERO_PREDIAL_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El numero predial debe tener una longitud mayor o igual a %s";

    private static final int LONGITUD_MINIMA_NUMERO_PREDIAL = 6;
    private static final int LONGITUD_MINIMA_DIRECCION = 3;
    private static final int VALOR_MINIMO_AREA_TOTAL = 1;
    private static final int VALOR_MINIMO_AREA_CONSTRUIDA = 0;

    private Long id;
    private Long numeroPredial;
    private String direccion;
    private int areaTotal;
    private int areaConstruida;
    private long avaluoCatastral;
    private Propietario propietario;

    public Inmueble(Long id, Long numeroPredial, String direccion, int areaTotal, int areaConstruida, long avaluoCatastral, Propietario propietario) {

        ValidadorArgumento.validarObligatorio(numeroPredial, SE_DEBE_INGRESAR_NUMERO_PREDIAL);
        ValidadorArgumento.validarObligatorio(direccion, SE_DEBE_INGRESAR_DIRECCION);
        ValidadorArgumento.validarObligatorio(areaTotal, SE_DEBE_INGRESAR_AREA_TOTAL);
        ValidadorArgumento.validarObligatorio(areaConstruida, SE_DEBE_INGRESAR_AREA_CONSTRUIDA);
        ValidadorArgumento.validarObligatorio(avaluoCatastral, SE_DEBE_INGRESAR_AVALUO_CATASTRAL);
        ValidadorArgumento.validarObligatorio(propietario, EL_PROPIETARIO_ES_OBLIGATORIO);

        ValidadorArgumento.validarLongitud(direccion, LONGITUD_MINIMA_DIRECCION, String.format(LA_LONGITUD_DE_LADIRECCION_DEBE_SER_MAYOR_O_IGUAL_ADIRECCION_DEBE_SER_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_DIRECCION));
        ValidadorArgumento.validarLongitud(numeroPredial.toString(), LONGITUD_MINIMA_NUMERO_PREDIAL, String.format(EL_NUMERO_PREDIAL_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_NUMERO_PREDIAL));

        ValidadorArgumento.validarPositivo(numeroPredial, SE_DEBE_INGRESAR_NUMERO_PREDIAL);
        ValidadorArgumento.validarPositivo(avaluoCatastral, SE_DEBE_INGRESAR_AVALUO_CATASTRAL);

        ValidadorArgumento.validarMenor(VALOR_MINIMO_AREA_TOTAL, areaTotal, String.format(EL_AREA_TOTAL_DEBE_SER_MAYOR_O_IGUAL_A, VALOR_MINIMO_AREA_TOTAL));
        ValidadorArgumento.validarMenor(areaConstruida, areaTotal, EL_AREA_CONSTRUIDA_NO_DEBE_SER_MAYOR_A_AREA_TOTAL);

        ValidadorArgumento.validarMayorIgualACero(areaConstruida, String.format(EL_AREA_CONSTRUIDA_DEBE_SER_MAYOR_O_IGUAL_A, VALOR_MINIMO_AREA_CONSTRUIDA));

        this.id = id;
        this.numeroPredial = numeroPredial;
        this.direccion = direccion;
        this.areaTotal = areaTotal;
        this.areaConstruida = areaConstruida;
        this.avaluoCatastral = avaluoCatastral;
        this.propietario = propietario;
    }
}
