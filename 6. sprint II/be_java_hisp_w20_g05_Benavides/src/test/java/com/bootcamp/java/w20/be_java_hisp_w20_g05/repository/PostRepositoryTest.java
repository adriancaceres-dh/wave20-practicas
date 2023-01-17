package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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
