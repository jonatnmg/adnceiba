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

        Long id_propietario = rs.getLong("id_propietario");
        String nombre_propietario = rs.getString("nombre");
        String numero_identificacion = rs.getString("numero_identificacion");
        String telefono_propietario = rs.getString("telefono");
        String correo_propietario = rs.getString("correo");
        String direccion_propietario = rs.getString("direccion_propietario");

        DtoPropietario propietario = new DtoPropietario(id_propietario, nombre_propietario, numero_identificacion, telefono_propietario, correo_propietario, direccion_propietario);

        return new DtoInmueble(id, numeroPredial, direccion, areaTotal, areaConstruida, avaluoCatrastral, propietario);
    }
}
