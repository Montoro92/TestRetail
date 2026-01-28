package com.example.test.domain.port;

import com.example.test.domain.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PricesRepositoryPort {

    Optional<Price> findApplicablePrice(
        Long brandId,
        Long productId,
        LocalDateTime applicationDate
    );
}

