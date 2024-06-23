package com.pichincha.bs.infrastructure.input.adapter.rest.impl;

import com.pichincha.bs.domain.MovementDomain;
import com.pichincha.bs.infrastructure.output.repository.entity.MovementEntity;
import com.pichincha.services.server.models.Movement;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class MovementControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    //test de Intergracion
    @Test
    public void testPostMovement() {
        Movement movement = new Movement();
        movement.setBalance(BigDecimal.valueOf(500.00));
        //movement.setId(100);
        movement.setType(Movement.TypeEnum.CREDITO);
        movement.setAmount(BigDecimal.valueOf(1));
        movement.setDate(LocalDate.parse("2025-12-12"));
        movement.setAccountId("5");
        webTestClient.post()
                .uri("/business-transactions/celula/v1/movement")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(movement)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                //.jsonPath("$.id").isNotEmpty()
                .jsonPath("$.date").isEqualTo("2025-12-12");
    }
}