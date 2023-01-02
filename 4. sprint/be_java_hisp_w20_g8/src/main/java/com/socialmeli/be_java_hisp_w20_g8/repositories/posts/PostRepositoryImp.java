package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;


import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImp implements IPostRepository {
    private final Set<Post> posts;
    private int postCount;

    public PostRepositoryImp() {
        this.posts = new HashSet<>();
        this.postCount = 0;
    }

    @Override
    public boolean createPost(Post post) {
        post.setId(++postCount);
        return this.posts.add(post);
    }
}
