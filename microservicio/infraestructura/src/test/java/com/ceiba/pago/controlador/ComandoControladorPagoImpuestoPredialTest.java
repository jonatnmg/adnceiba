package com.ceiba.pago.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.pago.comando.ComandoPagoImpuestoPredial;
import com.ceiba.pago.testdatabuilder.ComandoPagoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorPago.class)
public class ComandoControladorPagoImpuestoPredialTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoPagoImpuestoPredial comandoPagoImpuestoPredial = new ComandoPagoTestDataBuilder().build();

        // act - assert
        mockMvc.perform(post("/pagos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPagoImpuestoPredial)))
                .andExpect(status().isOk());
    }

}
