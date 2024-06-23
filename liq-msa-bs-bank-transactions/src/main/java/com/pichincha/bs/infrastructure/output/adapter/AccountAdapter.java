package com.pichincha.bs.infrastructure.output.adapter;

import com.pichincha.bs.application.output.port.AccountOutputPort;
import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.AccountMapper;
import com.pichincha.bs.infrastructure.output.repository.AccountRepository;
import com.pichincha.bs.infrastructure.output.repository.entity.AccountEntity;
import com.pichincha.services.server.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class AccountAdapter implements AccountOutputPort {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Flux<AccountDomain> findAll() {
        return accountRepository.findAll().map(accountMapper::AccountEntityToAccountDomain);
    }
     @Override
    public Mono<Void> delete(String id) {
        return accountRepository.delete(id);
    }

    @Override
    public Mono<AccountDomain> getById(String id) {
        return accountRepository.getById(id)
                .map(accountMapper::AccountEntityToAccountDomain);
    }
    public AccountDomain AccountEntityToAccountDomain(AccountEntity accountEntity){
        System.out.print("");
        return null;
    }
    @Override
    public Mono<AccountDomain> update(String id, AccountDomain customerDomain) {
        return accountRepository.update(id, accountMapper.AccountDomainToAccountEntity(customerDomain)
        ).map(accountMapper::AccountEntityToAccountDomain);
    }

    @Override
    public Mono<AccountDomain> save(AccountDomain customerDomain) {
        return accountRepository.save(accountMapper.AccountDomainToAccountEntity(customerDomain)
        ).map(accountMapper::AccountEntityToAccountDomain);
    }

    @Override
    public Flux<AccountDomain> getByIdCustomer(String id) {
        return accountRepository.getByIdCustomer(id
        ).map(accountMapper::AccountEntityToAccountDomain);
    }
}
