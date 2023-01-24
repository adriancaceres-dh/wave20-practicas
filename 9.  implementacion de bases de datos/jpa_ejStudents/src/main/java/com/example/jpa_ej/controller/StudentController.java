package com.example.jpa_ej.controller;

import com.example.jpa_ej.entity.Student;
import com.example.jpa_ej.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student ){
        studentService.saveStudent(student);
        return "El estudiante fue guardado";
    }
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping("/edit/{id}")
    public Student editStudent(@PathVariable Integer id, @RequestParam("name") String newName, @RequestParam("lastname") String newLastName){
        Student stu = studentService.findStudent(id);
        stu.setDireccion(newName);
        stu.setDireccion(newLastName);
        return stu;
    }
    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "El estudiante "+id+" fue eliminado";
    }
}
