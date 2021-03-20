package com.ceiba.propietario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.propietario.modelo.entidad.Propietario;
import com.ceiba.propietario.puerto.repositorio.RepositorioPropietario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPropietarioMysql implements RepositorioPropietario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "propietario", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "propietario", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "propietario", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "propietario", value = "existePorNombre")
    private static String sqlExistePorNombre;

    @SqlStatement(namespace = "propietario", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "propietario", value = "existePorNumeroIdentificacion")
    private static String sqlExistePorNumeroIdentificacion;

    @SqlStatement(namespace = "propietario", value = "buscarPropietarioPorId")
    private static String sqlBuscarPropietarioPorId;

    @SqlStatement(namespace = "propietario", value = "existePorId")
    private static String sqlExistePorId;

    public RepositorioPropietarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Propietario propietario) {
        return this.customNamedParameterJdbcTemplate.crear(propietario, sqlCrear);
    }

    @Override
    public void actualizar(Propietario propietario) {
        this.customNamedParameterJdbcTemplate.actualizar(propietario, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorNombre(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorNombre, paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String numeroIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("numeroIdentificacion", numeroIdentificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }

    @Override
    public boolean existePorNumeroIdentificacion(String numeroIdentificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numeroIdentificacion", numeroIdentificacion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorNumeroIdentificacion, paramSource, Boolean.class);
    }

    @Override
    public Propietario buscarPropietarioPorId(Long idPropietario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPropietario);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPropietarioPorId, paramSource, new MapeoEntidadPropietario());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return null;
        }

    }

    @Override
    public boolean existePorId(Long idPropietario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPropietario);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }
}
