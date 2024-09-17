package com.example.les12services.repository;

import com.example.les12services.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Iterable<Teacher> findByDobBefore(LocalDate date);

//    Optional<Teacher> findByFirstNameAndLastName(String firstName, String lastName);
    boolean existsTeacherByFirstNameAndLastName(String firstName, String lastName);
}
