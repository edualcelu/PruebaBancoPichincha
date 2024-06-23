package com.pichincha.bs.application.output.port;

import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.domain.MovementDomain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface MovementOutputPort {
    Flux<MovementDomain> findAll();

    Mono<Void> delete(Integer id);
    Mono<MovementDomain> getById(Integer id);
    Mono<MovementDomain> update(Integer id, MovementDomain movementDomain);
    Mono<MovementDomain> save(MovementDomain movementDomain);

    Flux<MovementDomain> accountTransactionsDate(LocalDate dateStart, LocalDate dateEnd, String account);
}
