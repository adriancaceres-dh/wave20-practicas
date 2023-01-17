package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @Mock
    IPostRepository postRepository;

    @Mock
    IUserService userService;

    @InjectMocks
    PostService postService;

    @DisplayName("Test T-0005 - Order: asc - OK")
    @Test
    void verifyPerformOrderTestAscOk()
    {
        //arrange
        int userId = 1;
        String order = "date_asc";

        // Retorna un dto de FollowedUsersPostsResponseDTO con 3 posts asociados a un user ordenado ascendientemente (Expected).
        FollowedUsersPostsResponseDTO expected = TestUtils.getFollowedUsersPosts(userId);

        //Retorno usuario pepe que sigue a usuarios con id 4,5,6.
        when(userService.getById(userId)).thenReturn(TestUtils.getUserWithId(userId));

        //Cuando hace un getall de los repositorios "Simulo" obtener 3 post los cuales se envian desordenados para verificar el correcto orden.
        when(postRepository.getAll()).thenReturn(TestUtils.get3PostsWithUserId(userId));

        //act
        FollowedUsersPostsResponseDTO result = postService.getFollowedUsersPosts(userId, order);

        //assert
        List<LocalDate> expectedDates = new ArrayList<>();
        expected.getPosts().stream().forEach( e -> expectedDates.add(e.getDate()));

        List<LocalDate> resultDates = new ArrayList<>();
        result.getPosts().stream().forEach( r -> resultDates.add(r.getDate()));

        assertEquals(resultDates,expectedDates);
        assertEquals(expected.getPosts().size(), result.getPosts().size());
        verify(userService, atLeastOnce()).getById(userId);
        verify(postRepository, atLeastOnce()).getAll();
    }
    @DisplayName("Test T-0005 - Order: desc - OK")
    @Test
    void verifyPerformOrderTestDescOk()
    {
        //arrange
        int userId = 1;
        String order = "date_desc";

        // Retorna un dto de FollowedUsersPostsResponseDTO con 3 posts asociados a un user ordenados descencientemente (Expected.)
        FollowedUsersPostsResponseDTO expected = TestUtils.getFollowedUsersPostsDesc(userId);

        //Retorno usuario pepe que sigue a usuarios con id 4,5,6.
        when(userService.getById(userId)).thenReturn(TestUtils.getUserWithId(userId));

        //Cuando hace un getall de los repositorios "Simulo" obtener 3 post los cuales se envian desordenados para verificar el correcto orden.
        when(postRepository.getAll()).thenReturn(TestUtils.get3PostsWithUserId(userId));

        //act
        FollowedUsersPostsResponseDTO result = postService.getFollowedUsersPosts(userId, order);

        //assert
        List<LocalDate> expectedDates = new ArrayList<>();
        expected.getPosts().stream().forEach( e -> expectedDates.add(e.getDate()));

        List<LocalDate> resultDates = new ArrayList<>();
        result.getPosts().stream().forEach( r -> resultDates.add(r.getDate()));

        assertEquals(resultDates,expectedDates);
        assertEquals(expected.getPosts().size(), result.getPosts().size());
        verify(userService, atLeastOnce()).getById(userId);
        verify(postRepository, atLeastOnce()).getAll();
    }
}
