package com.pichincha.bs.infrastructure.output.repository;

import com.pichincha.bs.infrastructure.output.repository.entity.AccountEntity;
import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<AccountEntity, Integer> {

    @NonNull
    @Query("Select a.id, a.number, a.type, a.initialBalance, a.status,a.customerId from account a")
    Flux<AccountEntity> findAll();


    @Transactional
    @Query("Select top(1) a.id, a.number, a.type, a.initialBalance, a.status,a.customerId" +
            " from account a" +
            " where id = :id")
    Mono<AccountEntity> getById(@Param("id") String id);

    @Transactional
    @Query("DELETE FROM account WHERE id = :idDelete; ")
    Mono<Void> delete(@Param("idDelete") String idDelete);

    @NonNull
    @Transactional
    @Query(
            "UPDATE account SET number = :#{#accountEntity.number}, type = :#{#accountEntity.type}, " +
                    " initialBalance = :#{#accountEntity.initialBalance}, status= :#{#accountEntity.status}, " +
                    " customerId = :#{#accountEntity.customerId} "+
                    " WHERE id = :#{#idPut}; "+
                    " Select top(1) a.id, a.number, a.type, a.initialBalance, a.status,a.customerId" +
                    " from account a" +
                    " where id = :idPut"
    )
    Mono<AccountEntity> update(@Param("idPut") String idPut,@Param("accountEntity") AccountEntity accountEntity);

    @NonNull
    @Transactional
    @Query(
            "INSERT INTO account(number, type, initialBalance, status, customerId)" +
                    " VALUES(:#{#accountEntity.number}, :#{#accountEntity.type}, :#{#accountEntity.initialBalance}, " +
                    " :#{#accountEntity.status}, :#{#accountEntity.customerId}); "+
                    " Select top(1) a.id, a.number, a.type, a.initialBalance, a.status,a.customerId" +
                    " from account a" +
                    " where number = SCOPE_IDENTITY()"
    )
    Mono<AccountEntity> save(@Param("accountEntity") AccountEntity accountEntity);


    //@Transactional
    @Query("Select a.id, a.number, a.type, a.initialBalance, a.status,a.customerId" +
            " from account a" +
            " where customerId = :id")
    Flux<AccountEntity> getByIdCustomer(@Param("id") String id);

}
