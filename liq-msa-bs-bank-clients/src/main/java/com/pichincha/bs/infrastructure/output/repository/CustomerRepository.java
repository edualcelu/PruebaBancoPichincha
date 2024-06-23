package com.pichincha.bs.infrastructure.output.repository;

import com.pichincha.bs.infrastructure.output.repository.entity.CustomerEntity;
import lombok.NonNull;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerRepository extends ReactiveCrudRepository<CustomerEntity, Integer> {
    @NonNull
    @Query("SELECT p.id, p.age, p.address, p.gender, p.identification, p.name, p.phone, c.id, c.status, c.password "+
            " FROM person p INNER JOIN customer c ON p.id = c.id")
    Flux<CustomerEntity> findAll();


    @Transactional
    @Query("SELECT p.id, p.age, p.address, p.gender, p.identification, p.name, p.phone, c.id, c.status, c.password " +
            " FROM person p INNER JOIN customer c ON p.id = c.id"+
            " WHERE p.id = :idCustomer")
    Mono<CustomerEntity> getById(@Param("idCustomer") String idCustomer);
    @Transactional
    @Query("DELETE FROM customer WHERE id = :idDelete; " +
            " DELETE FROM person WHERE id = :idDelete")
    Mono<Void> delete(@Param("idDelete") String idDelete);

    @NonNull
    @Transactional
    @Query(
            "UPDATE person SET age = :#{#customerEntity.age}, address = :#{#customerEntity.address}, gender = :#{#customerEntity.gender}, identification= :#{#customerEntity.identification}, name = :#{#customerEntity.name}, phone = :#{#customerEntity.phone} "+
                    " WHERE id = :#{#idPut}; "+

                    "UPDATE customer SET password = :#{#customerEntity.password}, status = :#{#customerEntity.status} WHERE id = (SELECT id FROM person WHERE id = :#{#idPut}) "+

                    "SELECT p.id, p.age, p.address, p.gender, p.identification, p.name, p.phone, c.id, c.status, c.password"+
                    " FROM person p INNER JOIN customer c ON p.id = c.id WHERE p.id = :#{#idPut};"

    )
    Mono<CustomerEntity> update(@Param("idPut") String idPut,@Param("customerEntity") CustomerEntity customerEntity);

    @NonNull
    @Transactional
    @Query(
            "INSERT INTO person(age, address, gender, identification, name, phone)" +
                    " VALUES(:#{#customerEntity.age}, :#{#customerEntity.address}, :#{#customerEntity.gender}, :#{#customerEntity.identification}, :#{#customerEntity.name}, :#{#customerEntity.phone}); "+

                    "INSERT INTO customer(id, status, password)"+
                    " VALUES(SCOPE_IDENTITY(), :#{#customerEntity.status}, :#{#customerEntity.password});"+

                    "SELECT top(1) p.id, p.age, p.address, p.gender, p.identification, p.name, p.phone, c.id, c.status, c.password " +
                    "FROM person p INNER JOIN customer c ON p.id = c.id WHERE p.identification = :#{#customerEntity.identification}" +
                    " ORDER BY p.id DESC"
    )
    Mono<CustomerEntity> save(@Param("customerEntity") CustomerEntity customerEntity);

}
