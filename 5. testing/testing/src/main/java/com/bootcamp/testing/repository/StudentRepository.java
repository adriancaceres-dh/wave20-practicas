package com.bootcamp.testing.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.bootcamp.testing.entity.Student;

@Repository
public class StudentRepository {
    
    List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
        students.add(new Student("1","Dani1", 25));
        students.add(new Student("2","Dani2", 25));
        students.add(new Student("3","Diana", 50));
    }

    public Student findById(String id){
        Optional<Student> student = students.stream().filter(s -> s.getId().equals(id)).findFirst();
        return student.isPresent() ? student.get() : null;
    }

    public List<Student> findAll(){
        return students;
    }
}
