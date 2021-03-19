package com.ceiba.tarifa.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEntidadTarifa implements RowMapper<Tarifa>, MapperResult {


    @Override
    public Tarifa mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long avaluoMinimo = rs.getLong("avaluo_minimo");
        Long avaluoMaximo = rs.getLong("avaluo_maximo");
        double valor = rs.getDouble("valor_tarifa");
        int anio = rs.getInt("anio");

        return new Tarifa(id, avaluoMinimo, avaluoMaximo, valor, anio);
    }
}
