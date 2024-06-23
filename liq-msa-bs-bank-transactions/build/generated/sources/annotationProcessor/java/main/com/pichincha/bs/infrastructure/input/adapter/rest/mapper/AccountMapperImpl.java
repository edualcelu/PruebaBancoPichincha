package com.pichincha.bs.infrastructure.input.adapter.rest.mapper;

import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.domain.CustomerAccountInnerDomain;
import com.pichincha.bs.infrastructure.output.repository.entity.AccountEntity;
import com.pichincha.services.server.models.Account;
import com.pichincha.services.server.models.CustomerAccountInner;
import com.pichincha.services.server.models.Movement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account AccountDomainToAccount(AccountDomain AccountDomain) {
        if ( AccountDomain == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( AccountDomain.getId() );
        account.setNumber( AccountDomain.getNumber() );
        account.setType( AccountDomain.getType() );
        account.setInitialBalance( AccountDomain.getInitialBalance() );
        if ( AccountDomain.getStatus() != null ) {
            account.setStatus( String.valueOf( AccountDomain.getStatus() ) );
        }
        account.setCustomerId( AccountDomain.getCustomerId() );

        return account;
    }

    @Override
    public AccountDomain AccountEntityToAccountDomain(AccountEntity AccountEntity) {
        if ( AccountEntity == null ) {
            return null;
        }

        AccountDomain accountDomain = new AccountDomain();

        accountDomain.setId( AccountEntity.getId() );
        accountDomain.setNumber( AccountEntity.getNumber() );
        accountDomain.setType( AccountEntity.getType() );
        accountDomain.setInitialBalance( AccountEntity.getInitialBalance() );
        accountDomain.setStatus( AccountEntity.getStatus() );
        accountDomain.setCustomerId( AccountEntity.getCustomerId() );

        return accountDomain;
    }

    @Override
    public AccountDomain AccountToAccountDomain(Account Account) {
        if ( Account == null ) {
            return null;
        }

        AccountDomain accountDomain = new AccountDomain();

        accountDomain.setId( Account.getId() );
        accountDomain.setNumber( Account.getNumber() );
        accountDomain.setType( Account.getType() );
        accountDomain.setInitialBalance( Account.getInitialBalance() );
        if ( Account.getStatus() != null ) {
            accountDomain.setStatus( Boolean.parseBoolean( Account.getStatus() ) );
        }
        accountDomain.setCustomerId( Account.getCustomerId() );

        return accountDomain;
    }

    @Override
    public AccountEntity AccountDomainToAccountEntity(AccountDomain AccountDomain) {
        if ( AccountDomain == null ) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();

        accountEntity.setId( AccountDomain.getId() );
        accountEntity.setNumber( AccountDomain.getNumber() );
        accountEntity.setType( AccountDomain.getType() );
        accountEntity.setInitialBalance( AccountDomain.getInitialBalance() );
        accountEntity.setStatus( AccountDomain.getStatus() );
        accountEntity.setCustomerId( AccountDomain.getCustomerId() );

        return accountEntity;
    }

    @Override
    public CustomerAccountInner CustomerAccountInnerDomainToCustomerAccountInner(CustomerAccountInnerDomain CustomerAccountInnerDomain) {
        if ( CustomerAccountInnerDomain == null ) {
            return null;
        }

        CustomerAccountInner customerAccountInner = new CustomerAccountInner();

        customerAccountInner.setAccount( CustomerAccountInnerDomain.getAccount() );
        List<Movement> list = CustomerAccountInnerDomain.getMovements();
        if ( list != null ) {
            customerAccountInner.setMovements( new ArrayList<Movement>( list ) );
        }

        return customerAccountInner;
    }
}
