package com.ceiba.pago.consulta;

import com.ceiba.pago.modelo.dto.DtoPago;
import com.ceiba.pago.puerto.dao.DaoPago;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPagosPendientes {

    private final DaoPago daoPago;

    public ManejadorListarPagosPendientes(DaoPago daoPago) {
        this.daoPago = daoPago;
    }

    public List<DtoPago> ejecutar(String numeroPredial) {
        return this.daoPago.listarPagosPendientesPorNumeroPredial(numeroPredial);
    }
}
