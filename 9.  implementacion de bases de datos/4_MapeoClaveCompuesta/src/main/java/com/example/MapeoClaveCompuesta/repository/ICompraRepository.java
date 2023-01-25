package com.example.MapeoClaveCompuesta.repository;

import com.example.MapeoClaveCompuesta.model.Compra;
import com.example.MapeoClaveCompuesta.model.keys.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {
}
