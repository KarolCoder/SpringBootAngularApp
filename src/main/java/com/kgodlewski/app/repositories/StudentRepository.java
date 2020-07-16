package com.kgodlewski.app.repositories;

import com.kgodlewski.app.entities.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Long> {



}
