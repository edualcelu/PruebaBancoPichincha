package com.pichincha.bs.application.input.port;

import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.domain.CustomerAccountInnerDomain;
import com.pichincha.services.server.models.CustomerAccountInner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface AccountInputPort {

    Flux<AccountDomain> findAll();
    Mono<Void> delete(String accountNumber);
    Mono<AccountDomain> getById(String accountNumber);
    Mono<AccountDomain> update(String accountNumber, AccountDomain customerDomain);
    Mono<AccountDomain> save(AccountDomain customerDomain);

    Flux<CustomerAccountInnerDomain> getAccountCustomer(LocalDate dateStart, LocalDate dateEnd, String idCustumer);
}
