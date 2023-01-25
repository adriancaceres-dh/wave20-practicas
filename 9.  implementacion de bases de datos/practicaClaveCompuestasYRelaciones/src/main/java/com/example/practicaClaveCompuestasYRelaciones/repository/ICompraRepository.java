package com.example.practicaClaveCompuestasYRelaciones.repository;

import com.example.practicaClaveCompuestasYRelaciones.model.Compra;
import com.example.practicaClaveCompuestasYRelaciones.model.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {
}
