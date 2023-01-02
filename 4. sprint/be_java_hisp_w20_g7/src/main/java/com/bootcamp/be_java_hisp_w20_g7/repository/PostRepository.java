package com.bootcamp.be_java_hisp_w20_g7.repository;

import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class PostRepository implements IPostRepository {

    List<Post> posts;

    public PostRepository() {
        posts = new ArrayList<>();
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public boolean save(Post post) {
        return posts.add(post);

    }
}
