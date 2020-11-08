package com.aquilla.citiesapi.service;

import com.aquilla.citiesapi.dto.DistanceResponseDto;
import com.aquilla.citiesapi.model.City;
import com.aquilla.citiesapi.repository.CityRepository;
import com.aquilla.citiesapi.service.exception.BusinessExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public Page<City> findAll(final Pageable page) {
        return this.repository.findAll(page);
    }

    public City findById(Long id) {
        Optional<City> model = this.repository.findById(id);
        model.orElseThrow(() -> new BusinessExceptionService("city", "not found city with id " + id, 404));
        return model.get();
    }

    public DistanceResponseDto distanceBetweenTwoCities(Long from, Long to) {
        City fromCity = this.findById(from);
        City toCity = this.findById(to);
        Double distance = this.repository.distanceByCube(fromCity.getLocation().getX(),
                                                         fromCity.getLocation().getY(),
                                                         toCity.getLocation().getX(),
                                                         toCity.getLocation().getY());
        return new DistanceResponseDto(fromCity, toCity, distance);
    }
}
