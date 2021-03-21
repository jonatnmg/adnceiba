package com.ceiba.tarifa.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tarifa.modelo.entidad.Tarifa;
import com.ceiba.tarifa.puerto.repositorio.RepositorioTarifa;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTarifaMysql implements RepositorioTarifa {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioTarifaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "tarifa", value = "crear")
    private static String sqlCrearTarifa;

    @SqlStatement(namespace = "tarifa", value = "actualizar")
    private static String sqlActualizarTarifa;

    @SqlStatement(namespace = "tarifa", value = "eliminar")
    private static String sqlEliminarTarifa;

    @SqlStatement(namespace = "tarifa", value = "existe")
    private static String sqlExisteTarifa;

    @SqlStatement(namespace = "tarifa", value = "existeExcluyendoId")
    private static String sqlExisteTarifaExcluyendoId;

    @SqlStatement(namespace = "tarifa", value = "buscarTarifaPorId")
    private static String sqlBuscarTarifaPorId;

    @SqlStatement(namespace = "tarifa", value = "existePorId")
    private static String sqlExisteTarifaPorId;

    @Override
    public Long crear(Tarifa tarifa) {
        return this.customNamedParameterJdbcTemplate.crear(tarifa, sqlCrearTarifa);
    }

    @Override
    public void actualizar(Tarifa tarifa) {
        this.customNamedParameterJdbcTemplate.actualizar(tarifa, sqlActualizarTarifa);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarTarifa, paramSource);
    }

    @Override
    public boolean existe(Long avaluoMinimo, Long avaluoMaximo, int anio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("avaluoMinimo", avaluoMinimo);
        paramSource.addValue("avaluoMaximo", avaluoMaximo);
        paramSource.addValue("anio", anio);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTarifa, paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long avaluoMinimo, Long avaluoMaximo, int anio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("avaluoMinimo", avaluoMinimo);
        paramSource.addValue("avaluoMaximo", avaluoMaximo);
        paramSource.addValue("anio", anio);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTarifaExcluyendoId, paramSource, Boolean.class);
    }

    @Override
    public Tarifa buscarTarifaPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarTarifaPorId, paramSource, new MapeoEntidadTarifa());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return null;
        }
    }

    @Override
    public boolean existePorId(Long idTarifa) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idTarifa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteTarifaPorId, paramSource, Boolean.class);
    }
}
