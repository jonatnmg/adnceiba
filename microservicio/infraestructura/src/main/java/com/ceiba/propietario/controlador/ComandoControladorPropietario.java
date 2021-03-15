package com.ceiba.propietario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.propietario.comando.ComandoPropietario;
import com.ceiba.propietario.comando.manejador.ManejadorActualizarPropietario;
import com.ceiba.propietario.comando.manejador.ManejadorCrearPropietario;
import com.ceiba.propietario.comando.manejador.ManejadorEliminarPropietario;
import com.ceiba.usuario.comando.ComandoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propietarios")
@Api(tags = {"Controlador comando propietario"})
public class ComandoControladorPropietario {

    private final ManejadorCrearPropietario manejadorCrearPropietario;
    private final ManejadorEliminarPropietario manejadorEliminarPropietario;
    private final ManejadorActualizarPropietario manejadorActualizarPropietario;

    @Autowired
    public ComandoControladorPropietario(ManejadorCrearPropietario manejadorCrearPropietario,
                                         ManejadorEliminarPropietario manejadorEliminarPropietario,
                                         ManejadorActualizarPropietario manejadorActualizarPropietario) {
        this.manejadorCrearPropietario = manejadorCrearPropietario;
        this.manejadorEliminarPropietario = manejadorEliminarPropietario;
        this.manejadorActualizarPropietario = manejadorActualizarPropietario;
    }

    @PostMapping
    @ApiOperation("Crear Propietario")
    public ComandoRespuesta crear(@RequestBody ComandoPropietario comandoPropietario) {
        return this.manejadorCrearPropietario.ejecutar(comandoPropietario);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Propietario")
    public void eliminar(@PathVariable Long id) {
        this.manejadorEliminarPropietario.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Propietario")
    public void actualizar(@RequestBody ComandoPropietario comandoPropietario, @PathVariable Long id) {
        comandoPropietario.setId(id);
        this.manejadorActualizarPropietario.ejecutar(comandoPropietario);
    }
}
