package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    IUserRepository userRepository;
    @InjectMocks
    UserService userService;

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void followUser_ok(){

        //Arrange
        int userId = 1;
        int userIdToFollow = 1213213;

        User user = new User(userId, "", new HashSet<>(), new HashSet<>());
        User userToFollow = new User(userIdToFollow, "", new HashSet<>(), new HashSet<>());

        when(userRepository.getById(userId)).thenReturn(Optional.of(user));
        when(userRepository.getById(userIdToFollow)).thenReturn(Optional.of(userToFollow));

        //Act

        userService.followUser(userId, userIdToFollow);

        //Assert
        assertTrue(user.getFollowing().contains(userIdToFollow));
        assertTrue(userToFollow.getFollowers().contains(userId));

    }
    @Test
    void followUser_userNotFound(){

        //Arrange
        int userId = 1;
        int userIdToFollow = 1213213;

        User user = new User(userId, "us1", new HashSet<>(), new HashSet<>());

        when(userRepository.getById(userId)).thenReturn(Optional.of(user));
        when(userRepository.getById(userIdToFollow)).thenReturn(Optional.empty());

        String expectedMessage = "User with id: "+userIdToFollow+" was not found";

        //Act && Assert

        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
            userService.followUser(userId, userIdToFollow);
        });

        String actualMessage = exception.getMessageExceptionDto().getMessageException();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void unfollowUser_ok(){
        //Arrange
        int userId = 1;
        int userIdToUnFollow = 1213213;

        User user = new User(userId, "", new HashSet<>(), new HashSet<>());
        User userToFollow = new User(userIdToUnFollow, "", new HashSet<>(userId), new HashSet<>());

        user.followUser(userIdToUnFollow);

        when(userRepository.getById(userId)).thenReturn(Optional.of(user));
        when(userRepository.getById(userIdToUnFollow)).thenReturn(Optional.of(userToFollow));

        //Act

        userService.unfollowUser(userId, userIdToUnFollow);

        //Assert
        assertFalse(user.getFollowing().contains(userIdToUnFollow));
        assertFalse(userToFollow.getFollowers().contains(userId));
    }
    @Test
    void unfollowUser_userNotFound(){

        //Arrange
        int userId = 1;
        int userIdToUnFollow = 1213213;

        User user = new User(userId, "us1", new HashSet<>(), new HashSet<>());

        when(userRepository.getById(userId)).thenReturn(Optional.of(user));
        when(userRepository.getById(userIdToUnFollow)).thenReturn(Optional.empty());

        String expectedMessage = "User with id: "+userIdToUnFollow+" was not found";

        //Act && Assert

        IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
            userService.unfollowUser(userId, userIdToUnFollow);
        });

        String actualMessage = exception.getMessageExceptionDto().getMessageException();

        assertTrue(actualMessage.contains(expectedMessage));


    }
}
