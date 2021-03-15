package com.ceiba.inmueble.comando;

import com.ceiba.propietario.modelo.dto.DtoPropietario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoInmueble {

    private Long id;
    private Long numeroPredial;
    private int codigoPostal;
    private String direccion;
    private int areaTotal;
    private int areaConstruida;
    private long avaluoCatastral;
    private int propietario;
}
