package com.ceiba.inmueble.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadInmueble implements RowMapper<Inmueble>, MapperResult {

    @Override
    public Inmueble mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        Long numeroPredial = rs.getLong("numero_predial");
        int codigoPostal = rs.getInt("codigo_postal");
        String direccion = rs.getString("direccion");
        int areaTotal = rs.getInt("area_total");
        int areaConstruida = rs.getInt("area_construida");
        Long avaluoCatrastral = rs.getLong("avaluo_catastral");

        Long idPropietario = rs.getLong("id_propietario");

        return new Inmueble(id, numeroPredial, codigoPostal, direccion, areaTotal, areaConstruida, avaluoCatrastral, idPropietario);
    }
}
