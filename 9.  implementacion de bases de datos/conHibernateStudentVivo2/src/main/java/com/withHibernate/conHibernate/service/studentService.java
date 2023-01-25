package com.withHibernate.conHibernate.service;

import org.springframework.stereotype.Service;
import com.withHibernate.conHibernate.repository.StudentRepository;

@Service
public class studentService {

    private final StudentRepository stuRepo;


    public studentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;
    }
}
