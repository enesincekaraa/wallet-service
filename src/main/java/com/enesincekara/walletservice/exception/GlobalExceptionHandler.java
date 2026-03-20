package com.enesincekara.walletservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorDetails> handleException(IllegalArgumentException ex) {
        ErrorDetails error = new ErrorDetails(
                java.time.LocalDateTime.now(),
                ex.getMessage(),
                "BAD_REQUEST"
        );
        return ResponseEntity.badRequest().body(error);
    }
}
