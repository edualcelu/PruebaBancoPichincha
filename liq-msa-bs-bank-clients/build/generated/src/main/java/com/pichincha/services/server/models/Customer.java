package com.pichincha.services.server.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Customer
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-23T13:28:31.646116600-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
public class Customer implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String password;

  private String status;

  private String name;

  private String gender;

  private Integer age;

  private String identification;

  private String address;

  private String phone;

  public Customer() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Customer(String password, String status, Integer id, String name, String gender, Integer age, String identification, String address, String phone) {
    this.password = password;
    this.status = status;
    this.name = name;
    this.gender = gender;
    this.age = age;
    this.identification = identification;
    this.address = address;
    this.phone = phone;
  }

  public Customer id(Integer id) {
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

  public Customer password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @NotNull @Pattern(regexp = "^[^'\";|?&=<>\\(\\)%{}\\[\\]\\/:\\-+#\\$]*$") @Size(max = 100) 
  @Schema(name = "password", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Customer status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Size(max = 100) 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Customer name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Customer gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @NotNull 
  @Schema(name = "gender", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Customer age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  */
  @NotNull 
  @Schema(name = "age", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("age")
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Customer identification(String identification) {
    this.identification = identification;
    return this;
  }

  /**
   * Get identification
   * @return identification
  */
  @NotNull 
  @Schema(name = "identification", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("identification")
  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  public Customer address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @NotNull 
  @Schema(name = "address", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Customer phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @NotNull 
  @Schema(name = "phone", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.id, customer.id) &&
        Objects.equals(this.password, customer.password) &&
        Objects.equals(this.status, customer.status) &&
        Objects.equals(this.name, customer.name) &&
        Objects.equals(this.gender, customer.gender) &&
        Objects.equals(this.age, customer.age) &&
        Objects.equals(this.identification, customer.identification) &&
        Objects.equals(this.address, customer.address) &&
        Objects.equals(this.phone, customer.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, password, status, name, gender, age, identification, address, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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

