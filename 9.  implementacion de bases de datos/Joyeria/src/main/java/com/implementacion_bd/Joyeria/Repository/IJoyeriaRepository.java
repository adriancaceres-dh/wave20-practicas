package com.implementacion_bd.Joyeria.Repository;

import com.implementacion_bd.Joyeria.Entities.Joya;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJoyeriaRepository extends JpaRepository<Joya, Integer> {
}
