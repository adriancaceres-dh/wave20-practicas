package com.example.ejerciciosPracticosEmpleadosYProductos.Repository;

import com.example.ejerciciosPracticosEmpleadosYProductos.Domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IArticuloRepository extends ElasticsearchRepository<Articulo,String> {
}