package com.bootcamp.be_java_hisp_w20_g2.repository;

import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PostRepository {
    @Autowired
    private ProductRepository productRepository;
    private final HashMap<Integer, Post> posts; // Se crea por tema de búsqueda, de actualización y eliminación.
    private static int currentId = 0;

    public PostRepository(){
        posts = new HashMap<>();
    }

    public Post save(Post post) {
        if (post.getId() == null) {
            post.setId(currentId++);
        }
        productRepository.save(post.getProduct());
        posts.put(post.getId(), post);
        return post;
    }
}
