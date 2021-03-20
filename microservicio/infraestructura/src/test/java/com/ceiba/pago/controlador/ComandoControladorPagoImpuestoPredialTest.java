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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorPago.class)
public class ComandoControladorPagoImpuestoPredialTest {

    private static final Long ID_INMUEBLE = 3L;
    private static final int ANIO_PAGO = 2020;
    private static final Long VALOR_PAGADO_CREAR = 991237L;

    private static final Long ID_PROPIETARIO_ACTUALIZAR = 1L;
    private static final Long ID_INMUEBLE_ACTUALIZAR = 1L;
    private static final Long ID_PAGO_IMPUESTO_PREDIAL = 1L;
    private static final long ID_TARIFA_ACTUALIZAR = 1L;
    private static final long VALOR_PAGAR_ACTUALIZAR = 782753L;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoPagoImpuestoPredial comandoPagoImpuestoPredial = new ComandoPagoTestDataBuilder()
                .conIdInmueble(ID_INMUEBLE)
                .conAnio(ANIO_PAGO)
                .conValorPagado(VALOR_PAGADO_CREAR)
                .build();

        // act - assert
        mockMvc.perform(post("/pagos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPagoImpuestoPredial)))
                .andExpect(status().isOk());
    }

    @Test
    public void actualizar() throws Exception {
        // arrange

        ComandoPagoImpuestoPredial comandoPagoImpuestoPredial = new ComandoPagoTestDataBuilder()
                .conIdInmueble(ID_INMUEBLE_ACTUALIZAR)
                .conIdPropietario(ID_PROPIETARIO_ACTUALIZAR)
                .conIdTarifa(ID_TARIFA_ACTUALIZAR)
                .conValorPagado(VALOR_PAGAR_ACTUALIZAR)
                .build();

        // act - assert
        mockMvc.perform(put("/pagos/{id}", ID_PAGO_IMPUESTO_PREDIAL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPagoImpuestoPredial)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 1L;

        // act - assert
        mockMvc.perform(delete("/pagos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
