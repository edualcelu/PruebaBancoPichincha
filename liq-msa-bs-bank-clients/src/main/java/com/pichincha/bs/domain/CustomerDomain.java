package com.pichincha.bs.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDomain extends PersonDomain {
    private String password;
    private String status;

}