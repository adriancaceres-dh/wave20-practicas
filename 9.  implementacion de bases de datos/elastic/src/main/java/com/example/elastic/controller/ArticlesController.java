package com.example.elastic.controller;

import com.example.elastic.dtos.ArticleDTO;
import com.example.elastic.service.IArticlesService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

  private final IArticlesService articlesService;
  private Pageable pageable =  PageRequest.of(0, 10);

  public ArticlesController(IArticlesService articlesService) {
    this.articlesService = articlesService;
  }

  @GetMapping("/{title}")
  public ResponseEntity<ArticleDTO> getArticleByTitle(@PathVariable String title) {
    return ResponseEntity.ok(articlesService.getArticleByTitle(title, pageable));
  }
}
