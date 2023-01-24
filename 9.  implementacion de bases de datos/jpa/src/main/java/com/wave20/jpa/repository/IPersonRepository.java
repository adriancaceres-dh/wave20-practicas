package com.wave20.jpa.repository;

import com.wave20.jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Integer> {
}
