package com.bootcamp.showroom_elastic.elastic_respositories;

import com.bootcamp.showroom_elastic.model.Sell;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSellRepository extends ElasticsearchRepository<Sell, String> {
}
