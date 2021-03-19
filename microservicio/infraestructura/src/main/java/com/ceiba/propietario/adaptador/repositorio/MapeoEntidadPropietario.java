package com.ceiba.propietario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.propietario.modelo.entidad.Propietario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadPropietario implements RowMapper<Propietario>, MapperResult {

    @Override
    public Propietario mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String numeroIdentificacion = rs.getString("numero_identificacion");
        String telefono = rs.getString("telefono");
        String correo = rs.getString("correo");
        String direccion = rs.getString("direccion");

        return new Propietario(id, nombre, numeroIdentificacion, telefono, correo, direccion);
    }
}
