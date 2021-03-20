package com.ceiba.inmueble.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

    @SqlStatement(namespace = "inmueble", value = "existePorId")
    private static String sqlExistePorId;

    public RepositorioInmuebleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource obtenerParametrosInmueble(Inmueble inmueble) {
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", inmueble.getId())
                .addValue("numeroPredial", inmueble.getNumeroPredial())
                .addValue("direccion", inmueble.getDireccion())
                .addValue("areaTotal", inmueble.getAreaTotal())
                .addValue("areaConstruida", inmueble.getAreaConstruida())
                .addValue("avaluoCatastral", inmueble.getAvaluoCatastral())
                .addValue("idPropietario", inmueble.getPropietario().getId());

        return paramSource;
    }

    @Override
    public Long crear(Inmueble inmueble) {
        SqlParameterSource paramSource = this.obtenerParametrosInmueble(inmueble);
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }

    @Override
    public void actualizar(Inmueble inmueble) {
        SqlParameterSource paramSource = this.obtenerParametrosInmueble(inmueble);
        this.customNamedParameterJdbcTemplate.actualizar(paramSource, sqlActualizar);
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

    @Override
    public boolean existePorId(Long idInmueble) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idInmueble);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }
}
