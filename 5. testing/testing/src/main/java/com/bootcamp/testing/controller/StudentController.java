package com.bootcamp.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.testing.service.Interface.IStudentService;

@RestController
@RequestMapping("student")
public class StudentController {
    
    @Autowired
    IStudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK) ;
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam String id){
        return new ResponseEntity<>( studentService.findById(id), HttpStatus.OK);
    }

    

}
