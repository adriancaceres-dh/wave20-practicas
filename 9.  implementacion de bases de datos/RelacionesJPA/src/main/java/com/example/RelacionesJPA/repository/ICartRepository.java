package com.example.RelacionesJPA.repository;

import com.example.RelacionesJPA.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart,Integer> {
}
