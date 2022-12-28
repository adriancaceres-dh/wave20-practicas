package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.OperationResultDTO;
import com.bootcamp.blog.exception.ElementNotFoundException;
import com.bootcamp.blog.model.BlogEntry;
import com.bootcamp.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImplementation implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public OperationResultDTO create(BlogDTO blogDTO) {
        BlogEntry blogEntry = new BlogEntry(blogDTO.getBlogId(), blogDTO.getTitle(), blogDTO.getAuthorName(), blogDTO.getPublishDate());
        blogRepository.create(blogEntry);
        return new OperationResultDTO(true, "Blog entry has been successfully created");
    }

    @Override
    public BlogDTO get(long id) {
        BlogEntry blogEntry = blogRepository.get(id).orElseThrow(() -> new ElementNotFoundException("Blog not found"));
        return new BlogDTO(blogEntry);
    }

    @Override
    public List<BlogDTO> listAll() {
        return blogRepository.listAll().stream().map(BlogDTO::new).collect(Collectors.toList());
    }

}
