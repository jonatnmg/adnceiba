package com.ceiba.tarifa.consulta;

import com.ceiba.tarifa.modelo.dto.DtoTarifa;
import com.ceiba.tarifa.puerto.dao.DaoTarifa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTarifa {

    private final DaoTarifa daoTarifa;

    public ManejadorListarTarifa(DaoTarifa daoTarifa) {
        this.daoTarifa = daoTarifa;
    }

    public List<DtoTarifa> ejecutar(){
        return this.daoTarifa.listar();
    }
}
