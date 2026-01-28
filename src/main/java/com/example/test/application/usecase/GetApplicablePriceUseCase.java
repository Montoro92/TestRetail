package com.example.test.application.usecase;

import com.example.test.application.dto.ApplicablePrice;
import com.example.test.application.mappers.PricesResultMapper;
import com.example.test.domain.model.Price;
import com.example.test.domain.port.PricesRepositoryPort;
import com.example.test.exceptions.PriceNotFoundException;
import java.time.OffsetDateTime;
import org.springframework.stereotype.Service;

@Service
public class GetApplicablePriceUseCase {

    private final PricesRepositoryPort priceRepository;

    private static final PricesResultMapper RESULT_MAPPER = new PricesResultMapper();

    public GetApplicablePriceUseCase(PricesRepositoryPort priceRepository) {
        this.priceRepository = priceRepository;
    }

    public ApplicablePrice execute(Long brandId, Long productId, OffsetDateTime date) {
        Price price = priceRepository.findApplicablePrice(brandId, productId, date.toLocalDateTime())
            .orElseThrow(() -> 
                new PriceNotFoundException("There is no applicable price for this product " + productId)
            );
        return RESULT_MAPPER.map(price);
    }
    
}
