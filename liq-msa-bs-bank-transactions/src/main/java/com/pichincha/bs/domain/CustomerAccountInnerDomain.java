package com.pichincha.bs.domain;

import com.pichincha.services.server.models.Account;
import com.pichincha.services.server.models.Movement;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CustomerAccountInnerDomain {

    private static final long serialVersionUID = 1L;

    private Account account;

    private List<Movement> movements;
}
