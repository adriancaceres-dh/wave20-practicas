package com.example.MapeoDeUnaClaveCompuesta.repositroy;

import com.example.MapeoDeUnaClaveCompuesta.entity.Compra;
import com.example.MapeoDeUnaClaveCompuesta.entity.CompraKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraRepository extends JpaRepository<Compra, CompraKey> {
}
