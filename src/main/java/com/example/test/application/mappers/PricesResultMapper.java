package com.example.test.application.mappers;

import com.example.test.application.dto.ApplicablePrice;
import com.example.test.domain.model.Price;
import java.time.ZoneId;

public class PricesResultMapper {

    public ApplicablePrice map(Price other) {
        return ApplicablePrice.builder()
            .brandId(other.getBrandId())
            .productId(other.getProductId())
            .applicableRate(other.getPriceList())
            .startDate(other.getStartDate().atZone(ZoneId.of("UTC")).toOffsetDateTime())
            .endDate(other.getEndDate().atZone(ZoneId.of("UTC")).toOffsetDateTime())
            .price(other.getPrice())
            .build();
    }
    
}
