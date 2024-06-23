package com.pichincha.bs.application.service;

import com.pichincha.bs.application.input.port.MovementInputPort;
import com.pichincha.bs.application.output.port.AccountOutputPort;
import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.domain.MovementDomain;
import com.pichincha.bs.infrastructure.output.repository.entity.MovementEntity;
import io.r2dbc.mssql.util.Assert;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class MovementServiceTest {



    @Mock
    private AccountOutputPort accountOutputPort;
    @InjectMocks
    private MovementService movementService;

    public MovementDomain movementDomain;
    public AccountDomain accountDomain;
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
       // when(accountOutputPort.getById("1")).thenReturn(Mono.just(new AccountDomain("1", BigDecimal.valueOf(1000.00))));
    }
    //testUnitario
    @Test
    void findAll() {
        movementDomain = new MovementDomain();
        movementDomain.setBalance(BigDecimal.valueOf(500.00));
        movementDomain.setId(1);
        movementDomain.setType(MovementEntity.TipoMovimientoEnum.valueOf("CREDITO"));
        movementDomain.setDate(LocalDate.parse("2025-12-12"));
        movementDomain.setAccountId("1");

        accountDomain = new AccountDomain();
        accountDomain.setId(1);
        accountDomain.setType("AHORROS");
        accountDomain.setCustomerId("1");
        accountDomain.setStatus(true);



        when(accountOutputPort.getById("1"))
                .thenReturn(Mono.just(accountDomain));
        Mono<MovementDomain> testFind = movementService.save(movementDomain);
        Assert.isTrue(testFind != null,"Error al validar");
    }


}