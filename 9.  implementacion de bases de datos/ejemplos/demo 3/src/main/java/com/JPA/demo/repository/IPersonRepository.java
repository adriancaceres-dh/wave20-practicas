package com.JPA.demo.repository;

import com.JPA.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IPersonRepository extends JpaRepository<Person, Integer> {

    // Una lista de personas que tengan DNI igual al parametro pasado.
    List<Person> findByDniEquals(String dni);

    @Query("SELECT c.person FROM Client c WHERE c.email = :email")
    List<Person> findByClientEmailEquals(@Param("email") String email);

    @Query("SELECT AVG(p.age) FROM Person p")
    Double calculateAverageAge();


}
