package com.example.test.infrastructure.persistence.repository;

import com.example.test.infrastructure.persistence.entity.PriceEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PricesRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
        SELECT p
        FROM PriceEntity p
        WHERE p.brand.id = :brandId
          AND p.productId = :productId
          AND :date BETWEEN p.startDate AND p.endDate
        ORDER BY p.priority DESC, p.startDate DESC
        LIMIT 1
    """)
    Optional<PriceEntity> findApplicablePrice(
        Long brandId,
        Long productId,
        LocalDateTime date
    );
    
}
