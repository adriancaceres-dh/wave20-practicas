package com.example.demo.repository;

import com.example.demo.model.Person;
import com.example.demo.model.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IPersonRepository extends JpaRepository<Person, Integer> {

    @Modifying
    @Query("update Person p set p.eliminado = true where p.id = :id")
    void logicDelete(@Param("id") Integer id);

    //Prueba método nombrado
    List<Person> findByNombre(@Param("nombre") String nombre);
}
