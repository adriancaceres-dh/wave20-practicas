package com.example.blog.repository;

import com.example.blog.model.BlogEntry;

import java.util.List;

public interface BlogEntryRepositoryInterface {
    BlogEntry getBlogEntryById(Long id);
    Long addBlogEntry(BlogEntry blogEntry);
    List<BlogEntry> getBlogEntries();
    Boolean exists(Long id);
}
