package com.pichincha.bs.infrastructure.input.adapter.rest.mapper;

import com.pichincha.bs.domain.CustomerDomain;
import com.pichincha.bs.domain.CustomerTransactionsDomain;
import com.pichincha.bs.domain.client.CustomerAccountInner;
import com.pichincha.bs.infrastructure.output.repository.entity.CustomerEntity;
import com.pichincha.services.server.models.Customer;
import com.pichincha.services.server.models.CustomerTransactions;
import com.pichincha.services.server.models.CustomerTransactionsCustomerCustomerAccountInner;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    //read
    Customer CustomerDomainToCustomer(CustomerDomain customerDomain);
    CustomerDomain CustomerEntityToCustomerDomain(CustomerEntity customerEntity);

    //Insert
    CustomerDomain customerToCustomerDomain (Customer customer);

    CustomerEntity customerDomainToCustomerEntity (CustomerDomain customerDomain);

    //Report
    CustomerTransactions customerDomainTocustomerTransactions (CustomerTransactionsDomain customerDomain);

    List<CustomerTransactionsCustomerCustomerAccountInner> customerDomaincustomerDomainTocustomerTransactions (List<CustomerAccountInner> customerDomain);
}