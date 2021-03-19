package com.ceiba.pago.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pago.comando.ComandoPagoImpuestoPredial;
import com.ceiba.pago.comando.manejador.ManejadorActualizarPagoImpuestoPredial;
import com.ceiba.pago.comando.manejador.ManejadorEliminarPagoImpuestoPredial;
import com.ceiba.pago.comando.manejador.ManejadorPagarImpuestoPredial;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
@Api(tags = {"Controlador comando pago"})
public class ComandoControladorPago {

    private final ManejadorPagarImpuestoPredial manejadorPagarImpuestoPredial;
    private final ManejadorEliminarPagoImpuestoPredial manejadorEliminarPagoImpuestoPredial;
    private final ManejadorActualizarPagoImpuestoPredial manejadorActualizarPagoImpuestoPredial;

    @Autowired
    public ComandoControladorPago(ManejadorPagarImpuestoPredial manejadorPagarImpuestoPredial, ManejadorEliminarPagoImpuestoPredial manejadorEliminarPagoImpuestoPredial, ManejadorActualizarPagoImpuestoPredial manejadorActualizarPagoImpuestoPredial) {
        this.manejadorPagarImpuestoPredial = manejadorPagarImpuestoPredial;
        this.manejadorEliminarPagoImpuestoPredial = manejadorEliminarPagoImpuestoPredial;
        this.manejadorActualizarPagoImpuestoPredial = manejadorActualizarPagoImpuestoPredial;
    }

    @PostMapping
    @ApiOperation("Crear Pago Impuesto Predial")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPagoImpuestoPredial comandoPagoImpuestoPredial) {
        return this.manejadorPagarImpuestoPredial.ejecutar(comandoPagoImpuestoPredial);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Pago Impuesto Predial")
    public void actualizar(@RequestBody ComandoPagoImpuestoPredial comandoPagoImpuestoPredial, @PathVariable Long id) {
        comandoPagoImpuestoPredial.setId(id);
        manejadorActualizarPagoImpuestoPredial.ejecutar(comandoPagoImpuestoPredial);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Pago Impuesto Predial")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPagoImpuestoPredial.ejecutar(id);
    }
}
