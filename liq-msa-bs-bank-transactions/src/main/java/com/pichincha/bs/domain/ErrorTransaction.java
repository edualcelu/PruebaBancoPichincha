package com.pichincha.bs.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class ErrorTransaction {

    private static final long serialVersionUID = 1L;
    private String error;
    private String message;
}
