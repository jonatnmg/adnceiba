package com.ceiba.pago.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.comando.manejador.ManejadorCrearPago;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagos")
@Api(tags = {"Controlador comando pago"})
public class ComandoControladorPago {

    private final ManejadorCrearPago manejadorCrearPago;

    @Autowired
    public ComandoControladorPago(ManejadorCrearPago manejadorCrearPago) {
        this.manejadorCrearPago = manejadorCrearPago;
    }

    @PostMapping
    @ApiOperation("Crear PagoImpuestoPredial")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPago comandoPago) {
        return this.manejadorCrearPago.ejecutar(comandoPago);
    }
}
