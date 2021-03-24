package com.ceiba.propietario.controlador;

import com.ceiba.propietario.consulta.ManejadorListarPropietarios;
import com.ceiba.propietario.consulta.ManejadorListarPropietariosPorNumeroIdentificacion;
import com.ceiba.propietario.modelo.dto.DtoPropietario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/propietarios")
@Api(tags = {"Controlador consulta propietario"})
public class ConsultaControladorPropietario {

    private final ManejadorListarPropietarios manejadorListarPropietarios;
    private final ManejadorListarPropietariosPorNumeroIdentificacion manejadorListarPropietariosPorNumeroIdentificacion;

    public ConsultaControladorPropietario(ManejadorListarPropietarios manejadorListarPropietarios, ManejadorListarPropietariosPorNumeroIdentificacion manejadorListarPropietariosPorNumeroIdentificacion) {
        this.manejadorListarPropietarios = manejadorListarPropietarios;
        this.manejadorListarPropietariosPorNumeroIdentificacion = manejadorListarPropietariosPorNumeroIdentificacion;
    }

    @GetMapping
    @ApiOperation("Listar Propietarios")
    public List<DtoPropietario> listar() {
        return this.manejadorListarPropietarios.ejecutar();
    }


    @GetMapping(value = "/{numeroIdentificacion}")
    @ApiOperation("Listar un propietario")
    public List<DtoPropietario> listarPorNumeroIdentificacion(@PathVariable String numeroIdentificacion) {

        return this.manejadorListarPropietariosPorNumeroIdentificacion.ejecutar(numeroIdentificacion);
    }
}
