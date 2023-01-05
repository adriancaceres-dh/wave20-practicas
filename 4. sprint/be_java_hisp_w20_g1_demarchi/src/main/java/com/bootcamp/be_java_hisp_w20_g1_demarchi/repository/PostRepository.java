package com.bootcamp.be_java_hisp_w20_g1_demarchi.repository;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.Post;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.util.JsonReaderUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository {

    private final List<Post> posts;

    public PostRepository() {
        this.posts = JsonReaderUtil.parseJson(Parameter.getString("PostJsonPath"), Post.class);
    }

    @Override
    public List<Post> getPostsByUserId(int userId) {
        return posts.stream().filter(post -> post.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostOnPromotionByUserId(int id) {
        return posts.stream().filter(Post::isHasPromo).collect(Collectors.toList());
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
