package com.example.test.logic.repository;

import com.example.test.logic.model.Price;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepository extends JpaRepository<Price, Long> {

    @Query("""
        SELECT p
        FROM Price p
        WHERE p.brand.id = :brandId
          AND p.productId = :productId
          AND :date BETWEEN p.startDate AND p.endDate
        ORDER BY p.priority DESC, p.startDate DESC
        LIMIT 1
    """)
    Optional<Price> findApplicablePrice(
        Long brandId,
        Long productId,
        LocalDateTime date
    );
    
}
