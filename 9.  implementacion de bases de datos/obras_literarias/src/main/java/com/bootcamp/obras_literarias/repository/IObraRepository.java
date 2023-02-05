package com.bootcamp.obras_literarias.repository;

import com.bootcamp.obras_literarias.domain.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraRepository extends ElasticsearchRepository<Obra, Long> {

    List<Obra> findAllByAutor(String autor);

    List<Obra> findAllByNombreContaining(String palabra);

    List<Obra> findAllByPublicacionAfter(Integer publicacion);

    List<Obra> findAllByPublicacionBefore(Integer publicacion);

    List<Obra> findAllByEditorial(String editorial);
}
