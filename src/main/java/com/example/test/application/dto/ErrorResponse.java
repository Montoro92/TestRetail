package com.example.test.application.dto;

public record ErrorResponse(
        int status,
        String message
) {}
