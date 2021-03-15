package com.ceiba.tarifa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTarifa implements RowMapper<DtoTarifa>, MapperResult {


    @Override
    public DtoTarifa mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long avaluoMinimo = rs.getLong("avaluo_minimo");
        Long avaluoMaximo = rs.getLong("avaluo_maximo");
        double tarifa = rs.getDouble("tarifa");
        int anio = rs.getInt("anio");

        return new DtoTarifa(id, avaluoMinimo, avaluoMaximo, tarifa, anio);
    }
}
