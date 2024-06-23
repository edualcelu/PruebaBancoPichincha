package com.pichincha.services.server.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pichincha.services.server.models.Account;
import com.pichincha.services.server.models.Movement;
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
 * CustomerAccountInner
 */

@JsonTypeName("CustomerAccount_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-23T15:21:26.073986-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
public class CustomerAccountInner implements Serializable {

  private static final long serialVersionUID = 1L;

  private Account account;

  @Valid
  private List<@Valid Movement> movements;

  public CustomerAccountInner account(Account account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
  */
  @Valid 
  @Schema(name = "Account", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Account")
  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public CustomerAccountInner movements(List<@Valid Movement> movements) {
    this.movements = movements;
    return this;
  }

  public CustomerAccountInner addMovementsItem(Movement movementsItem) {
    if (this.movements == null) {
      this.movements = new ArrayList<>();
    }
    this.movements.add(movementsItem);
    return this;
  }

  /**
   * Get movements
   * @return movements
  */
  @Valid 
  @Schema(name = "movements", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("movements")
  public List<@Valid Movement> getMovements() {
    return movements;
  }

  public void setMovements(List<@Valid Movement> movements) {
    this.movements = movements;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerAccountInner customerAccountInner = (CustomerAccountInner) o;
    return Objects.equals(this.account, customerAccountInner.account) &&
        Objects.equals(this.movements, customerAccountInner.movements);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account, movements);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerAccountInner {\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    movements: ").append(toIndentedString(movements)).append("\n");
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

