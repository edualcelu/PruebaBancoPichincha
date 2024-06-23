package com.pichincha.bs.infrastructure.input.adapter.rest.impl;

import com.pichincha.bs.application.input.port.CustomerInputPort;
import com.pichincha.bs.application.output.port.CustomerOutputPort;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.CustomerMapper;
import com.pichincha.services.server.BusinessApi;
import com.pichincha.services.server.models.Customer;
import com.pichincha.services.server.models.CustomerTransactions;
import jakarta.validation.Valid;
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
public class CustomerController implements BusinessApi {

    @Autowired
    private CustomerInputPort customerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Mono<ResponseEntity<Flux<Customer>>> getCustomer(ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(
                customerInputPort.findAll().map(customerMapper::CustomerDomainToCustomer),
                HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteCustomer(String id, ServerWebExchange exchange) {
        return customerInputPort.delete(id)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.NO_CONTENT)));
    }

    @Override
    public Mono<ResponseEntity<Customer>> getCustomerId(String id, ServerWebExchange exchange) {
        return customerInputPort.getById(id)
                .map(Customer -> new ResponseEntity<>(
                        customerMapper.CustomerDomainToCustomer(Customer),
                        HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Customer>> putCustomer(String id, Customer customer, ServerWebExchange exchange) {
        return customerInputPort.update(
                        id,customerMapper.customerToCustomerDomain(customer))
                .map(Customer -> new ResponseEntity<>(
                        customerMapper.CustomerDomainToCustomer(Customer),
                        HttpStatus.OK));
    }
    @Override
    public Mono<ResponseEntity<Customer>> postCustomer(@Valid Customer customer, ServerWebExchange exchange) {
        return customerInputPort.save(
                        customerMapper.customerToCustomerDomain(customer))
                .map(Customer -> new ResponseEntity<>(
                        customerMapper.CustomerDomainToCustomer(Customer),
                        HttpStatus.CREATED));
    }

    /**
     * @param dateStart Fecha inicio para filtrar movimientos (required)
     * @param dateEnd   Fecha Fin para filtrar movimientos (required)
     * @param customer  Nombre de usuario para filtrar movimientos. (required)
     * @param exchange
     * @return
     */
    @Override
    public Mono<ResponseEntity<CustomerTransactions>> customerTransactions(LocalDate dateStart, LocalDate dateEnd, String customer, ServerWebExchange exchange) {
        return customerInputPort.customerTransactions(dateStart, dateEnd, customer)
                .map(CustomerTransactions -> new ResponseEntity<>(
                        customerMapper.customerDomainTocustomerTransactions(CustomerTransactions),
                        HttpStatus.CREATED));
    }
}
