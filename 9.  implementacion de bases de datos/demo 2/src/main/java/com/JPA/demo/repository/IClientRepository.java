package com.JPA.demo.repository;

import com.JPA.demo.entity.Client;
import com.JPA.demo.entity.Person;
import com.JPA.demo.entity.templates.CantInvoicesPerPersonTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface IClientRepository extends JpaRepository<Client, Integer>{

    List<Client> findClientByPersonDniEquals(String dni);

    List<Person> findByEmailEquals(String email);

    // No tan recomendado, hay que splitear
    @Query("SELECT c.id, SIZE(c.invoices) FROM Client c")
    List<String> calculateCantInvoicesPerPerson1();

    // No tan recomendado si no queres trabajar con mapas y entryset

    @Query("SELECT new map(c.id as id, SIZE(c.invoices) as cant) FROM Client c")
    List<Map<String, Number>> calculateCantInvoicesPerPerson2();

    // La forma mas recomendad con un template, facil de consultar
    @Query("SELECT new com.JPA.demo.entity.templates.CantInvoicesPerPersonTemplate(c.id, SIZE(c.invoices)) FROM Client c")
    List<CantInvoicesPerPersonTemplate> calculateCantInvoicesPerPerson3();
}
