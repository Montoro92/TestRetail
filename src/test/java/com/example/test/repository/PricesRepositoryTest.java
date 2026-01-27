package com.example.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.test.logic.model.Price;
import com.example.test.logic.repository.PricesRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class PricesRepositoryTest {

    @Autowired
    private PricesRepository repository;

    @Test
    void shouldFindApplicablePrice() {
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

        Optional<Price> result =
                repository.findApplicablePrice(1L, 35455L, date);

        assertThat(result).isPresent();
        assertThat(result.get().getPrice())
                .isEqualByComparingTo(new BigDecimal("35.50"));
    }
    
}
