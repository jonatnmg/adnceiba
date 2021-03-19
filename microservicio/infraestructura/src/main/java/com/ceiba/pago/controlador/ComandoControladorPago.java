package com.ceiba.pago.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pago.comando.ComandoPago;
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


    @Autowired
    public ComandoControladorPago(ManejadorPagarImpuestoPredial manejadorPagarImpuestoPredial) {
        this.manejadorPagarImpuestoPredial = manejadorPagarImpuestoPredial;
    }

    @PostMapping
    @ApiOperation("Crear Pago Impuesto Predial")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPago comandoPago) {
        return this.manejadorPagarImpuestoPredial.ejecutar(comandoPago);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Pago Impuesto Predial")
    public void actualizar(@RequestBody ComandoPago comandoPago, @PathVariable Long id) {
        comandoPago.setId(id);
        //man.ejecutar(comandoUsuario);
    }
}
