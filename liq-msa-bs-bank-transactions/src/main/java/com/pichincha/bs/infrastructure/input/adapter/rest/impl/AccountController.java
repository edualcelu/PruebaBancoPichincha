package com.pichincha.bs.infrastructure.input.adapter.rest.impl;

import com.pichincha.bs.application.input.port.AccountInputPort;
import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.AccountMapper;
import com.pichincha.bs.infrastructure.output.repository.entity.AccountEntity;
import com.pichincha.services.server.BusinessAccountApi;
import com.pichincha.services.server.models.Account;
import com.pichincha.services.server.models.CustomerAccountInner;
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
public class AccountController implements BusinessAccountApi {

    @Autowired
    private AccountInputPort accountInputPort;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Mono<ResponseEntity<Flux<Account>>> getAccount(ServerWebExchange exchange) {
       return Mono.just(new ResponseEntity<>(
               accountInputPort.findAll()
                       .map(accountMapper::AccountDomainToAccount),
               HttpStatus.OK));

    }

    @Override
    public Mono<ResponseEntity<Account>> getAccountNumber(String accountNumber, ServerWebExchange exchange) {
        return accountInputPort.getById(accountNumber)
                .map(Account -> new ResponseEntity<>(
                        accountMapper.AccountDomainToAccount(Account),
                        HttpStatus.OK));

    }

    @Override
    public Mono<ResponseEntity<Account>> postAccount(Account account, ServerWebExchange exchange) {
        return accountInputPort.save(
                        accountMapper.AccountToAccountDomain(account))
                .map(Account -> new ResponseEntity<>(
                        accountMapper.AccountDomainToAccount(Account),
                        HttpStatus.CREATED));
    }
    @Override
    public Mono<ResponseEntity<Account>> putAccount(String accountNumber, Account account, ServerWebExchange exchange) {
        return accountInputPort.update(
                        accountNumber,accountMapper.AccountToAccountDomain(account))
                .map(Customer -> new ResponseEntity<>(
                        accountMapper.AccountDomainToAccount(Customer),
                        HttpStatus.OK));
    }

    @Override
    public Mono<ResponseEntity<Void>> deleteAccount(String accountNumber, ServerWebExchange exchange) {

        return accountInputPort.delete(accountNumber)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.NO_CONTENT)));
    }

    @Override
    public Mono<ResponseEntity<Flux<CustomerAccountInner>>> getAccountCustomer(LocalDate dateStart, LocalDate dateEnd, String idCustumer, ServerWebExchange exchange) {
        return Mono.just(new ResponseEntity<>(
                accountInputPort.getAccountCustomer( dateStart,  dateEnd,  idCustumer)
                        .map(accountMapper::CustomerAccountInnerDomainToCustomerAccountInner),
                HttpStatus.OK));
    }


}
