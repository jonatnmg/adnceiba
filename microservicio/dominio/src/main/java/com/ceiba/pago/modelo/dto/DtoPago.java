package com.ceiba.pago.modelo.dto;

import com.ceiba.inmueble.modelo.dto.DtoInmueble;
import com.ceiba.propietario.modelo.dto.DtoPropietario;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPago {

    private Long id;
    private DtoPropietario propietario;
    private DtoInmueble inmueble;
    private DtoTarifa tarifa;
    private int anio;
    private Long valorPagado;
    private String fecha;
}
