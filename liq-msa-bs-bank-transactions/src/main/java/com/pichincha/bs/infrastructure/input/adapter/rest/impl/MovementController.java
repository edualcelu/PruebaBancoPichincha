package com.pichincha.bs.infrastructure.input.adapter.rest.impl;

import com.pichincha.bs.application.input.port.MovementInputPort;
import com.pichincha.bs.application.output.port.MovementOutputPort;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.MovementMapper;
import com.pichincha.services.server.BusinessTransactionsApi;
import com.pichincha.services.server.models.Movement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MovementController implements BusinessTransactionsApi {

    @Autowired
    private MovementInputPort movementInputPort;
    @Autowired
    private MovementMapper movementMapper;
    @Override
    public Mono<ResponseEntity<Flux<Movement>>> getMovement(ServerWebExchange exchange) {
        return  Mono.just(new ResponseEntity<>(
                movementInputPort.findAll()
                        .map(movementMapper::MovementDomainToMovement),
        HttpStatus.OK));
    }
    @Override
    public Mono<ResponseEntity<Movement>> getMovementById(Integer id, ServerWebExchange exchange) {
        return movementInputPort.getById(id)
                .map(Customer -> new ResponseEntity<>(
                        movementMapper.MovementDomainToMovement(Customer),
                        HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Movement>> postMovement(Movement movement, ServerWebExchange exchange) {
        return movementInputPort.save(
                        movementMapper.MovementToMovementDomain(movement))
                .map(Customer -> new ResponseEntity<>(
                        movementMapper.MovementDomainToMovement(Customer),
                        HttpStatus.CREATED));
    }

    @Override
    public Mono<ResponseEntity<Movement>> putMovement(Integer id, Movement movement, ServerWebExchange exchange) {
        return movementInputPort.update(
                        id,movementMapper.MovementToMovementDomain(movement))
                .map(Customer -> new ResponseEntity<>(
                        movementMapper.MovementDomainToMovement(Customer),
                        HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteMovement(Integer id, ServerWebExchange exchange) {
        return movementInputPort.delete(id)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.NO_CONTENT)));
    }

    @Override
    public Mono<ResponseEntity<Flux<Movement>>> customerTransactions(LocalDate dateStart, LocalDate dateEnd, String account, ServerWebExchange exchange) {
        return  Mono.just(new ResponseEntity<>(
                movementInputPort.accountTransactionsDate(dateStart, dateEnd, account)
                        .map(movementMapper::MovementDomainToMovement),
                HttpStatus.OK));
    }
}
