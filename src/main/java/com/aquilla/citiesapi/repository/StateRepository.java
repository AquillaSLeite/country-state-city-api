package com.aquilla.citiesapi.repository;

import com.aquilla.citiesapi.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
