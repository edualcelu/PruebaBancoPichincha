package com.pichincha.bs.infrastructure.input.adapter.rest.mapper;

import com.pichincha.bs.domain.MovementDomain;
import com.pichincha.bs.infrastructure.output.repository.entity.MovementEntity;
import com.pichincha.services.server.models.Movement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class MovementMapperImpl implements MovementMapper {

    @Override
    public Movement MovementDomainToMovement(MovementDomain MovementDomain) {
        if ( MovementDomain == null ) {
            return null;
        }

        Movement movement = new Movement();

        movement.setId( MovementDomain.getId() );
        movement.setDate( MovementDomain.getDate() );
        movement.setType( tipoMovimientoEnumToTypeEnum( MovementDomain.getType() ) );
        movement.setAmount( MovementDomain.getAmount() );
        movement.setBalance( MovementDomain.getBalance() );
        movement.setAccountId( MovementDomain.getAccountId() );

        return movement;
    }

    @Override
    public MovementDomain MovementEntityToMovementDomain(MovementEntity MovementEntity) {
        if ( MovementEntity == null ) {
            return null;
        }

        MovementDomain movementDomain = new MovementDomain();

        movementDomain.setId( MovementEntity.getId() );
        movementDomain.setDate( MovementEntity.getDate() );
        movementDomain.setAmount( MovementEntity.getAmount() );
        movementDomain.setType( MovementEntity.getType() );
        movementDomain.setValue( MovementEntity.getValue() );
        movementDomain.setBalance( MovementEntity.getBalance() );
        movementDomain.setAccountId( MovementEntity.getAccountId() );

        return movementDomain;
    }

    @Override
    public MovementDomain MovementToMovementDomain(Movement Movement) {
        if ( Movement == null ) {
            return null;
        }

        MovementDomain movementDomain = new MovementDomain();

        movementDomain.setId( Movement.getId() );
        movementDomain.setDate( Movement.getDate() );
        movementDomain.setAmount( Movement.getAmount() );
        movementDomain.setType( typeEnumToTipoMovimientoEnum( Movement.getType() ) );
        movementDomain.setBalance( Movement.getBalance() );
        movementDomain.setAccountId( Movement.getAccountId() );

        return movementDomain;
    }

    @Override
    public MovementEntity MovementDomainToMovementEntity(MovementDomain MovementDomain) {
        if ( MovementDomain == null ) {
            return null;
        }

        MovementEntity movementEntity = new MovementEntity();

        movementEntity.setId( MovementDomain.getId() );
        movementEntity.setDate( MovementDomain.getDate() );
        movementEntity.setAmount( MovementDomain.getAmount() );
        movementEntity.setType( MovementDomain.getType() );
        movementEntity.setValue( MovementDomain.getValue() );
        movementEntity.setBalance( MovementDomain.getBalance() );
        movementEntity.setAccountId( MovementDomain.getAccountId() );

        return movementEntity;
    }

    @Override
    public List<Movement> ListMovementDomainToMovement(List<MovementDomain> ListaMovementDomain) {
        if ( ListaMovementDomain == null ) {
            return null;
        }

        List<Movement> list = new ArrayList<Movement>( ListaMovementDomain.size() );
        for ( MovementDomain movementDomain : ListaMovementDomain ) {
            list.add( MovementDomainToMovement( movementDomain ) );
        }

        return list;
    }

    protected Movement.TypeEnum tipoMovimientoEnumToTypeEnum(MovementEntity.TipoMovimientoEnum tipoMovimientoEnum) {
        if ( tipoMovimientoEnum == null ) {
            return null;
        }

        Movement.TypeEnum typeEnum;

        switch ( tipoMovimientoEnum ) {
            case DEBITO: typeEnum = Movement.TypeEnum.DEBITO;
            break;
            case CREDITO: typeEnum = Movement.TypeEnum.CREDITO;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + tipoMovimientoEnum );
        }

        return typeEnum;
    }

    protected MovementEntity.TipoMovimientoEnum typeEnumToTipoMovimientoEnum(Movement.TypeEnum typeEnum) {
        if ( typeEnum == null ) {
            return null;
        }

        MovementEntity.TipoMovimientoEnum tipoMovimientoEnum;

        switch ( typeEnum ) {
            case DEBITO: tipoMovimientoEnum = MovementEntity.TipoMovimientoEnum.DEBITO;
            break;
            case CREDITO: tipoMovimientoEnum = MovementEntity.TipoMovimientoEnum.CREDITO;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + typeEnum );
        }

        return tipoMovimientoEnum;
    }
}
