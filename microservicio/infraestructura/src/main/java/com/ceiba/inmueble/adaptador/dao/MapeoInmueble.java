package com.ceiba.inmueble.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.inmueble.modelo.dto.DtoInmueble;
import com.ceiba.propietario.modelo.dto.DtoPropietario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoInmueble implements RowMapper<DtoInmueble>, MapperResult {

    @Override
    public DtoInmueble mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        Long numeroPredial = rs.getLong("numero_predial");
        String direccion = rs.getString("direccion");
        int areaTotal = rs.getInt("area_total");
        int areaConstruida = rs.getInt("area_construida");
        Long avaluoCatrastral = rs.getLong("avaluo_catastral");

        Long idPropietarioInmueble = rs.getLong("id_propietario");
        String nombrePropietarioInmueble = rs.getString("nombre");
        String numeroIdentificacionPropietario = rs.getString("numero_identificacion");
        String telefonoPropietarioInmueble = rs.getString("telefono");
        String correoPropietarioInmueble = rs.getString("correo");
        String direccionPropietarioInmueble = rs.getString("direccion_propietario");

        DtoPropietario propietario = new DtoPropietario(idPropietarioInmueble, nombrePropietarioInmueble, numeroIdentificacionPropietario, telefonoPropietarioInmueble, correoPropietarioInmueble, direccionPropietarioInmueble);

        return new DtoInmueble(id, numeroPredial, direccion, areaTotal, areaConstruida, avaluoCatrastral, propietario);
    }
}
