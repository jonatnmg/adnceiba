package com.ceiba.pago.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.inmueble.modelo.dto.DtoInmueble;
import com.ceiba.pago.modelo.dto.DtoPago;
import com.ceiba.propietario.modelo.dto.DtoPropietario;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
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

        Long id_tarifa = resultSet.getLong("id_tarifa");
        Long avaluoMinimo = resultSet.getLong("avaluo_minimo");
        Long avaluoMaximo = resultSet.getLong("avaluo_maximo");
        double valor_tarifa = resultSet.getDouble("valor_tarifa");
        int anio_tarifa = resultSet.getInt("anio_tarifa");

        DtoPropietario dtoPropietario = new DtoPropietario(idPropietario, nombre, numeroIdentificacion, telefono, correo, direccionPropietario);
        DtoInmueble dtoInmueble = new DtoInmueble(idInmueble, numeroPredial, direccion, areaTotal, areaConstruida, avaluoCatrastral, dtoPropietario);
        DtoTarifa dtoTarifa = new DtoTarifa(id_tarifa, avaluoMinimo, avaluoMaximo, valor_tarifa, anio_tarifa);

        return new DtoPago(id, dtoPropietario, dtoInmueble, dtoTarifa, anio, valorPagado, fechaPago);
    }
}
