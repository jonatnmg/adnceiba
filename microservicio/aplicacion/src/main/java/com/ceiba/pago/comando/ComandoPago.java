package com.ceiba.pago.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPago {
    private Long id;
    private Long idPropietario;
    private Long idInmueble;
    private int anio;
    private Long valorPagado;
    private String fecha;
}
