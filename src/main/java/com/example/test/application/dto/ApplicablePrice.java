package com.example.test.application.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data to get the installation result.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicablePrice {

    private Long productId;
    private Long brandId;
    private Long applicableRate;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private BigDecimal price;
    
}
