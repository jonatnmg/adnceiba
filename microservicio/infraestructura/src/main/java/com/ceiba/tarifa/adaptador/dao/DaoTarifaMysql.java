package com.ceiba.tarifa.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTarifaMysql implements DaoTarifa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "tarifa", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "tarifa", value = "obtenerTarifaPorAvaluoYAnio")
    private static String sqlObtenerTarifaPorAvaluoYAnio;

    public DaoTarifaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTarifa> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTarifa());
    }

    @Override
    public double obtenerTarifaPorAvaluoYAnio(Long avaluoCatastral, int anio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("avaluoCatastral", avaluoCatastral);
        paramSource.addValue("anio", anio);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerTarifaPorAvaluoYAnio, paramSource, Double.class);

        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return 0;
        }
    }
}
