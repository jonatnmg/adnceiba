package com.ceiba.pago.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Pago {

    private static final String SE_DEBE_INGRESAR_UN_PROPIETARIO = "Se debe ingresar un identificador de propietario";
    private static final String SE_DEBE_INGRESAR_UN_INMUEBLE = "Se debe ingresar un identificador de inmueble";
    private static final String SE_DEBE_INGRESAR_UN_ANIO = "Se debe ingresar un año";
    private static final String SE_DEBE_INGRESAR_UN_VALOR_PAGADO = "Se debe ingresar un valor pagado";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA = "Se debe ingresar una fecha";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA_CON_EL_FORMATO = "Se debe ingresar una fecha con el formato %s";

    private static final String EL_ANIO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El anio debe tener una longitud mayor o igual a %s";

    private static final int LONGITUD_MINIMA_ANIO = 4;
    private static final String FORMATO_FECHA_CORRECTO = "d/MM/yyyy";
    private static final String EXPRESION_REGULAR_FECHA = "^([0-2][0-9]|3[0-1])(\\/)(0[1-9]|1[0-2])\\2(\\d{4})$";

    private Long id;
    private Long idPropietario;
    private Long idInmueble;
    private int anio;
    private Long valorPagado;
    private LocalDate fechaPago;

    public Pago(Long id, Long propietario, Long inmueble, int anio, Long valorPagado, String fechaPago) {

        ValidadorArgumento.validarObligatorio(propietario, SE_DEBE_INGRESAR_UN_PROPIETARIO);
        ValidadorArgumento.validarObligatorio(inmueble, SE_DEBE_INGRESAR_UN_INMUEBLE);
        ValidadorArgumento.validarObligatorio(valorPagado, SE_DEBE_INGRESAR_UN_VALOR_PAGADO);
        ValidadorArgumento.validarObligatorio(fechaPago, SE_DEBE_INGRESAR_UNA_FECHA);

        ValidadorArgumento.validarPositivo(propietario, SE_DEBE_INGRESAR_UN_PROPIETARIO);
        ValidadorArgumento.validarPositivo(inmueble, SE_DEBE_INGRESAR_UN_INMUEBLE);
        ValidadorArgumento.validarPositivo(anio, SE_DEBE_INGRESAR_UN_ANIO);
        ValidadorArgumento.validarPositivo(valorPagado, SE_DEBE_INGRESAR_UN_VALOR_PAGADO);

        ValidadorArgumento.validarLongitudMinima(anio, LONGITUD_MINIMA_ANIO, String.format(EL_ANIO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ANIO));

        ValidadorArgumento.validarRegex(fechaPago, EXPRESION_REGULAR_FECHA, String.format(SE_DEBE_INGRESAR_UNA_FECHA_CON_EL_FORMATO, FORMATO_FECHA_CORRECTO));

        this.id = id;
        this.idPropietario = propietario;
        this.idInmueble = inmueble;
        this.anio = anio;
        this.valorPagado = valorPagado;
        this.fechaPago = ValidadorArgumento.verificarFecha(fechaPago, String.format(SE_DEBE_INGRESAR_UNA_FECHA_CON_EL_FORMATO, FORMATO_FECHA_CORRECTO), FORMATO_FECHA_CORRECTO);
    }
}
