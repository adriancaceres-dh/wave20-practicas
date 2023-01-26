package com.example.elasticBaseConfigTest.repository;

import com.example.elasticBaseConfigTest.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo, String> {
    Articulo findArticuloByTituloEquals(String titulo);
}
