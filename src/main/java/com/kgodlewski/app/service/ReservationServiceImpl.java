package com.kgodlewski.app.service;

import com.kgodlewski.app.dto.ReservationRequest;
import com.kgodlewski.app.entities.Flight;
import com.kgodlewski.app.entities.Passenger;
import com.kgodlewski.app.entities.Reservation;
import com.kgodlewski.app.repository.FlightRepository;
import com.kgodlewski.app.repository.PassengerRepository;
import com.kgodlewski.app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {
    
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;
    
    @Override
    public Reservation bookFlight(ReservationRequest request) {
        //Make Payment
        request.getCardNumber();
        Long flightId = request.getFlightId();
        Optional<Flight> one = flightRepository.findById(flightId);
        if (one.isPresent()){
            Flight flight = one.get();
            Passenger passenger = new Passenger();
            passenger.setFirstname(request.getPassengerFirstName());
            passenger.setLastname(request.getPassengerLastName());
            passenger.setPhone(request.getPassengerPhone());
            passenger.setEmail(request.getPassengerEmail());
            Passenger savedPassenger = passengerRepository.save(passenger);
            Reservation reservation = new Reservation();
            reservation.setFlight(flight);
            reservation.setPassenger(passenger);
            reservation.setCheckedIn(false);
            Reservation savedReservation = reservationRepository.save(reservation);
            return savedReservation;
        }
        return null;
    }
}
