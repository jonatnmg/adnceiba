package com.ceiba.tarifa.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tarifa.comando.ComandoTarifa;
import com.ceiba.tarifa.comando.manejador.ManejadorActualizarTarifa;
import com.ceiba.tarifa.comando.manejador.ManejadorCrearTarifa;
import com.ceiba.tarifa.comando.manejador.ManejadorEliminarTarifa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarifas")
@Api(tags = {"Controlador comando Tarifa"})
public class ComandoControladorTarifa {

    private final ManejadorCrearTarifa manejadorCrearTarifa;
    private final ManejadorEliminarTarifa manejadorEliminarTarifa;
    private final ManejadorActualizarTarifa manejadorActualizarTarifa;

    @Autowired
    public ComandoControladorTarifa(ManejadorCrearTarifa manejadorCrearTarifa,
                                    ManejadorEliminarTarifa manejadorEliminarTarifa,
                                    ManejadorActualizarTarifa manejadorActualizarTarifa) {
        this.manejadorCrearTarifa = manejadorCrearTarifa;
        this.manejadorEliminarTarifa = manejadorEliminarTarifa;
        this.manejadorActualizarTarifa = manejadorActualizarTarifa;
    }

    @PostMapping
    @ApiOperation("Crear Tarifa")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTarifa comandoTarifa) {
        return this.manejadorCrearTarifa.ejecutar(comandoTarifa);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Tarifa")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarTarifa.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Tarifa")
    public void actualizar(@RequestBody ComandoTarifa comandoTarifa, @PathVariable Long id) {
        comandoTarifa.setId(id);
        this.manejadorActualizarTarifa.ejecutar(comandoTarifa);
    }
}
