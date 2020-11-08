package com.aquilla.citiesapi.service;

import com.aquilla.citiesapi.model.Country;
import com.aquilla.citiesapi.repository.CountryRepository;
import com.aquilla.citiesapi.service.exception.BusinessExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Page<Country> findAll(final Pageable page) {
        return this.repository.findAll(page);
    }

    public Country findById(Long id) {
        Optional<Country> model = this.repository.findById(id);
        model.orElseThrow(() -> new BusinessExceptionService("country", "not found country with id " + id, 404));
        return model.get();
    }
}
