package com.ceiba.propietario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPropietario {
    private Long id;
    private String nombre;
    private String numeroIdentificacion;
    private String telefono;
    private String correo;
    private String direccion;
}
