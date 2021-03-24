package com.ceiba.pago.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pago.modelo.dto.DtoPago;
import com.ceiba.pago.puerto.dao.DaoPago;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPagoMysql implements DaoPago {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "pago", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "pago", value = "listarPagosPendientes")
    private static String sqlListarPagosPendientes;

    public DaoPagoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPago> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPago());
    }

    @Override
    public List<DtoPago> listarPagosPendientesPorNumeroPredial(String numeroPredial) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numeroPredial", numeroPredial);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPagosPendientes, paramSource, new MapeoPago());
    }

}
