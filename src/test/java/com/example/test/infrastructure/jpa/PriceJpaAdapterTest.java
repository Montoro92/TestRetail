package com.example.test.infrastructure.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.test.domain.model.Price;
import com.example.test.infrastructure.persistence.adapter.PriceRepositoryAdapter;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(PriceRepositoryAdapter.class)
public class PriceJpaAdapterTest {

    @Autowired
    private PriceRepositoryAdapter adapter;

    @Test
    public void should_find_applicable_price() {

        // when
        Optional<Price> result =
            adapter.findApplicablePrice(
                1L,
                35455L,
                LocalDateTime.of(2020, 7, 15, 15, 30)
            );

        // then
        assertThat(result).isPresent();
        assertThat(result.get().getPrice())
            .isEqualByComparingTo("38.95");
    }
}
