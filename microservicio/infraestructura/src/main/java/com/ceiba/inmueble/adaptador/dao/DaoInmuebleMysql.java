package com.ceiba.inmueble.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inmueble.modelo.dto.DtoInmueble;
import com.ceiba.inmueble.puerto.dao.DaoInmueble;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoInmuebleMysql implements DaoInmueble {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "inmueble", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "inmueble", value = "sqlObtenerValorCatastral")
    private static String sqlObtenerValorCatastral;

    public DaoInmuebleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoInmueble> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoInmueble());
    }

    @Override
    public DtoInmueble buscarPorId(Long id) {
        return null;
    }

    @Override
    public Long obtenerValorCatastral(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerValorCatastral, paramSource, Long.class);
    }
}
