package com.kgodlewski.app.repositories;

import com.kgodlewski.app.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
