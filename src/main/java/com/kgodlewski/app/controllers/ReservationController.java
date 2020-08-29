package com.kgodlewski.app.controllers;

import com.kgodlewski.app.entities.Flight;
import com.kgodlewski.app.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {
    
    @Autowired
    FlightRepository flightRepository;
    
    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap modelMap){
        Optional<Flight> optional = flightRepository.findById(flightId);
        if(optional.isPresent()) {
            Flight flight = optional.get();
            modelMap.addAttribute("flight", flight);
        }
        return "completeReservation";
    }
    
}
