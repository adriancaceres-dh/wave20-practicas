package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IUserRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.util.TestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("T-0001 cumple")
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
    @DisplayName("T-0001 no cumple")
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
    @DisplayName("T-0002 cumple")
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
    @DisplayName("T-0002 no cumple")
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

    // TEST T-0004
    // Verificar el correcto ordenamiento ascendente y descendente por nombre.
    @Test
    @DisplayName("T-0004: Following by name_asc")
    public void getFollowedByIdTestAsc () {

        // ARRANGE
        when(userRepository.getById(5)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(5))); // userId del usuario de test que sigue a todos y todos lo siguen.
        when(userRepository.getById(1)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(1))); // usu1
        when(userRepository.getById(2)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(2))); // hbowstead0
        when(userRepository.getById(3)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(3))); // qropcke1
        when(userRepository.getById(4)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(4))); // jmedcraft2

        FollowedListDTO expectedAscending = TestUtils.getTestFollowedListDTO("name_asc");   // hbowstead0, jmedcraft2, qropcke1, usu1
        FollowedListDTO sortedAscending;

        // ACT
        sortedAscending = userService.getFollowedListDto(5, "name_asc");

        // ASSERT
        Assertions.assertTrue(sortedAscending.equals(expectedAscending));
    }

    @Test
    @DisplayName("T-0004: Following by name_desc")
    public void getFollowedByIdTestDesc () {

        // ARRANGE
        when(userRepository.getById(5)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(5))); // userId del usuario de test que sigue a todos y todos lo siguen.
        when(userRepository.getById(1)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(1))); // usu1
        when(userRepository.getById(2)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(2))); // hbowstead0
        when(userRepository.getById(3)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(3))); // qropcke1
        when(userRepository.getById(4)).thenReturn(Optional.ofNullable(TestUtils.getTestUser(4))); // jmedcraft2

        FollowedListDTO expectedDescending = TestUtils.getTestFollowedListDTO("name_desc"); // usu1, qropcke1, jmedcraft2, hbowstead0
        FollowedListDTO sortedDescending;

        // ACT
        sortedDescending = userService.getFollowedListDto(5, "name_desc");

        // ASSERT
        Assertions.assertTrue(sortedDescending.equals(expectedDescending));

    }

    // TEST T-0004
    @Test
    @DisplayName("T-0004: Followers list sorting")
    public void getFollowersBySellerTest () {
        // DEAR GOD, IF YOU ARE REAL PLEASE STOP TESTING ME. THANKS :)
    }
}
