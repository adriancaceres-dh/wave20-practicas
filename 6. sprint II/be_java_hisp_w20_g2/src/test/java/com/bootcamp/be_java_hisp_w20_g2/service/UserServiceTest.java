package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import lombok.experimental.Wither;
import org.junit.jupiter.api.DisplayName;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.util.UtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    void findAllFollowers() {


    }

    @Test
    void findAllFollowed() {
    }

    @Test
    void unfollowUser() {
    }

    @Test
    void entity2UserResponseDTO() {
    }

    @Test
    void follow() {

        // test follow an existing user (OK)

        HashMap<Integer, User> users = UtilsTest.generateUsersToTestFollow();

        User user1 = users.get(1);
        User user2 = users.get(2);


        when(userRepository.exists(1)).thenReturn(true);
        when(userRepository.exists(2)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(user2);

        boolean res = userService.follow(1, 2);

        verify(userRepository, atLeastOnce()).exists(1);
        verify(userRepository, atLeastOnce()).exists(2);
        verify(userRepository, atLeastOnce()).findOne(1);
        verify(userRepository, atLeastOnce()).findOne(2);

        Assertions.assertTrue(res);
    }

    @Test
    void followNonExistingUser() {

        // test follow a non-existing user (BadRequest)

        when(userRepository.exists(2)).thenReturn(false);
        Assertions.assertThrows(BadRequestException.class,()->userService.follow(1,2));

    }

    @Test
    void followExistingFollowing() {

        // test follow a user who already followed (BadRequest)
        HashMap<Integer, User> users = UtilsTest.generateUsersToTestExistingFollow();

        User user1 = users.get(1);
        User user2 = users.get(2);


        when(userRepository.exists(1)).thenReturn(true);
        when(userRepository.exists(2)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(user2);


        Assertions.assertThrows(BadRequestException.class,()->userService.follow(1,2));

    }

    @Test
    void followMySelf() {
        //test follow to myself (BadRequest)
        HashMap<Integer, User> users = UtilsTest.generateUsersToTestExistingFollow();

        User user1 = users.get(1);

        when(userRepository.exists(1)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);

        Assertions.assertThrows(BadRequestException.class,()->userService.follow(1,1));

    }
    
    @Test
    @DisplayName("Camino feliz en donde existe el usuario buscado por parámetro.")
    void followerListWithUserExist() {
        // Arrange
        UserFollowersCountResponseDTO responseExpected = new UserFollowersCountResponseDTO(2, "Mariano", 3);
        User user = UtilsTest.generateUserToTestFollowerList();
        // Act
        when(userRepository.exists(2)).thenReturn(true);
        when(userRepository.findOne(2)).thenReturn(user);
        UserFollowersCountResponseDTO dtoResult = userService.followerList(2);
        // Assert
        verify(userRepository, atLeastOnce()).exists(1);
        verify(userRepository, atLeastOnce()).findOne(1);
        assertEquals(responseExpected, dtoResult);
    }

    @Test
    @DisplayName("Camino feliz't en donde no existe el usuario buscado por parámetro.")
    void followerListWithUserNotExist() {
        // Arrange
        BadRequestException responseExpected = new BadRequestException("El usuario no existe");

        Exception myExceptionResult = null;
        // Act
        when(userRepository.exists(2)).thenReturn(false);
        try {
            UserFollowersCountResponseDTO dtoResult = userService.followerList(2);
        } catch (BadRequestException ex) {
            myExceptionResult = ex;
        } finally {
            // Assert
            verify(userRepository, atLeastOnce()).exists(2);
            //assertThrows(BadRequestException.class,()->{userRepository.exists(2);});
            assertEquals(responseExpected.getMessage(), myExceptionResult.getMessage());
        }
    }
}