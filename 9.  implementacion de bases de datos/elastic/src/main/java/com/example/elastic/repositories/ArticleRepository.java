package com.example.elastic.repositories;

import com.example.elastic.domain.Article;
import com.example.elastic.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {

  Page<Article> findArticleByTitle(String name, Pageable pageable);
  @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name.keyword\": \"?0\"}}]}}")

  Page<Article> findArticleByAuthorsName(String author, Pageable pageable);

  @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
  Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);

  @Query("{\"bool\": {\"must\": {\"match_all\": {}}, \"filter\": {\"term\": {\"tags\": \"?0\" }}}}")
  Page<Article> findByFilteredTagQuery(String tag, Pageable pageable);

  @Query("{\"bool\": {\"must\": {\"match\": {\"authors.name\": \"?0\"}}, \"filter\": {\"term\": {\"tags\": \"?1\" }}}}")
  Page<Article> findByAuthorsNameAndFilteredTagQuery(String name, String tag, Pageable pageable);
}
