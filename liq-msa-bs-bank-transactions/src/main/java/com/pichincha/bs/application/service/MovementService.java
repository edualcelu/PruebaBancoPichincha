package com.pichincha.bs.application.service;

import com.pichincha.bs.application.input.port.MovementInputPort;
import com.pichincha.bs.application.output.port.AccountOutputPort;
import com.pichincha.bs.application.output.port.MovementOutputPort;
import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.domain.MovementDomain;
import com.pichincha.bs.infrastructure.exception.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class MovementService implements MovementInputPort {
    @Autowired
    private MovementOutputPort movementOutputPort;

    @Autowired
    private AccountOutputPort accountOutputPort;

    @Override
    public Flux<MovementDomain> findAll() {
        return movementOutputPort.findAll();
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return movementOutputPort.delete(id);
    }

    @Override
    public Mono<MovementDomain> getById(Integer id) {
        return movementOutputPort.getById(id);
    }

    @Override
    public Mono<MovementDomain> update(Integer id, MovementDomain movementDomain) {
        return movementOutputPort.update(id, movementDomain);
    }


    @Override
    public Mono<MovementDomain> save(MovementDomain movementDomain) {
        return accountOutputPort.getById(movementDomain.getAccountId())
                .switchIfEmpty(Mono.error(new TransactionException("Account not found")))
                .flatMap(account -> {
                    // Validar que el monto de la transacción no exceda el saldo disponible
                    BigDecimal nuevoSaldo = account.getInitialBalance().add(movementDomain.getAmount());

                    if (nuevoSaldo.signum() < 0) {
                        return Mono.error(new TransactionException("The transaction amount exceeds the available balance"));
                    }else{
                        movementDomain.setBalance(nuevoSaldo);
                    }

                    // Guardar la transacción y actualizar el saldo de la cuenta en una sola operación reactiva
                    return movementOutputPort.save(movementDomain)
                            .doOnNext(t -> {
                                //BigDecimal nuevoSaldo = account.getInitialBalance().subtract(movementDomain.getAmount().abs());
                                account.setInitialBalance(nuevoSaldo);
                                accountOutputPort.update(account.getId().toString(), account).subscribe(); // Actualizar saldo de la cuenta
                            });
                });
    }

    @Override
    public Flux<MovementDomain> accountTransactionsDate(LocalDate dateStart, LocalDate dateEnd, String account) {
        return movementOutputPort.accountTransactionsDate(dateStart, dateEnd, account);
    }
}
