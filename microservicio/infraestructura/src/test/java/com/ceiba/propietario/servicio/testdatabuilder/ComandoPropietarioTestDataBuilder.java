package com.ceiba.propietario.servicio.testdatabuilder;

import com.ceiba.propietario.comando.ComandoPropietario;

import java.util.UUID;

public class ComandoPropietarioTestDataBuilder {

    private static final String NUMERO_IDENTIFICACION = "123456678";
    private static final String TELEFONO = "62130488";
    private static final String CORREO = "email@default.com";
    private static final String DIRECCION = "Calle 19a No. 18 - 69 Br. Coliflor";

    private Long id;
    private String nombre;
    private String numeroIdentificacion;
    private String telefono;
    private String correo;
    private String direccion;

    public ComandoPropietarioTestDataBuilder() {
        this.nombre = UUID.randomUUID().toString();
        this.numeroIdentificacion = NUMERO_IDENTIFICACION;
        this.telefono = TELEFONO;
        this.correo = CORREO;
        this.direccion = DIRECCION;
    }

    public ComandoPropietarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoPropietarioTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ComandoPropietario build() {
        return new ComandoPropietario(this.id, this.nombre, this.numeroIdentificacion, this.telefono, this.correo, this.direccion);
    }
}
