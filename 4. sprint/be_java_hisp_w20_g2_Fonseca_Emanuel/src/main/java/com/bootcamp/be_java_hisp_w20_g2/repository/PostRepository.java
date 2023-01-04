package com.bootcamp.be_java_hisp_w20_g2.repository;

import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PostRepository implements IPostRepository {
    private static int currentId = 0;
    private final HashMap<Integer, Post> posts; // Se crea por tema de búsqueda, de actualización y eliminación.
    @Autowired
    private ProductRepository productRepository;

    public PostRepository() {
        posts = new HashMap<>();
    }

    @Override
    public Post save(Post post) {
        if (post.getId() == null) {
            post.setId(currentId++);
        }
        productRepository.save(post.getProduct());
        posts.put(post.getId(), post);
        return post;
    }

    @Override
    public Post findOne(Integer key) {
        return posts.get(key);
    }

    @Override
    public boolean exists(Integer key) {
        return posts.containsKey(key);
    }
}
