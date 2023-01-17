package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private IUserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("T-0002 unfollowUser - Good Ending")
    void unfollowUserExistTest() {
        // Arrange
        HashMap<Integer, User> users = Utils.generateUsers();
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
    @DisplayName("T-0002 unfollowUser - User1 is null")
    void unfollowUserNullOne() {
        // Arrange
        HashMap<Integer, User> users = Utils.generateUsers();
        User user2 = users.get(2); // user2 follows user1
        // Act
        when(userRepository.findOne(1)).thenReturn(null);
        when(userRepository.findOne(2)).thenReturn(user2);
        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.unfollowUser(1, 2));
    }

    @Test
    @DisplayName("T-0002 unfollowUser - User2 is null")
    void unfollowUserNullTwo() {
        // Arrange
        HashMap<Integer, User> users = Utils.generateUsers();
        User user1 = users.get(1); // user2 follows user1
        // Act
        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(null);
        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.unfollowUser(1, 2));
    }

    @Test
    @DisplayName("T-0002 unfollowUser - user1 not in user2's followers list and user2 not in user1's following list")
    void unfollowUserNotInList() {
        // Arrange
        HashMap<Integer, User> users = Utils.generateUsers();
        User user1 = users.get(1); // user2 follows user1
        User user2 = users.get(2);
        user1.removeFollowing(user2);
        user2.removeFollower(user1);
        // Act
        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(user2);
        // Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.unfollowUser(1, 2));
    }


    @Test
    @DisplayName("T-0001 Follow - OK")
    void follow() {

        // test follow an existing user (OK)

        //Arrange
        User user1 = new User(1, "usuario1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "usuario2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

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
        Assertions.assertThrows(BadRequestException.class, () -> userService.follow(1, 2));

    }

    @Test
    @DisplayName("T-0001 Follow existing following - Bad request")
    void followExistingFollowing() {

        // test follow a user who already followed (BadRequest)

        //Arrange
        User user1 = new User(1, "usuario1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "usuario2", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        user1.getFollowing().add(user2);


        //Act
        when(userRepository.exists(1)).thenReturn(true);
        when(userRepository.exists(2)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);
        when(userRepository.findOne(2)).thenReturn(user2);


        //Assert

        Assertions.assertThrows(BadRequestException.class, () -> userService.follow(1, 2));

    }

    @Test
    @DisplayName("T-0001 Follow my self - Bad request")
    void followMySelf() {
        //test follow to myself (BadRequest)

        //Arrange
        User user1 = new User(1, "usuario1", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());


        //Act
        when(userRepository.exists(1)).thenReturn(true);

        when(userRepository.findOne(1)).thenReturn(user1);


        //Assert
        Assertions.assertThrows(BadRequestException.class, () -> userService.follow(1, 1));

    }

    @Test
    @DisplayName("Camino feliz en donde existe el usuario buscado por parámetro.")
    void followerListWithUserExist() {
        // Arrange
        UserFollowersCountResponseDTO responseExpected = new UserFollowersCountResponseDTO(2, "Mariano", 1);
        HashMap<Integer, User> users = Utils.generateUsers();
        // Act
        when(userRepository.exists(2)).thenReturn(true);
        when(userRepository.findOne(2)).thenReturn(users.get(2));
        UserFollowersCountResponseDTO dtoResult = userService.followerList(2);
        // Assert
        verify(userRepository, atLeastOnce()).exists(2);
        verify(userRepository, atLeastOnce()).findOne(2);
        assertEquals(responseExpected, dtoResult);
    }

    @Test
    @DisplayName("Camino feliz en donde no existe el usuario buscado por parámetro.")
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

    @Test
    @DisplayName("T-0004 - Sorts correctly by ascending username")
    void findAllFollowersNameOrderAscOkTest() {
        //arrange
        Optional<String> order = Optional.of("name_asc");
        HashMap<Integer, User> users = Utils.generateUsers();
        User user1 = users.get(1);
        when(userRepository.findOne(1)).thenReturn(user1);

        List<UserResponseDTO> userResponseDTOListExpected = new ArrayList<>();
        userResponseDTOListExpected.add(new UserResponseDTO(3, "Lorenzo"));
        userResponseDTOListExpected.add(new UserResponseDTO(2, "Mariano"));

        UserFollowersResponseDTO userFollowedResponseDTO = new UserFollowersResponseDTO(user1.getId(), user1.getUserName(), userResponseDTOListExpected);
        //act
        UserFollowersResponseDTO userFollowedResponseDTOResult = userService.findAllFollowers(userFollowedResponseDTO.getUserId(), order);
        //assert
        assertEquals(userResponseDTOListExpected, userFollowedResponseDTOResult.getFollowers());
        assertEquals(userResponseDTOListExpected.get(0), userFollowedResponseDTOResult.getFollowers().get(0));
        assertEquals(userResponseDTOListExpected.get(1), userFollowedResponseDTOResult.getFollowers().get(1));
    }

    @Test
    @DisplayName("T-0004 - Sorts correctly by username descending")
    void findAllFollowersNameOrderDescOkTest() {
        //arrange
        Optional<String> order = Optional.of("name_desc");
        HashMap<Integer, User> users = Utils.generateUsers();
        User user1 = users.get(1);
        when(userRepository.findOne(1)).thenReturn(user1);

        List<UserResponseDTO> userResponseDTOListExpected = new ArrayList<>();
        userResponseDTOListExpected.add(new UserResponseDTO(2, "Mariano"));
        userResponseDTOListExpected.add(new UserResponseDTO(3, "Lorenzo"));

        UserFollowersResponseDTO userFollowedResponseDTO = new UserFollowersResponseDTO(user1.getId(), user1.getUserName(), userResponseDTOListExpected);
        //act
        UserFollowersResponseDTO userFollowedResponseDTOResult = userService.findAllFollowers(userFollowedResponseDTO.getUserId(), order);
        //assert
        assertEquals(userResponseDTOListExpected, userFollowedResponseDTOResult.getFollowers());
        assertEquals(userResponseDTOListExpected.get(0), userFollowedResponseDTOResult.getFollowers().get(0));
        assertEquals(userResponseDTOListExpected.get(1), userFollowedResponseDTOResult.getFollowers().get(1));
    }

    @Test
    @DisplayName("T-0004 - User id not found")
    void findAllFollowersUserNotFoundTest() {
        //arrange
        Optional<String> order = Optional.of("name_desc");
        when(userRepository.findOne(anyInt())).thenReturn(null);
        //act - assert
        assertThrows(UserNotFoundException.class, () -> userService.findAllFollowers(1, order));
    }

}