package com.pichincha.bs.application.service;

import com.pichincha.bs.application.input.port.AccountInputPort;
import com.pichincha.bs.application.output.port.AccountOutputPort;
import com.pichincha.bs.application.output.port.MovementOutputPort;
import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.domain.CustomerAccountInnerDomain;
import com.pichincha.bs.domain.MovementDomain;
import com.pichincha.bs.infrastructure.exception.TransactionException;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.AccountMapper;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.MovementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class AccountService implements AccountInputPort {

    @Autowired
    private AccountOutputPort accountOutputPort;
    @Autowired
    private MovementOutputPort movementOutputPort;

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private MovementMapper movementMapper;
    @Override
    public Flux<AccountDomain> findAll() {
        return accountOutputPort.findAll();
    }

    @Override
    public Mono<Void> delete(String accountNumber) {
        return accountOutputPort.delete(accountNumber);
    }

    @Override
    public Mono<AccountDomain> getById(String accountNumber) {
        return accountOutputPort.getById(accountNumber);
    }

    @Override
    public Mono<AccountDomain> update(String accountNumber, AccountDomain customerDomain) {
        return accountOutputPort.update(accountNumber, customerDomain);
    }

    @Override
    public Mono<AccountDomain> save(AccountDomain customerDomain) {
        return accountOutputPort.save(customerDomain);
    }
    public Flux<AccountDomain> getByIdCustomer(String id) {
        return accountOutputPort.getByIdCustomer(id);
    }
    @Override
    public Flux<CustomerAccountInnerDomain> getAccountCustomer(LocalDate dateStart, LocalDate dateEnd, String idCustomer) {
        return getByIdCustomer(idCustomer)
                .switchIfEmpty(Mono.error(new TransactionException("Account not found")))
                .flatMap(account -> {
                    // Consultar movimientos por cada cuenta
                    return movementOutputPort.accountTransactionsDate(dateStart, dateEnd, account.getId().toString())
                            .collectList()
                            .map(movements -> {
                                CustomerAccountInnerDomain customerAccountInnerDomain = new CustomerAccountInnerDomain();
                                customerAccountInnerDomain.setAccount(accountMapper.AccountDomainToAccount(account));
                                customerAccountInnerDomain.setMovements(movementMapper.ListMovementDomainToMovement(movements));
                                return customerAccountInnerDomain;
                            })
                            .flux();
                });
    }
    /*
    @Override
    public  Flux<CustomerAccountInnerDomain> getAccountCustomer(LocalDate dateStart, LocalDate dateEnd, String idCustumer) {
        return getByIdCustomer(idCustumer)
                .switchIfEmpty(Mono.error(new TransactionException("Account not found")))
                .flatMap(account -> {
                    //conusltar movimientos por cada cuenta
                    movementOutputPort.accountTransactionsDate(dateStart,dateEnd,account.getId().toString());

                });
    }
*/

}
