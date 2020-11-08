package com.aquilla.citiesapi.controller.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    private Instant timestamp;
    @Getter
    private Integer status;
    @Getter
    private String path;
    @Getter
    private String expcetionName;
    @Getter
    @Setter
    private Map<String, String> errors = new HashMap<>();

    public StandardError(Instant timestamp, Integer status, String path, String expcetionName) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.path = path;
        this.expcetionName = expcetionName;
    }
}
