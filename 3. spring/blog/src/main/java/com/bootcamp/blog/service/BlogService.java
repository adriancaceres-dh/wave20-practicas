package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.request.BlogPostRequestDto;
import com.bootcamp.blog.dto.response.BlogPostResponseDto;
import com.bootcamp.blog.exception.IdAlreadyExistsException;
import com.bootcamp.blog.exception.InvalidIdException;
import com.bootcamp.blog.model.BlogPost;
import com.bootcamp.blog.repository.BlogRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{

    private final ModelMapper mapper = new ModelMapper();
    @Autowired
    BlogRepository blogRepository;

    public BlogService() {
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }
    @Override
    public String addPost(BlogPostRequestDto blogPostRequestDto) {
        BlogPost blogPost = blogRepository.findById(blogPostRequestDto.getId());
        if(blogPost != null) throw new IdAlreadyExistsException("Ya existe una entrada con ese id");
        blogRepository.addPost(mapper.map(blogPostRequestDto,BlogPost.class));
        return "Post con id " + blogPostRequestDto.getId() + " creado correctamente.";
    }

    @Override
    public BlogPostResponseDto getPost(String id){
        BlogPost blogPost = blogRepository.findById(id);
        if(blogPost == null) throw new InvalidIdException("El id no pertenece a ninguna entrada");
        return mapper.map(blogPost, BlogPostResponseDto.class);
    }

    @Override
    public List<BlogPostResponseDto> getPosts() {
        return blogRepository.getPosts().stream().map(p -> mapper.map(p, BlogPostResponseDto.class)).collect(Collectors.toList());
    }
}
