package com.example.practicaImplementacionBD.repository;

import com.example.practicaImplementacionBD.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
}
