package com.example.blog.repository;

import com.example.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogEntryRepositoryImpl implements BlogEntryRepositoryInterface {

    private final List<BlogEntry> blogEntries = new ArrayList<>();

    @Override
    public BlogEntry getBlogEntryById(Long id) {
        return blogEntries.stream()
                .filter(b -> b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Long addBlogEntry(BlogEntry blogEntry) {
        blogEntries.add(blogEntry);
        return blogEntry.getId();
    }

    @Override
    public List<BlogEntry> getBlogEntries() {
        return blogEntries;
    }

    @Override
    public Boolean exists(Long id) {
        return blogEntries.stream()
                .anyMatch(b -> b.getId().equals(id));
    }
}
