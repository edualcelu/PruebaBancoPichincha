package com.pichincha.bs.infrastructure.input.adapter.rest.mapper;

import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.domain.CustomerAccountInnerDomain;
import com.pichincha.bs.infrastructure.output.repository.entity.AccountEntity;
import com.pichincha.services.server.models.Account;
import com.pichincha.services.server.models.CustomerAccountInner;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    //read
    Account AccountDomainToAccount(AccountDomain AccountDomain);
    AccountDomain AccountEntityToAccountDomain(AccountEntity AccountEntity);

    //Insert
    AccountDomain AccountToAccountDomain (Account Account);

    AccountEntity AccountDomainToAccountEntity (AccountDomain AccountDomain);

    CustomerAccountInner CustomerAccountInnerDomainToCustomerAccountInner (CustomerAccountInnerDomain CustomerAccountInnerDomain);
}
