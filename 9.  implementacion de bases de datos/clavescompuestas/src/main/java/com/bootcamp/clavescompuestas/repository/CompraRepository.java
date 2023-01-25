package com.bootcamp.clavescompuestas.repository;

import com.bootcamp.clavescompuestas.model.Compra;
import com.bootcamp.clavescompuestas.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompraRepository extends JpaRepository<Compra, CompraKey> {

    List<Compra> findByClienteIdEquals(Integer id);
}
