package com.kgodlewski.app.controllers;

import com.kgodlewski.app.dto.ReservationRequest;
import com.kgodlewski.app.entities.Flight;
import com.kgodlewski.app.entities.Reservation;
import com.kgodlewski.app.repository.FlightRepository;
import com.kgodlewski.app.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller

public class ReservationController {

    @Autowired

    FlightRepository flightRepository;

    @Autowired

    ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")

    public String showCompleteReservation(@RequestParam("flightId")Long flightId, ModelMap modelMap) {

        Flight flight= flightRepository.findById(flightId).get();

        modelMap.addAttribute("flight", flight);

        return "completeReservation";

    }

    @RequestMapping(value="/completeReservation", method={ RequestMethod.GET})
    public String completeReservation(ReservationRequest request,ModelMap modelMap) {

        Reservation reservation=reservationService.bookFlight(request);
        String attribute = "reseervation created successfully"+reservation.getId();
        modelMap.addAttribute("msg",attribute);
        return "reservationConfirmation";

    }



}
