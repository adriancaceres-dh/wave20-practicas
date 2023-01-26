package com.example.RelacionesJPA.repository;

import com.example.RelacionesJPA.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepositroy extends JpaRepository<Item,Integer> {
}
