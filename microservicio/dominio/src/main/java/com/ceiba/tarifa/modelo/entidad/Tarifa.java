package com.ceiba.tarifa.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

@Getter
public class Tarifa {

    private static final String SE_DEBE_INGRESAR_AVALUO_MINIMO = "Se debe ingresar un avaluo minimo";
    private static final String SE_DEBE_INGRESAR_AVALUO_MAXIMO = "Se debe ingresar un avaluo maximo";
    private static final String SE_DEBE_INGRESAR_UNA_TARIFA = "Se debe ingresar una tarifa";
    private static final String SE_DEBE_INGRESAR_UN_ANIO = "Se debe ingresar un año";
    private static final String EL_ANIO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El anio debe tener una longitud mayor o igual a %s";
    private static final String EL_AVALUO_MINIMO_DEBE_SER_MAYOR_O_IGUAL_A = "El avaluo minimo debe ser mayor o igual a %s";
    private static final String EL_AVALUO_MAXIMO_DEBE_SER_MAYOR_O_IGUAL_A = "El avaluo maximo debe ser mayor o igual a %s";
    private static final String EL_RANGO_DE_AVALUO_INCORRECTO = "Rango de avaluo incorrecto";

    private static final int VALOR_MINIMO_PARA_AVALUO_MINIMO = 0;
    private static final int VALOR_MINIMO_PARA_AVALUO_MAXIMO = 1;
    private static final int LONGITUD_MINIMA_ANIO = 4;

    private Long id;
    private Long avaluoMinimo;
    private Long avaluoMaximo;
    private double valor;
    private int anio;

    public Tarifa(Long id, Long avaluoMinimo, Long avaluoMaximo, double valor, int anio) {
        ValidadorArgumento.validarObligatorio(avaluoMinimo, SE_DEBE_INGRESAR_AVALUO_MINIMO);
        ValidadorArgumento.validarObligatorio(avaluoMaximo, SE_DEBE_INGRESAR_AVALUO_MAXIMO);
        ValidadorArgumento.validarObligatorio(valor, SE_DEBE_INGRESAR_UNA_TARIFA);
        ValidadorArgumento.validarObligatorio(anio, SE_DEBE_INGRESAR_UN_ANIO);

        ValidadorArgumento.validarLongitudMinima(anio, LONGITUD_MINIMA_ANIO, String.format(EL_ANIO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ANIO));

        ValidadorArgumento.validarPositivo(valor, SE_DEBE_INGRESAR_UNA_TARIFA);

        ValidadorArgumento.validarMayorIgualACero(avaluoMinimo, String.format(EL_AVALUO_MINIMO_DEBE_SER_MAYOR_O_IGUAL_A, VALOR_MINIMO_PARA_AVALUO_MINIMO));

        ValidadorArgumento.validarPositivo(avaluoMaximo, String.format(EL_AVALUO_MAXIMO_DEBE_SER_MAYOR_O_IGUAL_A, VALOR_MINIMO_PARA_AVALUO_MAXIMO));
        ValidadorArgumento.validarPositivo(anio, SE_DEBE_INGRESAR_UN_ANIO);

        ValidadorArgumento.validarMenor(avaluoMinimo, avaluoMaximo, EL_RANGO_DE_AVALUO_INCORRECTO);

        this.id = id;
        this.avaluoMinimo = avaluoMinimo;
        this.avaluoMaximo = avaluoMaximo;
        this.valor = valor;
        this.anio = anio;
    }
}
