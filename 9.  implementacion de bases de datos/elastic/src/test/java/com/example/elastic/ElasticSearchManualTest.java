package com.example.elastic;
import static java.util.Arrays.asList;
import static org.elasticsearch.index.query.Operator.AND;
import static org.elasticsearch.index.query.QueryBuilders.fuzzyQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.regexpQuery;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.example.elastic.config.Config;
import com.example.elastic.domain.Article;
import com.example.elastic.domain.Author;
import com.example.elastic.repositories.ArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.test.context.ContextConfiguration;

/**
 * This Manual test requires: Elasticsearch instance running on localhost:9200.
 * The following docker command can be used: docker run -d --name es762 -p
 * 9200:9200 -e "discovery.type=single-node" elasticsearch:7.6.2
 */
@ContextConfiguration(classes = Config.class)
@SpringBootTest
class ElasticSearchManualTest {

  @Autowired
  private ElasticsearchOperations elasticsearchOperations;

  @Autowired
  private ArticleRepository articleRepository;

  private final Author johnSmith = new Author("John Smith");
  private final Author johnDoe = new Author("John Doe");


  @BeforeEach
  public void setUp() {
    Article article = new Article("Spring Data Elasticsearch");
    article.setAuthors(asList(johnSmith, johnDoe));
    article.setTags("elasticsearch", "spring data");
    articleRepository.save(article);

    article = new Article("Search engines");
    article.setAuthors(List.of(johnDoe));
    article.setTags("search engines", "tutorial");
    articleRepository.save(article);

    article = new Article("Second Article About Elasticsearch");
    article.setAuthors(List.of(johnSmith));
    article.setTags("elasticsearch", "spring data");
    articleRepository.save(article);

    article = new Article("Elasticsearch Tutorial");
    article.setAuthors(List.of(johnDoe));
    article.setTags("elasticsearch");
    articleRepository.save(article);
  }

  @AfterEach
  public void tearDown() {
    articleRepository.deleteAll();
  }

  @Test
  void givenArticleService_whenSaveArticle_thenIdIsAssigned() {
    final List<Author> authors = asList(johnSmith, johnDoe);

    Article article = new Article("Making Search Elastic");
    article.setAuthors(authors);

    article = articleRepository.save(article);
    assertNotNull(article.getId());
  }

  @Test
  void givenPersistedArticles_whenSearchByAuthorsName_thenRightFound() {
      final Page<Article> articleByAuthorName = articleRepository.findArticleByAuthorsName(johnSmith.getName(), PageRequest.of(0, 10));
    assertEquals(2L, articleByAuthorName.getTotalElements());
  }

  @Test
  void givenPersistedArticles_whenSearchByTitle_thenRightFound() {
    String title = "Elasticsearch Tutorial";
    final Page<Article> articleByTitle = articleRepository.findArticleByTitle(title, PageRequest.of(0, 10));
    assertEquals(1L, articleByTitle.getTotalElements());
  }

  @Test
  void givenCustomQuery_whenSearchByAuthorsName_thenArticleIsFound() {
    final Page<Article> articleByAuthorName = articleRepository.findByAuthorsNameUsingCustomQuery("Smith", PageRequest.of(0, 10));
    assertEquals(2L, articleByAuthorName.getTotalElements());
  }

  @Test
  void givenTagFilterQuery_whenSearchByTag_thenArticleIsFound() {
    final Page<Article> articleByAuthorName = articleRepository.findByFilteredTagQuery("elasticsearch", PageRequest.of(0, 10));
    assertEquals(3L, articleByAuthorName.getTotalElements());
  }

  @Test
  void givenTagFilterQuery_whenSearchByAuthorsName_thenArticleIsFound() {
    final Page<Article> articleByAuthorName = articleRepository.findByAuthorsNameAndFilteredTagQuery("Doe", "elasticsearch", PageRequest.of(0, 10));
    assertEquals(2L, articleByAuthorName.getTotalElements());
  }

  @Test
  void givenPersistedArticles_whenUseRegexQuery_thenRightArticlesFound() {
    final Query searchQuery = new NativeSearchQueryBuilder().withFilter(regexpQuery("title", ".*data.*"))
            .build();

    final SearchHits<Article> articles = elasticsearchOperations.search(searchQuery, Article.class, IndexCoordinates.of("blog"));

    assertEquals(1, articles.getTotalHits());
  }

  @Test
  void givenSavedDoc_whenTitleUpdated_thenCouldFindByUpdatedTitle() {
    final Query searchQuery = new NativeSearchQueryBuilder().withQuery(fuzzyQuery("title", "serch"))
            .build();
    final SearchHits<Article> articles = elasticsearchOperations.search(searchQuery, Article.class, IndexCoordinates.of("blog"));

    assertEquals(1, articles.getTotalHits());

    final Article article = articles.getSearchHit(0)
            .getContent();
    final String newTitle = "Getting started with Search Engines";
    article.setTitle(newTitle);
    articleRepository.save(article);


    assertEquals(newTitle, articleRepository.findById(article.getId())
            .get()
            .getTitle());
  }

  @Test
  void givenSavedDoc_whenDelete_thenRemovedFromIndex() {
    final String articleTitle = "Spring Data Elasticsearch";

    final Query searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("title", articleTitle).minimumShouldMatch("75%"))
            .build();
    final SearchHits<Article> articles = elasticsearchOperations.search(searchQuery, Article.class, IndexCoordinates.of("blog"));

    assertEquals(1, articles.getTotalHits());
    final long count = articleRepository.count();

    articleRepository.delete(articles.getSearchHit(0)
            .getContent());

    assertEquals(count - 1, articleRepository.count());
  }

  @Test
  void givenSavedDoc_whenOneTermMatches_thenFindByTitle() {
    final Query searchQuery = new NativeSearchQueryBuilder().withQuery(matchQuery("title", "Search engines").operator(AND))
            .build();
    final SearchHits<Article> articles = elasticsearchOperations.search(searchQuery, Article.class, IndexCoordinates.of("blog"));
    assertEquals(1, articles.getTotalHits());
  }
}