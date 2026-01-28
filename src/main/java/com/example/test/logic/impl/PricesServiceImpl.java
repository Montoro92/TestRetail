package com.example.test.logic.impl;

import com.example.test.dto.ApplicablePrice;
import com.example.test.exceptions.PriceNotFoundException;
import com.example.test.logic.PricesService;
import com.example.test.logic.mappers.PricesResultMapper;
import com.example.test.logic.model.Price;
import com.example.test.logic.repository.PricesRepository;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {

    private final PricesRepository repository;

    private static final PricesResultMapper RESULT_MAPPER = new PricesResultMapper();

    @Override
    public ApplicablePrice getApplicablePrice(OffsetDateTime date, Long productId, Long brandId) {
        Price applicablePrice = repository.findApplicablePrice(brandId, productId, date.toLocalDateTime())
            .orElseThrow(() -> 
                new PriceNotFoundException("There is no applicable price for this product " + productId)
            );
        return RESULT_MAPPER.map(applicablePrice);
    }
    
}
