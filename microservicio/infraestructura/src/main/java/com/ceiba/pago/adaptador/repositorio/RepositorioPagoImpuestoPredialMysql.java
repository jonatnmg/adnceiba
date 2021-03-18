package com.ceiba.pago.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pago.modelo.entidad.PagoImpuestoPredial;
import com.ceiba.pago.puerto.repositorio.RepositorioPagoImpuestoPredial;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPagoImpuestoPredialMysql implements RepositorioPagoImpuestoPredial {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pago", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "pago", value = "existe")
    private static String sqlExiste;

    public RepositorioPagoImpuestoPredialMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(PagoImpuestoPredial pagoImpuestoPredial) {
        return this.customNamedParameterJdbcTemplate.crear(pagoImpuestoPredial, sqlCrear);
    }

    @Override
    public void actualizar(PagoImpuestoPredial pagoImpuestoPredial) {
        // TODO actualizar
    }

    @Override
    public void eliminar(Long id) {
        // TODO eliminar
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
        // TODO existe exclyendo id
        return false;
    }
}
