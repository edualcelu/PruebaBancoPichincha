package com.pichincha.bs.application.service;

import com.pichincha.bs.application.input.port.CustomerInputPort;
import com.pichincha.bs.application.output.port.CustomerOutputPort;
import com.pichincha.bs.domain.CustomerDomain;
import com.pichincha.bs.domain.CustomerTransactionsDomain;
import com.pichincha.bs.domain.client.CustomerAccountInner;
import com.pichincha.bs.infrastructure.exception.CustomerException;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.CustomerMapper;
import com.pichincha.services.server.models.CustomerTransactionsCustomer;
import com.pichincha.services.server.models.CustomerTransactionsCustomerCustomerAccountInner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerInputPort {
    @Autowired
    private CustomerOutputPort customerOutputPort;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private WebClient webClientTransactions;
    @Override
    public Flux<CustomerDomain> findAll() {
        return customerOutputPort.findAll();
    }

    @Override
    public Mono<Void> delete(String id) {
        return customerOutputPort.delete(id);
    }
    @Override
    public Mono<CustomerDomain> getById(String id) {
        return customerOutputPort.getById(id);
    }
    @Override
    public Mono<CustomerDomain> update(String id, CustomerDomain customerDomain) {
        return customerOutputPort.update(id, customerDomain);
    }

    @Override
    public Mono<CustomerDomain> save(CustomerDomain customerDomain) {
        return customerOutputPort.save(customerDomain);
    }
    /*@Override
    public Mono<CustomerTransactionsDomain> customerTransactions(LocalDate dateStart, LocalDate dateEnd, String idCustomer) {
        return customerOutputPort.getById(idCustomer)
                .switchIfEmpty(Mono.error(new CustomerException("Customer not found")))
                .flatMap(customer -> {
                    // Consultar movimientos por cada cuenta
                        return accountTransactionsDate(dateStart, dateEnd, customer.getId().toString())
                            .collectList()
                            .map(movements -> {
                                CustomerAccountInnerDomain customerAccountInnerDomain = new CustomerAccountInnerDomain();
                                customerAccountInnerDomain.setAccount(accountMapper.AccountDomainToAccount(account));
                                customerAccountInnerDomain.setMovements(movementMapper.ListMovementDomainToMovement(movements));
                                return customerAccountInnerDomain;
                            })
                            .flux();
                });
    }*/
    public Mono<CustomerTransactionsDomain> customerTransactions(LocalDate dateStart, LocalDate dateEnd, String idCustomer) {
        return customerOutputPort.getById(idCustomer)
                .switchIfEmpty(Mono.error(new CustomerException("Customer not found")))
                .flatMap(customer -> {
                    // Consultar movimientos por cada cuenta del cliente
                    return getAccountCustomerFlux(dateStart, dateEnd, customer.getId().toString())
                            //.collectList()
                            .map(movements -> {
                                CustomerTransactionsDomain customerTransactionsDomain = new CustomerTransactionsDomain();
                                customerTransactionsDomain.setCustomer(new CustomerTransactionsCustomer());
                                customerTransactionsDomain.getCustomer().setName(customer.getName());
                                customerTransactionsDomain.getCustomer().setIdentification(customer.getIdentification());
                                customerTransactionsDomain.getCustomer().setCustomerAccount(customerMapper.customerDomaincustomerDomainTocustomerTransactions(movements));//es de tipo List<@Valid CustomerTransactionsCustomerCustomerAccountInner>
                                return customerTransactionsDomain;
                            });
                });
    }
    public Mono<List<CustomerAccountInner>> getAccountCustomerFlux(LocalDate dateStart, LocalDate dateEnd, String idCustomer) {
        return webClientTransactions.get()
                .uri("/business-account/celula/v1/accountCustomer?dateStart={dateStart}&dateEnd={dateEnd}&account={idCustomer}",
                        dateStart, dateEnd, idCustomer)
                .retrieve()
                .bodyToFlux(CustomerAccountInner.class)
                .collectList();
    }
   /* public Mono<List<CustomerTransactionsCustomerCustomerAccountInner>> getCustomerTransactions(LocalDate dateStart, LocalDate dateEnd, String idCustomer) {
        return getAccountCustomerFlux(dateStart, dateEnd, idCustomer)

                .flatMap(accounts -> {
                    if (accounts != null && !accounts.isEmpty()) {
                        return Mono.just(accounts.stream()
                                .map(customerMapper.customerDomaincustomerDomainTocustomerTransactions(accounts))
                                .collect(Collectors.toList()));

                    } else {
                        return Mono.error(new CustomerException("No accounts found for customer"));
                    }
                });
    }*/

    /*public Flux<CustomerAccountInner> getAccountCustomerFlux(LocalDate dateStart, LocalDate dateEnd, String idCustomer) {
        return webClientTransactions.get()
                .uri("/business-account/celula/v1/accountCustomer?dateStart={dateStart}&dateEnd={dateEnd}&account={idCustomer}",
                        dateStart, dateEnd, idCustomer)
                .retrieve()
                .bodyToFlux(CustomerAccountInner.class);
    }*/
}
