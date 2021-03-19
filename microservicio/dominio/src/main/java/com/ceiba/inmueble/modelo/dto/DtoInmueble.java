package com.ceiba.inmueble.modelo.dto;

import com.ceiba.propietario.modelo.dto.DtoPropietario;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoInmueble {

    private Long id;
    private Long numeroPredial;
    private String direccion;
    private int areaTotal;
    private int areaConstruida;
    private long avaluoCatastral;
    private DtoPropietario propietario;
}
