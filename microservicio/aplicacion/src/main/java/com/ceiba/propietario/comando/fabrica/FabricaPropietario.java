package com.ceiba.propietario.comando.fabrica;

import com.ceiba.propietario.comando.ComandoPropietario;
import com.ceiba.propietario.modelo.entidad.Propietario;
import org.springframework.stereotype.Component;

@Component
public class FabricaPropietario {

    public Propietario crear(ComandoPropietario comandoUsuario) {
        return new Propietario(
                comandoUsuario.getId(),
                comandoUsuario.getNombre(),
                comandoUsuario.getNumeroIdentificacion(),
                comandoUsuario.getTelefono(),
                comandoUsuario.getCorreo(),
                comandoUsuario.getDireccion()
        );
    }
}
