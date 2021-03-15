package com.ceiba.inmueble.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.inmueble.comando.ComandoInmueble;
import com.ceiba.inmueble.comando.manejador.ManejadorActualizarInmueble;
import com.ceiba.inmueble.comando.manejador.ManejadorCrearInmueble;
import com.ceiba.inmueble.comando.manejador.ManejadorEliminarInmueble;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inmuebles")
@Api(tags = {"Controlador comando inmueble"})
public class ComandoControladorInmueble {

    private final ManejadorCrearInmueble manejadorCrearInmueble;
    private final ManejadorActualizarInmueble manejadorActualizarInmueble;
    private final ManejadorEliminarInmueble manejadorEliminarInmueble;

    @Autowired
    public ComandoControladorInmueble(ManejadorCrearInmueble manejadorCrearInmueble, ManejadorActualizarInmueble manejadorActualizarInmueble, ManejadorEliminarInmueble manejadorEliminarInmueble) {
        this.manejadorCrearInmueble = manejadorCrearInmueble;
        this.manejadorActualizarInmueble = manejadorActualizarInmueble;
        this.manejadorEliminarInmueble = manejadorEliminarInmueble;
    }

    @PostMapping
    @ApiOperation("Crear inmueble")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoInmueble comandoInmueble) {
        return this.manejadorCrearInmueble.ejecutar(comandoInmueble);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar inmueble")
    public void actualizar(@RequestBody ComandoInmueble comandoInmueble, @PathVariable Long id) {
        comandoInmueble.setId(id);
        this.manejadorActualizarInmueble.ejecutar(comandoInmueble);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar inmueble")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarInmueble.ejecutar(id);
    }
}
