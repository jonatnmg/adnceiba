package com.ceiba.tarifa.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.tarifa.comando.ComandoTarifa;
import com.ceiba.tarifa.testdatabuilder.ComandoTarifaTestDataBuilder;
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
@WebMvcTest(ComandoControladorTarifa.class)
public class ComandoControladorTarifaTest {

    private static final Long AVALUO_MINIMO_CREAR = 168092001L;
    private static final Long AVALUO_MAXIMO_CREAR = 188092000L;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoTarifa comandoTarifa = new ComandoTarifaTestDataBuilder()
                .conAvaluoMinimo(AVALUO_MINIMO_CREAR)
                .conAvaluoMaximo(AVALUO_MAXIMO_CREAR)
                .build();

        // act - assert
        mocMvc.perform(post("/tarifas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoTarifa)))
                .andExpect(status().isOk());
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 2L;
        ComandoTarifa comandoTarifa = new ComandoTarifaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/tarifas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoTarifa)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/tarifas/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
