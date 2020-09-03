package com.kgodlewski.app.service;

import com.kgodlewski.app.dto.ReservationRequest;
import com.kgodlewski.app.entities.Reservation;


public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
