package com.ceiba.pago.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPagoImpuestoPredial {
    private Long id;
    private Long idPropietario;
    private Long idInmueble;
    private Long idTarifa;
    private int anio;
    private Long valorPagado;
    private LocalDate fecha;
}
