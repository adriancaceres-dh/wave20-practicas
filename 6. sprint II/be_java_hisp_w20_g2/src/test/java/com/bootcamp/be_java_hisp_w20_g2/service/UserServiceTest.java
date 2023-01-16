package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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
    void unfollowUserExistTest() {
        // Arrange
        HashMap<Integer, User> users = UtilsTest.generateUsersForTestTwo();
        User user1 = users.get(1); // user2 follows user1
        User user2 = users.get(2);
        // Act
        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(user2);
        String res = userService.unfollowUser(1, 2);
        // Assert
        verify(userRepository, atLeastOnce()).findOne(1);
        verify(userRepository, atLeastOnce()).findOne(2);
        assertEquals("Operación exitosa", res);

    }

    @Test
    void unfollowUserNotOkTest() {
        // Arrange
        HashMap<Integer, User> users = UtilsTest.generateUsersForTestTwo();
        User user2 = users.get(2); // user2 follows user1
        // Act
        when(userRepository.findOne(1)).thenReturn(null);
        when(userRepository.findOne(2)).thenReturn(user2);
        // Assert
        Assertions.assertThrows(BadRequestException.class,()->userService.unfollowUser(1,2));
    }

    @Test
    void entity2UserResponseDTO() {
    }

    @Test
    @DisplayName("T-0001 Follow - OK")
    void follow() {

        // test follow an existing user (OK)

        //Arrange
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        //Act
        when(userRepository.exists(1)).thenReturn(true);
        when(userRepository.exists(2)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(user2);


        boolean res = userService.follow(1, 2);


        //Assert
        verify(userRepository, atLeastOnce()).exists(1);
        verify(userRepository, atLeastOnce()).exists(2);
        verify(userRepository, atLeastOnce()).findOne(1);
        verify(userRepository, atLeastOnce()).findOne(2);

        Assertions.assertTrue(res);
    }

    @Test
    @DisplayName("T-0001 Follow existing user - Bad request")

    void followNonExistingUser() {

        // test follow a non-existing user (BadRequest)

        //Arrange

        //Act
        when(userRepository.exists(2)).thenReturn(false);

        //Assert
        Assertions.assertThrows(BadRequestException.class,()->userService.follow(1,2));

    }

    @Test
    @DisplayName("T-0001 Follow existing following - Bad request")

    void followExistingFollowing() {

        // test follow a user who already followed (BadRequest)

        //Arrange
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user1.getFollowing().add(user2);


        //Act
        when(userRepository.exists(1)).thenReturn(true);
        when(userRepository.exists(2)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(user2);


        //Assert

        Assertions.assertThrows(BadRequestException.class,()->userService.follow(1,2));

    }

    @Test
    @DisplayName("T-0001 Follow my self - Bad request")

    void followMySelf() {
        //test follow to myself (BadRequest)

        //Arrange
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());


        //Act
        when(userRepository.exists(1)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);


        //Assert
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