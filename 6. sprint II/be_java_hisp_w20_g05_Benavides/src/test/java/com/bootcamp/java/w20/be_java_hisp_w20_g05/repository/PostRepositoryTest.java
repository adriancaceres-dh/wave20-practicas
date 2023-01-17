package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

public class PostRepositoryTest {
    IPostRepository postRepository = new PostRepository();
    Set<Post> posts = postRepository.getAll();
    @Test
    public void getByIdTest() {
        //arrange
        Post expected = posts.stream().filter(post1 -> post1.getId() == 2).findFirst().get();
        //act
        Post post = postRepository.getById(2).get();
        //assert
        Assertions.assertSame(expected, post);
    }

    @Test
    public void filterByTest(){
        //arrange
        Set<Post> expected = posts.stream().filter(p -> p.getProduct().getName().toLowerCase()
                        .matches("^.*" + "azelastine hcl nasal" + ".*$"))
                .collect(Collectors.toSet());
        //act
        Set<Post> post = postRepository.filterBy("azelastine hcl nasal");
        //assert
        Assertions.assertSame(expected.stream().findFirst().get(), post.stream().findFirst().get());
    }
}
