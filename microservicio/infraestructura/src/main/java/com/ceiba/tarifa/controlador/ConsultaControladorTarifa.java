package com.ceiba.tarifa.controlador;

import com.ceiba.tarifa.consulta.ManejadorListarTarifa;
import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarifas")
@Api(tags = {"Controlador consulta tarifa"})
public class ConsultaControladorTarifa {

    private final ManejadorListarTarifa manejadorListarTarifa;

    public ConsultaControladorTarifa(ManejadorListarTarifa manejadorListarTarifa) {
        this.manejadorListarTarifa = manejadorListarTarifa;
    }

    @GetMapping
    @ApiOperation("Listar Tarifas")
    public List<DtoTarifa> listar() {
        return this.manejadorListarTarifa.ejecutar();
    }
}
