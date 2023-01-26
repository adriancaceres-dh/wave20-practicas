package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

    @Modifying
    @Query("update Person p set p.eliminado = true where p.id = :id")
    void logicDelete(@Param("id") Integer id);
}
