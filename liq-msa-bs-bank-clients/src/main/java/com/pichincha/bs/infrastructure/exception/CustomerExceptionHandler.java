package com.pichincha.bs.infrastructure.exception;

import com.pichincha.bs.domain.ErrorCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Mono<ResponseEntity<ErrorCustomer>> handleException(MethodArgumentNotValidException e) {

        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorCustomer.builder()
                .error("Error: Error in input body")
                .message(e.getMessage())
                .build()));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public Mono<ResponseEntity<ErrorCustomer>> handleException(ResponseStatusException e) {

        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorCustomer.builder()
                .error("Error: The input has values out of range or code injection")
                .message(e.getReason())
                .build()));
    }
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ErrorCustomer>> handleException(Exception e) {

        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorCustomer.builder()
                .error("Error: The server has an unexpected error")
                .message(e.getMessage())
                .build()));
    }
    @ExceptionHandler(CustomerException.class)
    public Mono<ResponseEntity<ErrorCustomer>> handleException(CustomerException e) {

        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorCustomer.builder()
                .error("Error: The server has an unexpected error")
                .message(e.getMessage())
                .build()));
    }
}
