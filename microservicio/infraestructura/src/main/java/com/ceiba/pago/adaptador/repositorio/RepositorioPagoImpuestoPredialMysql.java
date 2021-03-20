package com.ceiba.pago.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPagoImpuestoPredialMysql implements RepositorioPagoImpuestoPredial {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pago", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "pago", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "pago", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "pago", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "pago", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    @SqlStatement(namespace = "pago", value = "existePorId")
    private static String sqlExistePorId;

    public RepositorioPagoImpuestoPredialMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private SqlParameterSource obtenerParametrosPagarImpuestoPredial(PagoImpuestoPredial pagoImpuestoPredial) {
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", pagoImpuestoPredial.getId())
                .addValue("idPropietario", pagoImpuestoPredial.getPropietario().getId())
                .addValue("idInmueble", pagoImpuestoPredial.getInmueble().getId())
                .addValue("fechaPago", pagoImpuestoPredial.getFechaPago())
                .addValue("anio", pagoImpuestoPredial.getAnio())
                .addValue("idTarifa", pagoImpuestoPredial.getTarifa().getId())
                .addValue("valorPagado", pagoImpuestoPredial.getValorPagado());

        return paramSource;
    }

    @Override
    public Long crear(PagoImpuestoPredial pagoImpuestoPredial) {
        SqlParameterSource paramSource = this.obtenerParametrosPagarImpuestoPredial(pagoImpuestoPredial);
        return this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);

    }

    @Override
    public void actualizar(PagoImpuestoPredial pagoImpuestoPredial) {
        SqlParameterSource paramSource = this.obtenerParametrosPagarImpuestoPredial(pagoImpuestoPredial);
        this.customNamedParameterJdbcTemplate.actualizar(paramSource, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long idPropietario, Long idInmueble, int anio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPropietario", idPropietario);
        paramSource.addValue("idInmueble", idInmueble);
        paramSource.addValue("anio", anio);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id, Long idPropietario, Long idInmueble, int anio) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("idPropietario", idPropietario);
        paramSource.addValue("idInmueble", idInmueble);
        paramSource.addValue("anio", anio);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, paramSource, Boolean.class);

    }

    @Override
    public boolean existePorId(Long idPagoImpuestoPredial) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPagoImpuestoPredial);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }
}
