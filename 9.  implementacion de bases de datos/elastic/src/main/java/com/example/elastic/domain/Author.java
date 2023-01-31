package com.example.elastic.domain;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Objects;

public class Author {

  @Field(type = FieldType.Keyword)
  private String name;

  public Author() {
  }

  public Author(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Author{" + "name='" + name + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Author author = (Author) o;

    return Objects.equals(name, author.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
