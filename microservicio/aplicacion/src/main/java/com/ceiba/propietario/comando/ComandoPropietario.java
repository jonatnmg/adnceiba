package com.ceiba.propietario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPropietario {

    private Long id;
    private String nombre;
    private String numeroIdentificacion;
    private String telefono;
    private String correo;
    private String direccion;
}
