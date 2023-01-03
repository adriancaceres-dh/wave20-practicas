package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;


import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PostRepositoryImp implements IPostRepository {
    private final Set<Post> posts;
    private int postCount;

    public PostRepositoryImp() {
        this.posts = new HashSet<>();
        this.postCount = 0;
    }

    @Override
    public int createPost(Post post) {
        post.setId(++postCount);
        posts.add(post);
        return postCount;
    }
}
