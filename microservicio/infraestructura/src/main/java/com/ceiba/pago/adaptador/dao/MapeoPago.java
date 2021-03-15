package com.ceiba.pago.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.inmueble.modelo.dto.DtoInmueble;
import com.ceiba.pago.modelo.dto.DtoPago;
import com.ceiba.propietario.modelo.dto.DtoPropietario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPago implements RowMapper<DtoPago>, MapperResult {

    @Override
    public DtoPago mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long idPropietario = resultSet.getLong("id_propietario");
        Long idInmueble = resultSet.getLong("id_inmueble");
        int anio = resultSet.getInt("anio");
        Long valorPagado = resultSet.getLong("valor_pagado");
        String fechaPago = resultSet.getString("fecha_pago");

        Long numeroPredial = resultSet.getLong("numero_predial");
        int codigoPostal = resultSet.getInt("codigo_postal");
        String direccion = resultSet.getString("direccion");
        int areaTotal = resultSet.getInt("area_total");
        int areaConstruida = resultSet.getInt("area_construida");
        Long avaluoCatrastral = resultSet.getLong("avaluo_catastral");

        String nombre = resultSet.getString("nombre");
        String numeroIdentificacion = resultSet.getString("numero_identificacion");
        String telefono = resultSet.getString("telefono");
        String correo = resultSet.getString("correo");
        String direccionPropietario = resultSet.getString("direccion_propietario");

        DtoPropietario propietario = new DtoPropietario(idPropietario, nombre, numeroIdentificacion, telefono, correo, direccionPropietario);
        DtoInmueble inmueble = new DtoInmueble(idInmueble, numeroPredial, codigoPostal, direccion, areaTotal, areaConstruida, avaluoCatrastral, propietario);

        return new DtoPago(id, propietario, inmueble, anio, valorPagado, fechaPago);
    }
}
