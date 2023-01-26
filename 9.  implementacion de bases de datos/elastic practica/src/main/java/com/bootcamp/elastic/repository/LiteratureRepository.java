package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
/*    @Override
    List<Literature> findAll();*/

    public List<Literature> findByAuthor(String author);

    public List<Literature> findByTitleContains(String title);

    public List<Literature> findByCantPagesGreaterThan(Integer cantPages);

}
