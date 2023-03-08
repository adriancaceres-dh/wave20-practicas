package com.bootcamp.clothes.repository;

import com.bootcamp.clothes.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
