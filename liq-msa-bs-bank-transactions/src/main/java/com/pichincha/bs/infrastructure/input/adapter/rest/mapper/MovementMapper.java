package com.pichincha.bs.infrastructure.input.adapter.rest.mapper;

import com.pichincha.bs.domain.MovementDomain;
import com.pichincha.bs.infrastructure.output.repository.entity.MovementEntity;
import com.pichincha.services.server.models.Movement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MovementMapper {
    //read
    Movement MovementDomainToMovement(MovementDomain MovementDomain);
    MovementDomain MovementEntityToMovementDomain(MovementEntity MovementEntity);

    //Insert
    MovementDomain MovementToMovementDomain (Movement Movement);

    MovementEntity MovementDomainToMovementEntity (MovementDomain MovementDomain);

    List<Movement> ListMovementDomainToMovement(List<MovementDomain> ListaMovementDomain);
}
