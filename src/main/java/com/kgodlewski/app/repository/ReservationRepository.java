package com.kgodlewski.app.repository;

import com.kgodlewski.app.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
