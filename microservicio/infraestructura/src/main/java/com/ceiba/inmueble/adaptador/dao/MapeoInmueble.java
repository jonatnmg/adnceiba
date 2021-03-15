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
        int codigoPostal = rs.getInt("codigo_postal");
        String direccion = rs.getString("direccion");
        int areaTotal = rs.getInt("area_total");
        int areaConstruida = rs.getInt("area_construida");
        Long avaluoCatrastral = rs.getLong("avaluo_catastral");

        Long idPropietario = rs.getLong("id_propietario");
        String nombre = rs.getString("nombre");
        String numeroIdentificacion = rs.getString("numero_identificacion");
        String telefono = rs.getString("telefono");
        String correo = rs.getString("correo");
        String direccionPropietario = rs.getString("direccion_propietario");

        DtoPropietario propietario = new DtoPropietario(idPropietario, nombre, numeroIdentificacion, telefono, correo, direccionPropietario);

        return new DtoInmueble(id, numeroPredial, codigoPostal, direccion, areaTotal, areaConstruida, avaluoCatrastral, propietario);
    }
}
