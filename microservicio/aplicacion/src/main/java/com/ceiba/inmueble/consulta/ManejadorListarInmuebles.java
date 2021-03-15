package com.ceiba.inmueble.consulta;

import com.ceiba.inmueble.modelo.dto.DtoInmueble;
import com.ceiba.inmueble.puerto.dao.DaoInmueble;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarInmuebles {

    private final DaoInmueble daoInmueble;

    public ManejadorListarInmuebles(DaoInmueble daoInmueble) {
        this.daoInmueble = daoInmueble;
    }

    public List<DtoInmueble> ejecutar() {
        return this.daoInmueble.listar();
    }
}
