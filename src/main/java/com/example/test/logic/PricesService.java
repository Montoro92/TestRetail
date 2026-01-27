package com.example.test.logic;

import com.example.test.dto.ApplicablePrice;
import java.time.OffsetDateTime;

public interface PricesService {

    ApplicablePrice getApplicablePrice(OffsetDateTime date, Long productId, Long brandId);
    
}
