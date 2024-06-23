package com.pichincha.bs.application.input.port;

import com.pichincha.bs.domain.CustomerDomain;
import com.pichincha.bs.domain.CustomerTransactionsDomain;
import com.pichincha.services.server.models.Customer;
import com.pichincha.services.server.models.CustomerTransactions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public interface CustomerInputPort {
    Flux<CustomerDomain> findAll();
    Mono<Void> delete(String id);
    Mono<CustomerDomain> getById(String id);
    Mono<CustomerDomain> update(String id, CustomerDomain customerDomain);
    Mono<CustomerDomain> save(CustomerDomain customerDomain);
    Mono<CustomerTransactionsDomain> customerTransactions(LocalDate dateStart, LocalDate dateEnd, String customer);
}
