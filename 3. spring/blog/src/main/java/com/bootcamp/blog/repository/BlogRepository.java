package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogEntry;

import java.util.List;
import java.util.Optional;

public interface BlogRepository {
    boolean create(BlogEntry blogEntry);

    Optional<BlogEntry> get(long id);

    List<BlogEntry> listAll();
}
