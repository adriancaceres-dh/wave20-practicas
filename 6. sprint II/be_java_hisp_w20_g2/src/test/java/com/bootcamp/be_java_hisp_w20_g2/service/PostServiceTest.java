package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.bootcamp.be_java_hisp_w20_g2.util.UtilsTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private IPostRepository postRepository;

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("It should sort the user following sellers posts in ascending order.")
    void sendLastPostsOfFollowedAscOK() {
        //Arrange
        User expectedUser = generateUserWithPostExist();
        PostResponseDTO expectedResponse = generatePostResponseDTOAsc();

        when(userRepository.findOne(1)).thenReturn(expectedUser);

        //Act
        PostResponseDTO actualResponse = postService.sendLastPostOfFollowed(1, Optional.of("date_asc"));

        //Assert
        verify(userRepository, atLeastOnce()).findOne(1);
        assertEquals(expectedResponse.getPosts(), actualResponse.getPosts());
    }

    @Test
    @DisplayName("It should sort the user following sellers posts in descending order.")
    void sendLastPostsOfFollowedDescOK() {
        //Arrange
        User expectedUser = generateUserWithPostExist();
        PostResponseDTO expectedResponse = generatePostResponseDTODesc();

        when(userRepository.findOne(1)).thenReturn(expectedUser);

        //Act
        PostResponseDTO actualResponse = postService.sendLastPostOfFollowed(1, Optional.of("date_desc"));

        //Assert
        verify(userRepository, atLeastOnce()).findOne(1);
        assertEquals(expectedResponse.getPosts(), actualResponse.getPosts());
    }

    @Test
    @DisplayName("It should throw an Exception when given invalid user Id.")
    void sendLastPostsOfFollowedNotOK() {
        //Arrange
        when(userRepository.findOne(444)).thenThrow(new BadRequestException("The given userId not exist."));

        //Assert
        assertThrows(BadRequestException.class, () -> postService.sendLastPostOfFollowed(444, Optional.of("date_asc")));

        BadRequestException exception = assertThrows(BadRequestException.class, () -> postService.sendLastPostOfFollowed(444, Optional.of("date_asc")));
        assertEquals("The given userId not exist.", exception.getMessage());
    }

}