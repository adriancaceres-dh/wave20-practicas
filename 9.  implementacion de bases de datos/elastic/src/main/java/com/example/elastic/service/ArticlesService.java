package com.example.elastic.service;

import com.example.elastic.dtos.ArticleDTO;
import com.example.elastic.repositories.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticlesService implements IArticlesService {

  private final ArticleRepository articleRepository;
  private final ModelMapper modelMapper = new ModelMapper();

  public ArticlesService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  @Override
  public ArticleDTO getArticleByTitle(String title, Pageable pageable) {
    return modelMapper.map(articleRepository.findArticleByTitle(title, pageable), ArticleDTO.class);
  }
}
