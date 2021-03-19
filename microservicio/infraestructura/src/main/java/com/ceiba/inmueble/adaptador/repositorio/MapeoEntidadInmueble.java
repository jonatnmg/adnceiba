package com.ceiba.inmueble.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.propietario.modelo.entidad.Propietario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadInmueble implements RowMapper<Inmueble>, MapperResult {

    @Override
    public Inmueble mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        Long numeroPredial = rs.getLong("numero_predial");
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

        Propietario propietario = new Propietario(id, nombre, numeroIdentificacion, telefono, correo, direccionPropietario);

        return new Inmueble(id, numeroPredial, direccion, areaTotal, areaConstruida, avaluoCatrastral, propietario);
    }
}
