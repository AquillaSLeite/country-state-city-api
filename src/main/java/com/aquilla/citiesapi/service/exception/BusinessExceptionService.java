package com.aquilla.citiesapi.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BusinessExceptionService extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -5268780796339184923L;

    private String field;
    private String error;
    private Integer code;
}
