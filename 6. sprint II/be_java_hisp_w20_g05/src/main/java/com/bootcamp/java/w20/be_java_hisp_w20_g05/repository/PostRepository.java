package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private Set<Post> posts = new HashSet<>();

    public PostRepository() {
        posts = loadDataBase(); }

    @Override
    public boolean contains(Post post) {
        return posts.contains(post);
    }
    @Override
    public boolean add(Post post) {
        if (contains(post)) return false;
        return posts.add(post);
    }
    public Optional<Post> getById(int userId) {
        return posts.stream().filter(u -> u.getId()== userId)
                .findFirst();
    }

    @Override
    public Set<Post> filterBy(String productName) {
        return posts.stream().filter(p -> p.getProduct().getName().toLowerCase()
                        .matches("^.*" + productName.toLowerCase() + ".*$"))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Post> getAll() {
        return this.posts;
    }

    public Set<Post> filterByUserId(int userId) {
        return posts.stream().filter(p -> p.getUserId()== userId)
                .collect(Collectors.toSet());
    }

    private static Set<Post> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:posts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        TypeReference<Set<Post>> typeRef = new TypeReference<>() {};
        Set<Post> posts = null;

        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
