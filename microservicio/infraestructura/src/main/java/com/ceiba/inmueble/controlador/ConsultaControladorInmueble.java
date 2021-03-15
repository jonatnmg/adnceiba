package com.ceiba.inmueble.controlador;

import com.ceiba.inmueble.consulta.ManejadorListarInmuebles;
import com.ceiba.inmueble.modelo.dto.DtoInmueble;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inmuebles")
@Api(tags = {"Controlador consulta inmuebles"})
public class ConsultaControladorInmueble {

    private final ManejadorListarInmuebles manejadorListarInmuebles;

    public ConsultaControladorInmueble(ManejadorListarInmuebles manejadorListarInmuebles) {
        this.manejadorListarInmuebles = manejadorListarInmuebles;
    }

    @GetMapping
    @ApiOperation("Listar Inmuebles")
    public List<DtoInmueble> listar() {
        return this.manejadorListarInmuebles.ejecutar();
    }

}
