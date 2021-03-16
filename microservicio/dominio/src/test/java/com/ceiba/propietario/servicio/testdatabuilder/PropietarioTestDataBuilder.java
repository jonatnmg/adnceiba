package com.ceiba.propietario.servicio.testdatabuilder;

import com.ceiba.propietario.modelo.entidad.Propietario;

public class PropietarioTestDataBuilder {

    private static final String NOMBRE_PROPIETARIO = "Propietario X";
    private static final String NUMERO_IDENTIFICACION = "Propietario X";
    private static final String TELEFONO = "62130488";
    private static final String CORREO = "email@default.com";
    private static final String DIRECCION = "Calle 19a No. 18 - 69 Br. Coliflor";

    private Long id;
    private String nombre;
    private String numeroIdentificacion;
    private String telefono;
    private String correo;
    private String direccion;

    public PropietarioTestDataBuilder() {
        this.nombre = PropietarioTestDataBuilder.NOMBRE_PROPIETARIO;
        this.numeroIdentificacion = PropietarioTestDataBuilder.NUMERO_IDENTIFICACION;
        this.telefono = PropietarioTestDataBuilder.TELEFONO;
        this.correo = PropietarioTestDataBuilder.CORREO;
        this.direccion = PropietarioTestDataBuilder.DIRECCION;
    }

    public PropietarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public PropietarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PropietarioTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public PropietarioTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public PropietarioTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public PropietarioTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Propietario build() {
        return new Propietario(this.id,
                this.nombre,
                this.numeroIdentificacion,
                this.telefono,
                this.correo,
                this.direccion);
    }
}
