package com.example.RelacionesJPA.repository;

import com.example.RelacionesJPA.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepositroy extends JpaRepository<Course,Integer> {

}
