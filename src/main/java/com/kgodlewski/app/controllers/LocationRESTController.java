package com.kgodlewski.app.controllers;

import com.kgodlewski.app.entities.Location;
import com.kgodlewski.app.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    @GetMapping("{id}")
    public Location getLocationsById(@PathVariable("id") int id){
        return locationRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }
    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id){
        locationRepository.deleteById(id);
    }

}
