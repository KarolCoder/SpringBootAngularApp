package com.kgodlewski.app.repository;

import com.kgodlewski.app.entities.Student;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<Student, Long> {



}
