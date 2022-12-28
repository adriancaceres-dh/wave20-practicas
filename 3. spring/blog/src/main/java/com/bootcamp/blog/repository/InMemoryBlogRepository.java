package com.bootcamp.blog.repository;

import com.bootcamp.blog.exception.UsedIdException;
import com.bootcamp.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBlogRepository implements BlogRepository {
    private List<BlogEntry> blogEntries;

    public InMemoryBlogRepository() {
        this.blogEntries = new ArrayList<>();
        blogEntries.add(new BlogEntry(0, "Cool blog", "Fran Idalgo", LocalDate.now()));
    }

    @Override
    public boolean create(BlogEntry blogEntry) {
        if (blogEntries.stream().anyMatch(e -> e.getId() == blogEntry.getId())) {
            throw new UsedIdException("There's an existing blog for that id");
        }
        return blogEntries.add(blogEntry);
    }


    @Override
    public Optional<BlogEntry> get(long id) {
        return blogEntries.stream().filter(be -> be.getId() == id).findFirst();
    }

    @Override
    public List<BlogEntry> listAll() {
        return blogEntries;
    }
}
