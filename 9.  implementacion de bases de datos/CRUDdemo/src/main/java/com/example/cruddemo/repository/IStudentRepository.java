package com.example.cruddemo.repository;

import com.example.cruddemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {

}
