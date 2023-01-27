package com.bootcamp.showroom_elastic.elastic_respositories;

import com.bootcamp.showroom_elastic.model.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface ElasticSaleRepository extends ElasticsearchRepository<Sale, Long> {
    List<Sale> findAll();
}
