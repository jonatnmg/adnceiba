package com.ceiba.pago.consulta;

import com.ceiba.inmueble.modelo.dto.DtoInmueble;
import com.ceiba.inmueble.puerto.dao.DaoInmueble;
import com.ceiba.pago.modelo.dto.DtoPago;
import com.ceiba.pago.puerto.dao.DaoPago;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPagos {
    private final DaoPago daoPago;

    public ManejadorListarPagos(DaoPago daoPago) {
        this.daoPago = daoPago;
    }

    public List<DtoPago> ejecutar() {
        return this.daoPago.listar();
    }
}
