package com.example.test.infrastructure.web;

import com.example.test.application.dto.ApplicablePrice;
import com.example.test.application.usecase.GetApplicablePriceUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.time.OffsetDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
@RequiredArgsConstructor
public class PricesController {

    private final GetApplicablePriceUseCase applicablePrice;

    @GetMapping
    @Operation(summary = "Get applicable price")
    public ResponseEntity<ApplicablePrice> getApplicablePrice(
        @RequestParam(name = "date", required = true) @Parameter(
            description = "Application date") OffsetDateTime date, 
            @RequestParam(name = "product", required = true) @Parameter(
            description = "Product identifier") Long productId, 
            @RequestParam(name = "brand", required = true) @Parameter(
            description = "Brand identifier") Long brandId) {
        return ResponseEntity.ok(applicablePrice.execute(brandId, productId, date));
    }
    
}
