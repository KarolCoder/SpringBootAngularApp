package com.kgodlewski.app.repository;

import com.kgodlewski.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
