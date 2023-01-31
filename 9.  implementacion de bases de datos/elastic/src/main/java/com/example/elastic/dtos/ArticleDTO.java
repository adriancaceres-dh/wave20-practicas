package com.example.elastic.dtos;

import com.example.elastic.domain.Author;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {
  private String id;
  private String title;
  private List<Author> authors;
  private String[] tags;
}
