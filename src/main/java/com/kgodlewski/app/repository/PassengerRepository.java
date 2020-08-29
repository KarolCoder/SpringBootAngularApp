package com.kgodlewski.app.repository;

import com.kgodlewski.app.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
