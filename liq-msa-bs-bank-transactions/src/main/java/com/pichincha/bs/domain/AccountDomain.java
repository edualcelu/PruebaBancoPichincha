package com.pichincha.bs.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class AccountDomain {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String number;

    private String type;

    private BigDecimal initialBalance;

    private Boolean status;

    private String customerId;


}
