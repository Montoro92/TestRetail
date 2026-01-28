package com.example.test.infrastructure.persistence.adapter;

import com.example.test.domain.model.Price;
import com.example.test.domain.port.PricesRepositoryPort;
import com.example.test.infrastructure.persistence.repository.PricesRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class PriceRepositoryAdapter implements PricesRepositoryPort {

    private final PricesRepository repository;

    public PriceRepositoryAdapter(PricesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Price> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return repository.findApplicablePrice(brandId, productId, applicationDate)
            .map(entity -> new Price(
                entity.getProductId(),
                entity.getBrand().getId(),
                entity.getPrice(),
                entity.getCurr(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList()
            ));
    }
    
}
