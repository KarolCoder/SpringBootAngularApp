package com.kgodlewski.app.repository;

import com.kgodlewski.app.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location, Integer> {
}
