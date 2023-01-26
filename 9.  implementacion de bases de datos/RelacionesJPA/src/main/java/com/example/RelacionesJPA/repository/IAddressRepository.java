package com.example.RelacionesJPA.repository;

import com.example.RelacionesJPA.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address,Integer> {
}
