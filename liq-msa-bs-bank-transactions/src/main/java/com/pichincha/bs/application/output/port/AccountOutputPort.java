package com.pichincha.bs.application.output.port;

import com.pichincha.bs.domain.AccountDomain;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountOutputPort {
    Flux<AccountDomain> findAll();

    Mono<Void> delete(String id);
    Mono<AccountDomain> getById(String id);
    Mono<AccountDomain> update(String id, AccountDomain customerDomain);
    Mono<AccountDomain> save(AccountDomain customerDomain);
    Flux<AccountDomain> getByIdCustomer(String id);

}
