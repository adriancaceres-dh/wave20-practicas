package com.example.practicaConElasticsearch.repository;

import com.example.practicaConElasticsearch.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IArticuloRepository extends ElasticsearchRepository<Articulo,String> {
}
