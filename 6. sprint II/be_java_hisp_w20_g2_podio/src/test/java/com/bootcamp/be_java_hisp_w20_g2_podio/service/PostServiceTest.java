package com.bootcamp.be_java_hisp_w20_g2_podio.service;

import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.User;
import com.bootcamp.be_java_hisp_w20_g2_podio.repository.interfaces.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.bootcamp.be_java_hisp_w20_g2_podio.util.UtilsTest.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private PostService postService;

    @Test
    @DisplayName("T-0006 - It should sort the user following sellers posts in ascending order.")
    void sendLastPostsOfFollowedAscOK() {
        //Arrange
        User user2 = new User(2, "Mariano", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        addPostsToUser(user2);

        User user1 = new User("Pepe");
        user1.follow(user2);

        PostResponseDTO expectedResponse = generatePostResponseDTOAsc();

        when(userRepository.findOne(1)).thenReturn(user1);

        //Act
        PostResponseDTO actualResponse = postService.sendLastPostOfFollowed(1, Optional.of("date_asc"));

        //Assert
        verify(userRepository, atLeastOnce()).findOne(1);
        assertEquals(expectedResponse.getPosts(), actualResponse.getPosts());
    }

    @Test
    @DisplayName("T-0006 - It should sort the user following sellers posts in descending order.")
    void sendLastPostsOfFollowedDescOK() {
        //Arrange
        User user2 = new User(2, "Mariano", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        addPostsToUser(user2);

        User user1 = new User("Pepe");
        user1.follow(user2);

        PostResponseDTO expectedResponse = generatePostResponseDTODesc();

        when(userRepository.findOne(1)).thenReturn(user1);

        //Act
        PostResponseDTO actualResponse = postService.sendLastPostOfFollowed(1, Optional.of("date_desc"));

        //Assert
        verify(userRepository, atLeastOnce()).findOne(1);
        assertEquals(expectedResponse.getPosts(), actualResponse.getPosts());
    }

    @Test
    @DisplayName("T-0006 Bad Request - It should throw an Exception when given invalid user Id.")
    void sendLastPostsOfFollowedNotOK() {
        //Arrange
        when(userRepository.findOne(444)).thenReturn(null);

        //Assert
        assertThrows(BadRequestException.class, () -> postService.sendLastPostOfFollowed(444, Optional.of("date_asc")));

        BadRequestException exception = assertThrows(BadRequestException.class, () -> postService.sendLastPostOfFollowed(444, Optional.of("date_asc")));
        assertEquals("The given userId not exist.", exception.getMessage());
    }

    @Test
    @DisplayName("T-0008 It should find posts made on the last two weeks by user following costumer")
    void sendPostsOfFollowedOnLastTwoWeek() {
        //Arrange
        User user2 = new User(2, "Mariano", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        addPostsToUser(user2);

        User user1 = new User("Pepe");
        user1.follow(user2);

        when(userRepository.findOne(0)).thenReturn(user1);

        //Act
        PostResponseDTO actualResponse = postService.sendLastPostOfFollowed(0, Optional.of("date_asc"));
        AtomicBoolean isOnLastTwoWeeks = new AtomicBoolean(true);
        if (actualResponse.getPosts().isEmpty()) {
            isOnLastTwoWeeks.set(false);
        } else {
            actualResponse.getPosts().forEach(p -> {
                if (!p.getDate().isAfter(LocalDate.now().plusDays(-14))) {
                    isOnLastTwoWeeks.set(false);
                }
            });
        }

        //Assert
        verify(userRepository, atLeastOnce()).findOne(0);
        assertTrue(isOnLastTwoWeeks.get());
    }

}