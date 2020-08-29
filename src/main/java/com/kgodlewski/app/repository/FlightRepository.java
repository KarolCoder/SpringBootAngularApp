package com.kgodlewski.app.repository;

import com.kgodlewski.app.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
