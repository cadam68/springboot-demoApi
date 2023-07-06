package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

// http://localhost:8080/api/students
// http://localhost:8080/api/students/search/findByFirstNameAndLastName?firstName=john&lastName=smith
public interface StudentRepository extends JpaRepository<Student, Long> {

    @RestResource(path = "findByFirstNameAndLastName")
    Optional<Student> findByFirstNameContainingIgnoreCaseAndAndLastNameContainingIgnoreCase(String firstName, String lastName);
}
