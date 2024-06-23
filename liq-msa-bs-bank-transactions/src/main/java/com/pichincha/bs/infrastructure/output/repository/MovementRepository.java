package com.pichincha.bs.infrastructure.output.repository;

import com.pichincha.bs.infrastructure.output.repository.entity.AccountEntity;
import com.pichincha.bs.infrastructure.output.repository.entity.MovementEntity;
import com.pichincha.services.server.models.Movement;
import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface MovementRepository extends ReactiveCrudRepository<MovementEntity, Integer> {

    @NonNull
    @Query("select m.id, m.date, m.type, m.amount, m.balance, m.accountId from movement m")
    Flux<MovementEntity> findAll();


    @Transactional
    @Query("select m.id, m.date, m.type, m.amount, m.balance, m.accountId" +
            " from movement m" +
            " where id = :id")
    Mono<MovementEntity> getById(@Param("id") Integer id);


    @Transactional
    @Query("DELETE FROM movement WHERE id = :id; ")
    Mono<Void> delete(@Param("id") Integer id);

    @NonNull
    @Transactional
    @Query(
            "UPDATE movement SET date = :#{#movementEntity.date}, type = :#{#movementEntity.type}, " +
                    " amount = :#{#movementEntity.amount}, balance= :#{#movementEntity.balance}, " +
                    " accountId = :#{#movementEntity.accountId} "+
                    " WHERE id = :#{#idPut}; "+
                    " select m.id, m.date, m.type, m.amount, m.balance, m.accountId" +
                    " from movement m" +
                    " where id = :#{#idPut};"
    )
    Mono<MovementEntity> update(@Param("idPut") Integer idPut,@Param("movementEntity") MovementEntity movementEntity);

    @Transactional
    @Query(
            "INSERT INTO movement (date, type, amount, balance, accountId)" +
                    " VALUES(:#{#movementEntity.date}, :#{#movementEntity.type}, :#{#movementEntity.amount}, " +
                    " :#{#movementEntity.balance}, :#{#movementEntity.accountId}); "+
                    " select m.id, m.date, m.type, m.amount, m.balance, m.accountId" +
                    " from movement m" +
                    " where id = SCOPE_IDENTITY()"
    )
    Mono<MovementEntity> save(@Param("movementEntity") MovementEntity movementEntity);

    @Query(
            "SELECT m.id, m.date, m.type, m.amount, m.balance, m.accountId" +
                    " FROM movement m" +
                    " WHERE m.accountId = :#{#account}" +
                    " AND m.date BETWEEN :#{#dateStart} AND :#{#dateEnd};"
    )
    Flux<MovementEntity> accountTransactionsDate(@Param("dateStart") LocalDate dateStart,
                                                 @Param("dateEnd") LocalDate dateEnd,
                                                 @Param("account") String account
                                                 );
}
