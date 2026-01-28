package com.example.test.e2e;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("e2e")
class PricesE2EH2IT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnNotFoundApplicablePrice() throws Exception {

        mockMvc.perform(
                get("/api/prices")
                    .param("brand", "2")
                    .param("product", "35455")
                    .param("date", "2020-06-14T10:00:00Z")
        )
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.status").value(404));
    }

    @Test
    void shouldReturnApplicablePrice1() throws Exception {

        mockMvc.perform(
                get("/api/prices")
                    .param("brand", "1")
                    .param("product", "35455")
                    .param("date", "2020-06-14T10:00:00Z")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void shouldReturnApplicablePrice2() throws Exception {

        mockMvc.perform(
                get("/api/prices")
                    .param("brand", "1")
                    .param("product", "35455")
                    .param("date", "2020-06-14T16:00:00Z")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    void shouldReturnApplicablePrice3() throws Exception {

        mockMvc.perform(
                get("/api/prices")
                    .param("brand", "1")
                    .param("product", "35455")
                    .param("date", "2020-06-14T21:00:00Z")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    void shouldReturnApplicablePrice4() throws Exception {

        mockMvc.perform(
                get("/api/prices")
                    .param("brand", "1")
                    .param("product", "35455")
                    .param("date", "2020-06-15T10:00:00Z")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    void shouldReturnApplicablePrice5() throws Exception {

        mockMvc.perform(
                get("/api/prices")
                    .param("brand", "1")
                    .param("product", "35455")
                    .param("date", "2020-06-16T21:00:00Z")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.productId").value(35455))
        .andExpect(jsonPath("$.brandId").value(1))
        .andExpect(jsonPath("$.price").value(38.95));
    }

}
