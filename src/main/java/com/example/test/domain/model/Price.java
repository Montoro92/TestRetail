package com.example.test.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Price {

    private final Long productId;
    private final Long brandId;
    private final BigDecimal price;
    private final String currency;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final Long priceList;

    public Price(Long productId, Long brandId, BigDecimal price, String currency,
        LocalDateTime startDate, LocalDateTime endDate, Long priceList) {
        this.productId = productId;
        this.brandId = brandId;
        this.price = price;
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getPriceList() {
        return priceList;
    }
    
}
