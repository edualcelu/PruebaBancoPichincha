package com.pichincha.bs.infrastructure.output.adapter;

import com.pichincha.bs.application.output.port.MovementOutputPort;
import com.pichincha.bs.domain.AccountDomain;
import com.pichincha.bs.domain.MovementDomain;
import com.pichincha.bs.infrastructure.input.adapter.rest.mapper.MovementMapper;
import com.pichincha.bs.infrastructure.output.repository.MovementRepository;
import com.pichincha.bs.infrastructure.output.repository.entity.AccountEntity;
import com.pichincha.bs.infrastructure.output.repository.entity.MovementEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
public class MovementAdapter implements MovementOutputPort {

    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private MovementMapper movementMapper;
    @Override
    public Flux<MovementDomain> findAll() {
        return movementRepository.findAll().map(movementMapper::MovementEntityToMovementDomain);
    }
    public MovementDomain MovementEntityToMovementDomain(MovementEntity accountEntity){
        System.out.print("");
        return null;
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return movementRepository.delete(id);
    }

    @Override
    public Mono<MovementDomain> getById(Integer id) {
        return movementRepository.getById(id)
                .map(movementMapper::MovementEntityToMovementDomain);
    }

    @Override
    public Mono<MovementDomain> update(Integer id, MovementDomain movementDomain) {
        return movementRepository.update(id, movementMapper.MovementDomainToMovementEntity(movementDomain)
        ).map(movementMapper::MovementEntityToMovementDomain);
    }

    @Override
    public Mono<MovementDomain> save(MovementDomain movementDomain) {
        return movementRepository.save(movementMapper.MovementDomainToMovementEntity(movementDomain)
        ).map(movementMapper::MovementEntityToMovementDomain);
    }

    @Override
    public Flux<MovementDomain> accountTransactionsDate(LocalDate dateStart, LocalDate dateEnd, String account) {
        return movementRepository.accountTransactionsDate(dateStart, dateEnd, account)
        .map(movementMapper::MovementEntityToMovementDomain);
    }
}
