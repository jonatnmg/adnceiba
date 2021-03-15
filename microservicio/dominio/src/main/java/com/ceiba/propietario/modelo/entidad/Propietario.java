package com.ceiba.propietario.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

@Getter
public class Propietario {

    private static final String SE_DEBE_INGRESAR_NOMBRE = "Se debe ingresar el nombre del propietario";
    private static final String SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION = "Se debe ingresar el numero identificacion del propietario";
    private static final String SE_DEBE_INGRESAR_TELEFONO = "Se debe ingresar el numero de telefono del propietario";
    private static final String SE_DEBE_INGRESAR_CORREO_ELECTRONICO = "Se debe ingresar el correo electronico del propietario";
    private static final String SE_DEBE_INGRESAR_DIRECCION = "Se debe ingresar la dirección del propietario";

    private static final String EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El nombre debe tener una longitud mayor o igual a %s";
    private static final String EL_NUMERO_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El numero identificacion debe tener una longitud mayor o igual a %s";
    private static final String EL_NUMERO_TELEFONO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El numero telefono debe tener una longitud mayor o igual a %s";

    private static final String DEBE_INGRESAR_CORREO_ELECTRONICO_VALIDO = "Debe ingresar un formato de correo valido";

    private static final int LONGITUD_MINIMA_ARGUMENTOS = 3;
    private static final String EXPRESION_REGULAR_CORREO_ELECTRONICO = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private Long id;
    private String nombre;
    private String numeroIdentificacion;
    private String telefono;
    private String correo;
    private String direccion;

    public Propietario(Long id, String nombre, String numeroIdentificacion, String telefono, String correo, String direccion) {

        ValidadorArgumento.validarObligatorio(nombre, SE_DEBE_INGRESAR_NOMBRE);
        ValidadorArgumento.validarObligatorio(numeroIdentificacion, SE_DEBE_INGRESAR_NUMERO_IDENTIFICACION);
        ValidadorArgumento.validarObligatorio(telefono, SE_DEBE_INGRESAR_TELEFONO);
        ValidadorArgumento.validarObligatorio(correo, SE_DEBE_INGRESAR_CORREO_ELECTRONICO);
        ValidadorArgumento.validarObligatorio(direccion, SE_DEBE_INGRESAR_DIRECCION);

        ValidadorArgumento.validarLongitud(nombre, LONGITUD_MINIMA_ARGUMENTOS, String.format(EL_NOMBRE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ARGUMENTOS));
        ValidadorArgumento.validarLongitud(numeroIdentificacion, LONGITUD_MINIMA_ARGUMENTOS, String.format(EL_NUMERO_IDENTIFICACION_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ARGUMENTOS));
        ValidadorArgumento.validarLongitud(telefono, LONGITUD_MINIMA_ARGUMENTOS, String.format(EL_NUMERO_TELEFONO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MINIMA_ARGUMENTOS));

        ValidadorArgumento.validarRegex(correo, EXPRESION_REGULAR_CORREO_ELECTRONICO, DEBE_INGRESAR_CORREO_ELECTRONICO_VALIDO);

        this.id = id;
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }
}

