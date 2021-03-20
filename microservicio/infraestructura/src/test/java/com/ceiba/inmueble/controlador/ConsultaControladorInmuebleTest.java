package com.ceiba.inmueble.controlador;

import com.ceiba.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorInmueble.class)
public class ConsultaControladorInmuebleTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception {
        // arrange

        // act - assert
        mockMvc.perform(get("/inmuebles")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
