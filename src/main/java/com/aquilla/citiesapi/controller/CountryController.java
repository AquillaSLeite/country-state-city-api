package com.aquilla.citiesapi.controller;

import com.aquilla.citiesapi.model.Country;
import com.aquilla.citiesapi.service.CountryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping
    public ResponseEntity<Page<Country>> index(final Pageable page) {
        return ResponseEntity.ok().body(this.service.findAll(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.service.findById(id));
    }
}
