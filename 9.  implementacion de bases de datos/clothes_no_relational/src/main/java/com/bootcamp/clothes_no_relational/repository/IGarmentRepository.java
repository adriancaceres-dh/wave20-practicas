package com.bootcamp.clothes_no_relational.repository;

import com.bootcamp.clothes_no_relational.domain.Garment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IGarmentRepository extends ElasticsearchRepository<Garment, Long> {

    List<Garment> findBySizeEquals(String size);
    List<Garment> findByNameContaining(String term);
}
