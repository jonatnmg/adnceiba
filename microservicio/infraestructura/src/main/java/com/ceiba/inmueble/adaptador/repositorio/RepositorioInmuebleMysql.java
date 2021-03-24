package com.ceiba.inmueble.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.inmueble.modelo.entidad.Inmueble;
import com.ceiba.inmueble.puerto.repositorio.RepositorioInmueble;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class RepositorioInmuebleMysql implements RepositorioInmueble {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private static final Logger LOGGER = Logger.getLogger(RepositorioInmuebleMysql.class.getName());
    private static final String REGISTRO_NO_ENCONTRADO = "Registro no encontrado.";

    private static final String TEXTO_NUMERO_PREDIAL = "numeroPredial";
    private static final String TEXTO_DIRECCION = "direccion";
    private static final String TEXTO_ID_PROPIETARIO = "idPropietario";

    @SqlStatement(namespace = "inmueble", value = "crear")
    private static String sqlCrearInmueble;

    @SqlStatement(namespace = "inmueble", value = "actualizar")
    private static String sqlActualizarInmueble;

    @SqlStatement(namespace = "inmueble", value = "eliminar")
    private static String sqlEliminarInmueble;

    @SqlStatement(namespace = "inmueble", value = "existe")
    private static String sqlExisteInmueble;

    @SqlStatement(namespace = "inmueble", value = "existeExcluyendoId")
    private static String sqlExisteInmuebleExcluyendoId;

    @SqlStatement(namespace = "inmueble", value = "buscarInmueblePorId")
    private static String sqlBuscarInmueblePorId;

    @SqlStatement(namespace = "inmueble", value = "existePorId")
    private static String sqlExisteInmueblePorId;

    @SqlStatement(namespace = "inmueble", value = "existePropietarioEnInmueble")
    private static String sqlExisteInmueblePropietarioEnInmueble;

    public RepositorioInmuebleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource obtenerParametrosInmueble(Inmueble inmueble) {
        return new MapSqlParameterSource()
                .addValue("id", inmueble.getId())
                .addValue(TEXTO_NUMERO_PREDIAL, inmueble.getNumeroPredial())
                .addValue(TEXTO_DIRECCION, inmueble.getDireccion())
                .addValue("areaTotal", inmueble.getAreaTotal())
                .addValue("areaConstruida", inmueble.getAreaConstruida())
                .addValue("avaluoCatastral", inmueble.getAvaluoCatastral())
                .addValue(TEXTO_ID_PROPIETARIO, inmueble.getPropietario().getId());
    }

    @Override
    public Long crear(Inmueble inmueble) {
        SqlParameterSource paramSource = this.obtenerParametrosInmueble(inmueble);
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrearInmueble);
    }

    @Override
    public void actualizar(Inmueble inmueble) {
        SqlParameterSource paramSource = this.obtenerParametrosInmueble(inmueble);
        this.customNamedParameterJdbcTemplate.actualizar(paramSource, sqlActualizarInmueble);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarInmueble, paramSource);
    }

    @Override
    public boolean existe(Long numeroPredial, String direccion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(TEXTO_NUMERO_PREDIAL, numeroPredial);
        paramSource.addValue(TEXTO_DIRECCION, direccion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteInmueble, paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long numeroPredial, String direccion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue(TEXTO_NUMERO_PREDIAL, numeroPredial);
        paramSource.addValue(TEXTO_DIRECCION, direccion);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteInmuebleExcluyendoId, paramSource, Boolean.class);
    }

    @Override
    public Inmueble buscarInmueblePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        try {
            return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarInmueblePorId, paramSource, new MapeoEntidadInmueble());
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            LOGGER.log(Level.FINE, REGISTRO_NO_ENCONTRADO, emptyResultDataAccessException);
            return null;
        }
    }

    @Override
    public boolean existePorId(Long idInmueble) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idInmueble);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteInmueblePorId, paramSource, Boolean.class);
    }

    @Override
    public boolean existePropietarioEnInmueble(Long idPropietario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(TEXTO_ID_PROPIETARIO, idPropietario);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteInmueblePropietarioEnInmueble, paramSource, Boolean.class);
    }
}
