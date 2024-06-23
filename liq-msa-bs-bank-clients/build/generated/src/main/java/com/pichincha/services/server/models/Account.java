package com.pichincha.services.server.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Account
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-23T13:28:31.646116600-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
public class Account implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String number;

  private String type;

  private BigDecimal initialBalance;

  private String status;

  private String customerId;

  public Account id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Account number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Número de cuenta único (PK)
   * @return number
  */
  @Pattern(regexp = "^[^'\";|?&=<>\\(\\)%{}\\[\\]\\/:\\-+#\\$]$") @Size(max = 100) 
  @Schema(name = "number", description = "Número de cuenta único (PK)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Account type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @Pattern(regexp = "^[^'\";|?&=<>\\(\\)%{}\\[\\]\\/:\\-+#\\$]$") @Size(max = 100) 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Account initialBalance(BigDecimal initialBalance) {
    this.initialBalance = initialBalance;
    return this;
  }

  /**
   * Get initialBalance
   * @return initialBalance
  */
  @Valid 
  @Schema(name = "initialBalance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("initialBalance")
  public BigDecimal getInitialBalance() {
    return initialBalance;
  }

  public void setInitialBalance(BigDecimal initialBalance) {
    this.initialBalance = initialBalance;
  }

  public Account status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Pattern(regexp = "^[^'\";|?&=<>\\(\\)%{}\\[\\]\\/:\\-+#\\$]$") @Size(max = 100) 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Account customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @Pattern(regexp = "^[^'\";|?&=<>\\(\\)%{}\\[\\]\\/:\\-+#\\$]$") @Size(max = 100) 
  @Schema(name = "customerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerId")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.id, account.id) &&
        Objects.equals(this.number, account.number) &&
        Objects.equals(this.type, account.type) &&
        Objects.equals(this.initialBalance, account.initialBalance) &&
        Objects.equals(this.status, account.status) &&
        Objects.equals(this.customerId, account.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, type, initialBalance, status, customerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    initialBalance: ").append(toIndentedString(initialBalance)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
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

