package com.example.test.application.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.test.application.dto.ApplicablePrice;
import com.example.test.domain.model.Price;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;

public class GetApplicablePriceUseCaseTest {

    @Test
    public void should_return_price_when_exists() {
        // given
        FakePriceRepository repository = new FakePriceRepository();
        GetApplicablePriceUseCase useCase = new GetApplicablePriceUseCase(repository);
        OffsetDateTime date = LocalDateTime.now().atOffset(ZoneOffset.UTC);

        Price repoPrice = new Price(
            35455L,
            1L,
            new BigDecimal("35.50"),
            "EUR",
            date.toLocalDateTime(),
            date.toLocalDateTime(),
            1L
        );

        ApplicablePrice expectedPrice = ApplicablePrice.builder()
            .productId(35455L)
            .brandId(1L)
            .price(new BigDecimal("35.50"))
            .startDate(date)
            .endDate(date)
            .applicableRate(1L).build();

        repository.returns(repoPrice);

        // when
        ApplicablePrice result = useCase.execute(1L,35455L, OffsetDateTime.now());

        // then
        assertThat(result).isEqualTo(expectedPrice);
    }

    @Test
    public void should_throw_exception_when_price_not_found() {
        // given
        FakePriceRepository repository = new FakePriceRepository();
        GetApplicablePriceUseCase useCase = new GetApplicablePriceUseCase(repository);

        // when / then
        assertThatThrownBy(() -> useCase.execute(1L, 35455L, OffsetDateTime.now()))
            .isInstanceOf(RuntimeException.class).hasMessage("There is no applicable price for this product 35455");
    }
    
}
