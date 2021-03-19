package com.ceiba.inmueble.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioInmuebleMysql implements RepositorioInmueble {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "inmueble", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "inmueble", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "inmueble", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "inmueble", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "inmueble", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "inmueble", value = "buscarInmueblePorId")
    private static String sqlBuscarInmueblePorId;

    public RepositorioInmuebleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Inmueble inmueble) {
        return this.customNamedParameterJdbcTemplate.crear(inmueble, sqlCrear);
    }

    @Override
    public void actualizar(Inmueble inmueble) {
        this.customNamedParameterJdbcTemplate.actualizar(inmueble, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long numeroPredial, String direccion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numeroPredial", numeroPredial);
        paramSource.addValue("direccion", direccion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long numeroPredial, String direccion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("numeroPredial", numeroPredial);
        paramSource.addValue("direccion", direccion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);
    }

    @Override
    public Inmueble buscarInmueblePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarInmueblePorId, paramSource, new MapeoEntidadInmueble());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            return null;
        }
    }
}
