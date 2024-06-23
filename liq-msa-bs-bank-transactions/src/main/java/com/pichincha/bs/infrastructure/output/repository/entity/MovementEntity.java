package com.pichincha.bs.infrastructure.output.repository.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pichincha.bs.domain.MovementDomain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "movement")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MovementEntity {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    private BigDecimal amount;
    public enum TipoMovimientoEnum {
        DEBITO("debito"),

        CREDITO("credito");


        private String value;

        TipoMovimientoEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static MovementEntity.TipoMovimientoEnum fromValue(String value) {
            for (MovementEntity.TipoMovimientoEnum b : MovementEntity.TipoMovimientoEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private MovementEntity.TipoMovimientoEnum type;

    private BigDecimal value;

    private BigDecimal balance;
    @Column("accountId")
    private String accountId;

}
