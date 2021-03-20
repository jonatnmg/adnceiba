package com.ceiba.inmueble.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.inmueble.comando.ComandoInmueble;
import com.ceiba.inmueble.testdatabuilder.ComandoInmuebleTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorInmueble.class)
public class ComandoControladorInmuebleTest {

    private static final Long NUMERO_PREDIAL = 14796334L;
    private static final String DIRECCION = "Av. Ferrocarril 52 No. 27 - 50";

    private static final Long NUMERO_PREDIAL_ACTUALIZAR = 14563687L;
    private static final String DIRECCION_ACTUALIZAR = "Calle 50 No. 19-5 Br. Los Andres";
    private static final int AREA_TOTAL_ACTUALIZAR = 132;
    private static final int AREA_CONSTRUIDA_ACTUALIZAR = 125;
    private static final Long AVALUO_CATASTRAL_ACTUALIZAR = 137325001l;
    private static final Long ID_PROPIETARIO_ACTUALIZAR = 1L;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoInmueble comandoInmueble = new ComandoInmuebleTestDataBuilder()
                .conNumeroPredial(NUMERO_PREDIAL)
                .conDireccion(DIRECCION)
                .build();

        // act - assert
        mockMvc.perform(post("/inmuebles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoInmueble)))
                .andExpect(status().isOk());
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 1L;

        ComandoInmueble comandoInmueble = new ComandoInmuebleTestDataBuilder()
                .conAvaluoCatastral(AVALUO_CATASTRAL_ACTUALIZAR)
                .conDireccion(DIRECCION_ACTUALIZAR)
                .conNumeroPredial(NUMERO_PREDIAL_ACTUALIZAR)
                .conAreaConstruida(AREA_CONSTRUIDA_ACTUALIZAR)
                .conAreaTotal(AREA_TOTAL_ACTUALIZAR)
                .conIdPropietario(ID_PROPIETARIO_ACTUALIZAR)
                .build();

        // act - assert
        mockMvc.perform(put("/inmuebles/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoInmueble)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        long id = 2L;

        // act - assert
        mockMvc.perform(delete("/inmuebles/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
