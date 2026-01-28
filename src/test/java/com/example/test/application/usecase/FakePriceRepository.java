package com.example.test.application.usecase;

import com.example.test.domain.model.Price;
import com.example.test.domain.port.PricesRepositoryPort;
import java.time.LocalDateTime;
import java.util.Optional;

public class FakePriceRepository implements PricesRepositoryPort {

    private Price priceToReturn;

    void returns(Price price) {
        this.priceToReturn = price;
    }

    @Override
    public Optional<Price> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return Optional.ofNullable(priceToReturn);
    }
    
}
