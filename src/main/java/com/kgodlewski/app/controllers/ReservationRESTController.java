package com.kgodlewski.app.controllers;

import com.kgodlewski.app.dto.ReservationUpdateRequest;
import com.kgodlewski.app.entities.Reservation;
import com.kgodlewski.app.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationRESTController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        Optional<Reservation> optReservation = reservationRepository.findById(id);
        return optReservation.orElse(null);
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Optional<Reservation> optReservation = reservationRepository.findById(request.getId());
        if(optReservation.isPresent()){
            Reservation reservation = optReservation.get();
            reservation.setNumberOfBags(request.getNumberOfBags());
            reservation.setCheckedIn(request.getCheckedIn());
            return reservationRepository.save(reservation);
        }

        return null;
    }
}
