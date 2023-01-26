package com.bootcamp.showroom_elastic.elastic_respositories;

import com.bootcamp.showroom_elastic.model.Clothing;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticClothingRepository extends ElasticsearchRepository<Clothing, String> {
    List<Clothing> findAll();
}
