package com.ceiba.propietario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.propietario.modelo.dto.DtoPropietario;
import com.ceiba.propietario.puerto.dao.DaoPropietario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPropietarioMysql implements DaoPropietario {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="propietario", value="listar")
    private static String sqlListar;

    public DaoPropietarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPropietario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPropietario());
    }
}
