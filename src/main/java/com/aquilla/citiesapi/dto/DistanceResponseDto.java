package com.aquilla.citiesapi.dto;

import com.aquilla.citiesapi.model.City;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DistanceResponseDto {

    private City from;
    private City to;
    private Double distance;
}
