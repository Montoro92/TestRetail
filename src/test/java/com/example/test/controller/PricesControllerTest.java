package com.example.test.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.test.exceptions.PriceNotFoundException;
import com.example.test.logic.PricesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PricesController.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PricesService service;

    @Test
    void shouldReturn404WhenPriceNotFound() throws Exception {
        when(service.getApplicablePrice(any(), any(), any()))
                .thenThrow(new PriceNotFoundException("No encontrado"));

        mockMvc.perform(get("/api/prices")
                .param("brand", "1")
                .param("product", "35455")
                .param("date", "2019-06-14T10:00:00Z"))
            .andExpect(status().isNotFound());
    }
    
}
