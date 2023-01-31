package com.example.elastic.service;

import com.example.elastic.dtos.ArticleDTO;
import org.springframework.data.domain.Pageable;

public interface IArticlesService {
  ArticleDTO getArticleByTitle(String title, Pageable pageable);
}
