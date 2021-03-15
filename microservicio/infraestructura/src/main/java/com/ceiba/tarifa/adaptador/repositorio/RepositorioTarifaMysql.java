package com.ceiba.tarifa.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTarifaMysql implements RepositorioTarifa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioTarifaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "tarifa", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "tarifa", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "tarifa", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "tarifa", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "tarifa", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @Override
    public Long crear(Tarifa tarifa) {
        return this.customNamedParameterJdbcTemplate.crear(tarifa, sqlCrear);
    }

    @Override
    public void actualizar(Tarifa tarifa) {
        this.customNamedParameterJdbcTemplate.actualizar(tarifa, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long avaluoMinimo, Long avaluoMaximo, int anio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("avaluoMinimo", avaluoMinimo);
        paramSource.addValue("avaluoMaximo", avaluoMaximo);
        paramSource.addValue("anio", anio);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long avaluoMinimo, Long avaluoMaximo, int anio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("avaluoMinimo", avaluoMinimo);
        paramSource.addValue("avaluoMaximo", avaluoMaximo);
        paramSource.addValue("anio", anio);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }
}
