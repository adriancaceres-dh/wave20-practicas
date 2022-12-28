package com.example.blog.service;

import com.example.blog.dto.request.BlogEntryRequestDto;
import com.example.blog.dto.response.BlogEntryResponseDto;
import com.example.blog.exception.BadRequestException;
import com.example.blog.exception.NotFoundException;
import com.example.blog.model.BlogEntry;
import com.example.blog.repository.BlogEntryRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryServiceImpl implements BlogEntryServiceInterface{

    private final BlogEntryRepositoryInterface blogEntryRepository;

    @Autowired
    public BlogEntryServiceImpl(BlogEntryRepositoryInterface blogEntryRepository) {
        this.blogEntryRepository = blogEntryRepository;
    }

    @Override
    public BlogEntryResponseDto getBlogEntryById(Long id) {
        BlogEntry blogEntryFound = blogEntryRepository.getBlogEntryById(id);
        if (blogEntryFound == null) {
            throw new NotFoundException("Blog entry with id: " + id + "wasn't found");
        }
        return new BlogEntryResponseDto(
                blogEntryFound.getTitle(),
                blogEntryFound.getAuthor(),
                blogEntryFound.getCreationDate().toString()
        );
    }

    @Override
    public Long addBlogEntry(BlogEntryRequestDto blogEntryRequestDto) {
        if (blogEntryRepository.exists(blogEntryRequestDto.getId())) {
            throw new BadRequestException("Blog entry with id: " + blogEntryRequestDto.getId() + "already exists");
        }
        BlogEntry blogEntry = new BlogEntry(blogEntryRequestDto.getId(), blogEntryRequestDto.getTitle(), blogEntryRequestDto.getAuthor(), LocalDate.parse(blogEntryRequestDto.getCreationDate()));
        blogEntryRepository.addBlogEntry(blogEntry);
        return blogEntry.getId();
    }

    @Override
    public List<BlogEntryResponseDto> getBlogEntries() {
        return blogEntryRepository.getBlogEntries()
                .stream()
                .map(b -> new BlogEntryResponseDto(b.getTitle(), b.getAuthor(), b.getCreationDate().toString()))
                .collect(Collectors.toList());
    }
}
