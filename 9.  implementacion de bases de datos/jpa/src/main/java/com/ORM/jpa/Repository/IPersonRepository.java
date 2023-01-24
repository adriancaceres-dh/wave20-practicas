package com.ORM.jpa.Repository;

import com.ORM.jpa.Models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

}
