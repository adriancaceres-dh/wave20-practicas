package com.example.RelacionesJPA.repository;

import com.example.RelacionesJPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepositroy extends JpaRepository<User,Integer> {
    
}
