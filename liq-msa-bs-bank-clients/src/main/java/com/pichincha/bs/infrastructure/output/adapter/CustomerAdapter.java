package com.pichincha.bs.infrastructure.output.adapter;

import com.pichincha.bs.application.output.port.CustomerOutputPort;
import com.pichincha.bs.domain.CustomerDomain;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.CustomerMapper;
import com.pichincha.bs.infrastructure.output.repository.CustomerRepository;
import com.pichincha.bs.infrastructure.output.repository.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerOutputPort {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Flux<CustomerDomain> findAll() {
        return customerRepository.findAll().map(customerMapper::CustomerEntityToCustomerDomain);
    }


    @Override
    public Mono<Void> delete(String id) {
        return customerRepository.delete(id);
    }
    @Override
    public Mono<CustomerDomain> getById(String id) {
        return customerRepository.getById(id)
        .map(customerMapper::CustomerEntityToCustomerDomain);
    }
    @Override
    public Mono<CustomerDomain> update(String id, CustomerDomain customerDomain) {
        return customerRepository.update(id, customerMapper.customerDomainToCustomerEntity(customerDomain)
        ).map(customerMapper::CustomerEntityToCustomerDomain);
    }
    @Override
    public Mono<CustomerDomain> save( CustomerDomain customerDomain) {
        return customerRepository.save(customerMapper.customerDomainToCustomerEntity(customerDomain)
        ).map(customerMapper::CustomerEntityToCustomerDomain);
    }

}
