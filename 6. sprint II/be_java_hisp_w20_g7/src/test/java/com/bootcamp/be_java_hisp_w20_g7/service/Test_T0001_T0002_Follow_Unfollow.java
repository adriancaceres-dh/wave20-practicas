package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.controller.UserController;
import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g7.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IUserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Test_T0001_T0002_Follow_Unfollow {

    @Mock
    IUserRepository userRepository;

    @Mock
    IFollowRepository followRepository;

    @InjectMocks
    FollowService followService;

    @Test
    @DisplayName("T0001 - Follow Ok")
    public void followOk() {
        // arrange
        User userFollower = new User(1,"Manuel");
        User userFollowed = new User(3,"Tomas");
        when(userRepository.findById(1)).thenReturn(userFollower);
        when(userRepository.findById(3)).thenReturn(userFollowed);
        String answerExpected = "User has been followed succesfully";

        // act
        String answerActual = followService.follow(1,3);

        // assert
        Assertions.assertEquals(answerExpected,answerActual);
    }

    @Test
    @DisplayName("T0001 - Followed Not Exist")
    public void followFollowedNotExist() {
        // arrange
        User userFollower = new User(1,"Manuel");
        when(userRepository.findById(1)).thenReturn(userFollower);
        when(userRepository.findById(3)).thenReturn(null);

        // act

        // assert
        assertThrows(UserNotFoundException.class,()->followService.follow(1,3));
    }

    @Test
    @DisplayName("T0001 - Follower Not Exist")
    public void followFollowerNotExist() {
        // arrange
        when(userRepository.findById(1)).thenReturn(null);

        // act

        // assert
        assertThrows(UserNotFoundException.class,()->followService.follow(1,3));
    }

    @Test
    @DisplayName("T0002 - Unfollow Ok")
    public void unfollowOk() {
        // arrange
        // Se prepara la respuesta para cuando se haga el findall
        List<Follow> follows = new ArrayList<>();
        Follow follow = new Follow(1,3);
        follows.add(follow);
        when(followRepository.findAll()).thenReturn(follows);

        // Se prepara la respuesta para cuando busque los usuarios por ID
        User userFollower = new User(1,"Manuel");
        User userFollowed = new User(3,"Tomas");

        when(userRepository.findById(1)).thenReturn(userFollower);
        when(userRepository.findById(3)).thenReturn(userFollowed);

        //Respuesta esperada
        String answerExpected = "the user was unfollowed successfully";

        // act
        String answerActual = followService.unfollow(1,3);

        // assert
        Assertions.assertEquals(answerExpected,answerActual);
    }

    @Test
    @DisplayName("T0002 - Unfollow FollowedUserNotExist")
    public void unfollowFollowedUserNotExist() {
        // arrange
        User userFollower = new User(1,"Manuel");

        when(userRepository.findById(1)).thenReturn(userFollower);
        when(userRepository.findById(4)).thenReturn(null);

        // act

        // assert
        assertThrows(UserNotFoundException.class,()->followService.unfollow(1,4));
    }

}
