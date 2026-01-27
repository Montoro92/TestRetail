package com.example.test.logic.mappers;

import com.example.test.dto.ApplicablePrice;
import com.example.test.logic.model.Price;
import java.time.ZoneId;

public class PricesResultMapper {

    public ApplicablePrice map(Price other) {
        return ApplicablePrice.builder()
            .brandId(other.getBrand().getId())
            .productId(other.getProductId())
            .applicableRate(other.getPriceList())
            .startDate(other.getStartDate().atZone(ZoneId.of("UTC")).toOffsetDateTime())
            .endDate(other.getEndDate().atZone(ZoneId.of("UTC")).toOffsetDateTime())
            .price(other.getPrice())
            .build();
    }
    
}
