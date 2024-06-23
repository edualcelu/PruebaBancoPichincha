package com.pichincha.services.server.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pichincha.services.server.models.CustomerTransactionsCustomerCustomerAccountInner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CustomerTransactionsCustomer
 */

@JsonTypeName("CustomerTransactions_customer")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-23T13:28:31.646116600-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
public class CustomerTransactionsCustomer implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String identification;

  @Valid
  private List<@Valid CustomerTransactionsCustomerCustomerAccountInner> customerAccount;

  public CustomerTransactionsCustomer name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nombre del cliente
   * @return name
  */
  @Pattern(regexp = "^[^'\";|?&=<>\\(\\)%{}\\[\\]\\/:\\-+#\\$]$") @Size(max = 100) 
  @Schema(name = "name", example = "Marianela Montalvo", description = "Nombre del cliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerTransactionsCustomer identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * Identificación del cliente
   * @return identification
  */
  @Pattern(regexp = "^[^'\";|?&=<>\\(\\)%{}\\[\\]\\/:\\-+#\\$]$") @Size(max = 100) 
  @Schema(name = "identification", example = "1720477346", description = "Identificación del cliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("identification")
  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public CustomerTransactionsCustomer customerAccount(List<@Valid CustomerTransactionsCustomerCustomerAccountInner> customerAccount) {
    this.customerAccount = customerAccount;
    return this;
  }

  public CustomerTransactionsCustomer addCustomerAccountItem(CustomerTransactionsCustomerCustomerAccountInner customerAccountItem) {
    if (this.customerAccount == null) {
      this.customerAccount = new ArrayList<>();
    }
    this.customerAccount.add(customerAccountItem);
    return this;
  }

  /**
   * Get customerAccount
   * @return customerAccount
  */
  @Valid 
  @Schema(name = "CustomerAccount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("CustomerAccount")
  public List<@Valid CustomerTransactionsCustomerCustomerAccountInner> getCustomerAccount() {
    return customerAccount;
  }

  public void setCustomerAccount(List<@Valid CustomerTransactionsCustomerCustomerAccountInner> customerAccount) {
    this.customerAccount = customerAccount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerTransactionsCustomer customerTransactionsCustomer = (CustomerTransactionsCustomer) o;
    return Objects.equals(this.name, customerTransactionsCustomer.name) &&
        Objects.equals(this.identification, customerTransactionsCustomer.identification) &&
        Objects.equals(this.customerAccount, customerTransactionsCustomer.customerAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, identification, customerAccount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerTransactionsCustomer {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    customerAccount: ").append(toIndentedString(customerAccount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

