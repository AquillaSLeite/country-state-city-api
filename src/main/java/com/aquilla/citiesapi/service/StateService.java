package com.aquilla.citiesapi.service;

import com.aquilla.citiesapi.model.State;
import com.aquilla.citiesapi.repository.StateRepository;
import com.aquilla.citiesapi.service.exception.BusinessExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public Page<State> findAll(final Pageable page) {
        return this.repository.findAll(page);
    }

    public State findById(Long id) {
        Optional<State> model = this.repository.findById(id);
        model.orElseThrow(() -> new BusinessExceptionService("state", "not found state with id " + id, 404));
        return model.get();
    }
}
