package com.example.test.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.test.application.dto.ApplicablePrice;
import com.example.test.application.usecase.GetApplicablePriceUseCase;
import com.example.test.infrastructure.web.PricesController;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PricesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetApplicablePriceUseCase useCase;

    @Test
    public void should_return_200_when_price_exists() throws Exception {
        // given
        ApplicablePrice price = ApplicablePrice.builder()
            .productId(35455L)
            .brandId(1L)
            .price(new BigDecimal("35.50"))
            .applicableRate(1L).build();

        when(useCase.execute(any(), any(), any()))
            .thenReturn(price);

        // when / then
        mockMvc.perform(get("/api/prices")
                .param("brand", "1")
                .param("product", "35455")
                .param("date", "2020-06-14T10:00:00Z")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.50));
    }
}
