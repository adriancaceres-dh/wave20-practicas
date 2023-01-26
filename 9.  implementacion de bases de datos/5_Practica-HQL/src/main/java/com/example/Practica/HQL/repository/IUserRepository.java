package com.example.Practica.HQL.repository;

import com.example.Practica.HQL.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {

}
