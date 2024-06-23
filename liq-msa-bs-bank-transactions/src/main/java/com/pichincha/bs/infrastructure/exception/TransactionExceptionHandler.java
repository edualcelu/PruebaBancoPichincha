package com.pichincha.bs.infrastructure.exception;

import com.pichincha.bs.domain.ErrorTransaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;
@ControllerAdvice
public class TransactionExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorTransaction>> handleException(Exception e) {

        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorTransaction.builder()
                .error("Error: The server has an unexpected error")
                .message(e.getMessage())
                .build()));
    }
}
