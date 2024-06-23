package com.pichincha.bs.application.output.port;

import com.pichincha.bs.domain.CustomerDomain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CustomerOutputPort {

    Flux<CustomerDomain> findAll();

    Mono<Void> delete(String id);
    Mono<CustomerDomain> getById(String id);
    Mono<CustomerDomain> update(String id, CustomerDomain customerDomain);
    Mono<CustomerDomain> save(CustomerDomain customerDomain);



}
