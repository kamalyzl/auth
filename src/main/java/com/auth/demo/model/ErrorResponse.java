package com.auth.demo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private String error;
    private String message;

    public ErrorResponse(String error, String message) {
        this.timestamp = LocalDateTime.now();
        this.error = error;
        this.message = message;
    }
}
