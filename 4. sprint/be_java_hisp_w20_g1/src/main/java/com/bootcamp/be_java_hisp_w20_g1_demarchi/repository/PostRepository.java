package com.bootcamp.be_java_hisp_w20_g1_demarchi.repository;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.Post;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.repository.interfaces.IPostRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {

    private List<Post> posts;

    public PostRepository() {
        this.posts = buildPostRepository();
    }
    @Override
    public List<Post> getPostsByUserId(int userId) {
        return posts.stream().filter(post -> post.getUserId() == userId).collect(Collectors.toList());
    }

    List<Post> buildPostRepository() {
        File file = null;
        try {
            file = ResourceUtils.getFile(Parameter.getString("PostJsonPath"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<List<Post>> typeRef = new TypeReference<>() {
        };
        List<Post> posts = null;
        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post add(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public List<Post> getPosts() {
        return posts;
    }
}
