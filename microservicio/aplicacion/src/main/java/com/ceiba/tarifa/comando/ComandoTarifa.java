package com.ceiba.tarifa.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTarifa {

    private Long id;
    private Long avaluoMinimo;
    private Long avaluoMaximo;
    private double tarifa;
    private int anio;
}
