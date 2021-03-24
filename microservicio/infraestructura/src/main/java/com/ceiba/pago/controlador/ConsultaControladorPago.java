package com.ceiba.pago.controlador;

import com.ceiba.pago.consulta.ManejadorListarPagos;
import com.ceiba.pago.consulta.ManejadorListarPagosPendientes;
import com.ceiba.pago.modelo.dto.DtoPago;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@Api(tags = {"Controlador consulta pago"})
public class ConsultaControladorPago {
    private final ManejadorListarPagos manejadorListarPagos;
    private final ManejadorListarPagosPendientes manejadorListarPagosPendientes;

    public ConsultaControladorPago(ManejadorListarPagos manejadorListarPagos, ManejadorListarPagosPendientes manejadorListarPagosPendientes) {
        this.manejadorListarPagos = manejadorListarPagos;
        this.manejadorListarPagosPendientes = manejadorListarPagosPendientes;
    }

    @GetMapping
    @ApiOperation("Listar pagos")
    public List<DtoPago> listar() {
        return this.manejadorListarPagos.ejecutar();
    }


    @GetMapping(value = "pendientes/{numeroPredial}")
    @ApiOperation("Listar pagos pendientes")
    public List<DtoPago> listarPagosPendientes(@PathVariable String numeroPredial) {
        return this.manejadorListarPagosPendientes.ejecutar(numeroPredial);
    }
}
