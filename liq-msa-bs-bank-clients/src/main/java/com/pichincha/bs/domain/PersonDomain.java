package com.pichincha.bs.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDomain {
    private Integer id;

    private String name;

    private String gender;

    private Integer age;

    private String identification;

    private String address;

    private String phone;
}
