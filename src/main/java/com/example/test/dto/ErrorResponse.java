package com.example.test.dto;

public record ErrorResponse(
        int status,
        String message
) {}
