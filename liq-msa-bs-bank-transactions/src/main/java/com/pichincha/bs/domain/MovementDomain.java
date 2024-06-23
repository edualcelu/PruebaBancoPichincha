package com.pichincha.bs.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.pichincha.bs.infrastructure.output.repository.entity.MovementEntity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
public class MovementDomain {
    private static final long serialVersionUID = 1L;


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
        public static MovementDomain.TipoMovimientoEnum fromValue(String value) {
            for (MovementDomain.TipoMovimientoEnum b : MovementDomain.TipoMovimientoEnum.values()) {
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

    private String accountId;

}
