package com.pichincha.bs.infrastructure.input.adapter.rest.mapper;

import com.pichincha.bs.domain.CustomerDomain;
import com.pichincha.bs.domain.CustomerTransactionsDomain;
import com.pichincha.bs.domain.client.Account;
import com.pichincha.bs.domain.client.CustomerAccountInner;
import com.pichincha.bs.domain.client.Movement;
import com.pichincha.bs.infrastructure.output.repository.entity.CustomerEntity;
import com.pichincha.services.server.models.Customer;
import com.pichincha.services.server.models.CustomerTransactions;
import com.pichincha.services.server.models.CustomerTransactionsCustomerCustomerAccountInner;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer CustomerDomainToCustomer(CustomerDomain customerDomain) {
        if ( customerDomain == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDomain.getId() );
        customer.setPassword( customerDomain.getPassword() );
        customer.setStatus( customerDomain.getStatus() );
        customer.setName( customerDomain.getName() );
        customer.setGender( customerDomain.getGender() );
        customer.setAge( customerDomain.getAge() );
        customer.setIdentification( customerDomain.getIdentification() );
        customer.setAddress( customerDomain.getAddress() );
        customer.setPhone( customerDomain.getPhone() );

        return customer;
    }

    @Override
    public CustomerDomain CustomerEntityToCustomerDomain(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDomain customerDomain = new CustomerDomain();

        customerDomain.setId( customerEntity.getId() );
        customerDomain.setName( customerEntity.getName() );
        customerDomain.setGender( customerEntity.getGender() );
        customerDomain.setAge( customerEntity.getAge() );
        customerDomain.setIdentification( customerEntity.getIdentification() );
        customerDomain.setAddress( customerEntity.getAddress() );
        customerDomain.setPhone( customerEntity.getPhone() );
        customerDomain.setPassword( customerEntity.getPassword() );
        if ( customerEntity.getStatus() != null ) {
            customerDomain.setStatus( String.valueOf( customerEntity.getStatus() ) );
        }

        return customerDomain;
    }

    @Override
    public CustomerDomain customerToCustomerDomain(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDomain customerDomain = new CustomerDomain();

        customerDomain.setId( customer.getId() );
        customerDomain.setName( customer.getName() );
        customerDomain.setGender( customer.getGender() );
        customerDomain.setAge( customer.getAge() );
        customerDomain.setIdentification( customer.getIdentification() );
        customerDomain.setAddress( customer.getAddress() );
        customerDomain.setPhone( customer.getPhone() );
        customerDomain.setPassword( customer.getPassword() );
        customerDomain.setStatus( customer.getStatus() );

        return customerDomain;
    }

    @Override
    public CustomerEntity customerDomainToCustomerEntity(CustomerDomain customerDomain) {
        if ( customerDomain == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customerDomain.getId() );
        customerEntity.setName( customerDomain.getName() );
        customerEntity.setGender( customerDomain.getGender() );
        customerEntity.setAge( customerDomain.getAge() );
        customerEntity.setIdentification( customerDomain.getIdentification() );
        customerEntity.setAddress( customerDomain.getAddress() );
        customerEntity.setPhone( customerDomain.getPhone() );
        customerEntity.setPassword( customerDomain.getPassword() );
        if ( customerDomain.getStatus() != null ) {
            customerEntity.setStatus( Boolean.parseBoolean( customerDomain.getStatus() ) );
        }

        return customerEntity;
    }

    @Override
    public CustomerTransactions customerDomainTocustomerTransactions(CustomerTransactionsDomain customerDomain) {
        if ( customerDomain == null ) {
            return null;
        }

        CustomerTransactions customerTransactions = new CustomerTransactions();

        customerTransactions.setCustomer( customerDomain.getCustomer() );

        return customerTransactions;
    }

    @Override
    public List<CustomerTransactionsCustomerCustomerAccountInner> customerDomaincustomerDomainTocustomerTransactions(List<CustomerAccountInner> customerDomain) {
        if ( customerDomain == null ) {
            return null;
        }

        List<CustomerTransactionsCustomerCustomerAccountInner> list = new ArrayList<CustomerTransactionsCustomerCustomerAccountInner>( customerDomain.size() );
        for ( CustomerAccountInner customerAccountInner : customerDomain ) {
            list.add( customerAccountInnerToCustomerTransactionsCustomerCustomerAccountInner( customerAccountInner ) );
        }

        return list;
    }

    protected com.pichincha.services.server.models.Account accountToAccount(Account account) {
        if ( account == null ) {
            return null;
        }

        com.pichincha.services.server.models.Account account1 = new com.pichincha.services.server.models.Account();

        account1.setId( account.getId() );
        account1.setNumber( account.getNumber() );
        account1.setType( account.getType() );
        account1.setInitialBalance( account.getInitialBalance() );
        account1.setStatus( account.getStatus() );
        account1.setCustomerId( account.getCustomerId() );

        return account1;
    }

    protected com.pichincha.services.server.models.Movement.TypeEnum typeEnumToTypeEnum(Movement.TypeEnum typeEnum) {
        if ( typeEnum == null ) {
            return null;
        }

        com.pichincha.services.server.models.Movement.TypeEnum typeEnum1;

        switch ( typeEnum ) {
            case DEBITO: typeEnum1 = com.pichincha.services.server.models.Movement.TypeEnum.DEBITO;
            break;
            case CREDITO: typeEnum1 = com.pichincha.services.server.models.Movement.TypeEnum.CREDITO;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + typeEnum );
        }

        return typeEnum1;
    }

    protected com.pichincha.services.server.models.Movement movementToMovement(Movement movement) {
        if ( movement == null ) {
            return null;
        }

        com.pichincha.services.server.models.Movement movement1 = new com.pichincha.services.server.models.Movement();

        movement1.setId( movement.getId() );
        movement1.setDate( movement.getDate() );
        movement1.setType( typeEnumToTypeEnum( movement.getType() ) );
        movement1.setAmount( movement.getAmount() );
        movement1.setBalance( movement.getBalance() );
        movement1.setAccountId( movement.getAccountId() );

        return movement1;
    }

    protected List<com.pichincha.services.server.models.Movement> movementListToMovementList(List<Movement> list) {
        if ( list == null ) {
            return null;
        }

        List<com.pichincha.services.server.models.Movement> list1 = new ArrayList<com.pichincha.services.server.models.Movement>( list.size() );
        for ( Movement movement : list ) {
            list1.add( movementToMovement( movement ) );
        }

        return list1;
    }

    protected CustomerTransactionsCustomerCustomerAccountInner customerAccountInnerToCustomerTransactionsCustomerCustomerAccountInner(CustomerAccountInner customerAccountInner) {
        if ( customerAccountInner == null ) {
            return null;
        }

        CustomerTransactionsCustomerCustomerAccountInner customerTransactionsCustomerCustomerAccountInner = new CustomerTransactionsCustomerCustomerAccountInner();

        customerTransactionsCustomerCustomerAccountInner.setAccount( accountToAccount( customerAccountInner.getAccount() ) );
        customerTransactionsCustomerCustomerAccountInner.setMovements( movementListToMovementList( customerAccountInner.getMovements() ) );

        return customerTransactionsCustomerCustomerAccountInner;
    }
}
