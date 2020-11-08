package com.aquilla.citiesapi.controller;

import com.aquilla.citiesapi.dto.DistanceResponseDto;
import com.aquilla.citiesapi.model.City;
import com.aquilla.citiesapi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/cities")
@Validated
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<Page<City>> index(final Pageable page) {
        return ResponseEntity.ok().body(this.service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.service.findById(id));
    }

    @GetMapping("/distance")
    public ResponseEntity<DistanceResponseDto> distanceBetweenTwoCities(
            @RequestParam(value = "from") @Min(1) Long from,
            @RequestParam(value = "to") @Min(1) Long to){
        return ResponseEntity.ok().body(this.service.distanceBetweenTwoCities(from, to));
    }
}
