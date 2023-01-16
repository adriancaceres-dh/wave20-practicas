package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.InvalidQueryParamValueException;
import com.bootcamp.be_java_hisp_w20_g1.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
import com.bootcamp.be_java_hisp_w20_g1.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    static User validUser = new User(1, "noahHoah", new HashSet<>(), new HashSet<>(), new HashSet<>(), true);
    static User validUserToFollow = new User(2, "elzaTlza", new HashSet<>(), new HashSet<>(), new HashSet<>(), true);

    @Test
    void whenGivingValidUserId_followUser_ShouldFollowUser() throws Exception {

        //Arrange
        when(userRepository.getUserById(1)).thenReturn(validUser);
        when(userRepository.getUserById(2)).thenReturn(validUserToFollow);

        UserResponseDto userResponseDto = new UserResponseDto(validUserToFollow.getId(),validUserToFollow.getName());
        UserFollowedResponseDto userFollowedResponseDto = new UserFollowedResponseDto(validUser.getId(),validUser.getName(), List.of(userResponseDto));

        UserFollowedResponseDto expectedDTO = userFollowedResponseDto;

        //Act
        validUser.getFollowed().add(validUserToFollow.getId());
        UserFollowedResponseDto actualDTO = userService.followUser(1,2);

        //Assert
        Assertions.assertEquals(expectedDTO,actualDTO);

    }

    @Test
    void whenGivingInvalidUserId_followUser_ShouldThrowNotFoundException() throws Exception {

        // Arrange
        String expectedErrorMessage = "El usuario no existe";
        when(userRepository.getUserById(1)).thenReturn(validUser);
        when(userRepository.getUserById(99)).thenReturn(null);
        validUser.getFollowed().add(validUserToFollow.getId());

        // Act && Assert
        NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> userService.followUser(1, 99));
        Assertions.assertEquals(expectedErrorMessage, notFoundException.getMessage());
    }

    @Test
    @DisplayName("T4 se obtiene lista de los seguidores de un usuario ordenada ascendentemente.")
    public void shouldGetSellersFollowersDtoOrderedByAsc() {
        User user = User.builder().id(6).name("Joe").isSeller(true).build();
        Set<Integer> followers = new HashSet<>();
        followers.add(1);
        followers.add(2);
        User user1 = User.builder().id(1).name("Facundo").build();

        User user2 = User.builder().id(2).name("Raul").build();
        user.setFollowers(followers);
        when(userRepository.getUserById(6)).thenReturn(user);
        when(userRepository.getUserById(1)).thenReturn(user1);
        when(userRepository.getUserById(2)).thenReturn(user2);

        UserFollowersResponseDto expectedResult = new UserFollowersResponseDto();
        expectedResult.setUserId(6);
        expectedResult.setUserName("Joe");
        List<UserResponseDto> users = new ArrayList<>();
        UserResponseDto userResponse1 = new UserResponseDto(1, "Facundo");
        UserResponseDto userResponse2 = new UserResponseDto(2, "Raul");
        users.add(userResponse1);
        users.add(userResponse2);
        expectedResult.setFollowers(users);
        UserFollowersResponseDto actual = userService.getSellerFollowersDto(6, "name_asc");

        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T4 se obtiene lista de los seguidores de un usuario ordenada descendente.")
    public void shouldGetSellersFollowersDtoOrderedByDesc() {

        // Arrange
        User user = User.builder().id(6).name("Joe").isSeller(true).build();
        User user1 = User.builder().id(1).name("Facundo").build();
        User user2 = User.builder().id(2).name("Raul").build();

        Set<Integer> followers = new HashSet<>();
        followers.add(1);
        followers.add(2);

        user.setFollowers(followers);

        when(userRepository.getUserById(6)).thenReturn(user);
        when(userRepository.getUserById(1)).thenReturn(user1);
        when(userRepository.getUserById(2)).thenReturn(user2);

        List<UserResponseDto> users = new ArrayList<>();
        users.add(new UserResponseDto(2, "Raul"));
        users.add(new UserResponseDto(1, "Facundo"));

        UserFollowersResponseDto expectedResult = new UserFollowersResponseDto();
        expectedResult.setUserId(6);
        expectedResult.setUserName("Joe");
        expectedResult.setFollowers(users);

        //Act y Assert
        UserFollowersResponseDto actual = userService.getSellerFollowersDto(6, "name_desc");
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T4 se obtiene lista de los que un usuario sigue ordenada ascendente.")
    public void shouldGetSellersFollowedDtoOrderedByAsc() {

        // Arrange
        User user = User.builder().id(6).name("Joe").isSeller(true).build();
        User user1 = User.builder().id(1).name("Facundo").build();
        User user2 = User.builder().id(2).name("Raul").build();

        Set<Integer> followed = new HashSet<>();
        followed.add(1);
        followed.add(2);

        user.setFollowed(followed);

        when(userRepository.getUserById(6)).thenReturn(user);
        when(userRepository.getUserById(1)).thenReturn(user1);
        when(userRepository.getUserById(2)).thenReturn(user2);

        List<UserResponseDto> users = new ArrayList<>();
        users.add(new UserResponseDto(1, "Facundo"));
        users.add(new UserResponseDto(2, "Raul"));

        UserFollowedResponseDto expectedResult = new UserFollowedResponseDto();
        expectedResult.setUserId(6);
        expectedResult.setUserName("Joe");
        expectedResult.setFollowed(users);

        //Act y Assert
        UserFollowedResponseDto actual = userService.getFollowedDto(6, "name_asc");
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T4 se obtiene lista de los que un usuario sigue ordenada descendente.")
    public void shouldGetSellersFollowedDtoOrderedByDesc() {

        // Arrange
        User user = User.builder().id(6).name("Joe").isSeller(true).build();
        User user1 = User.builder().id(1).name("Facundo").build();
        User user2 = User.builder().id(2).name("Raul").build();

        Set<Integer> followed = new HashSet<>();
        followed.add(1);
        followed.add(2);

        user.setFollowed(followed);

        when(userRepository.getUserById(6)).thenReturn(user);
        when(userRepository.getUserById(1)).thenReturn(user1);
        when(userRepository.getUserById(2)).thenReturn(user2);

        List<UserResponseDto> users = new ArrayList<>();
        users.add(new UserResponseDto(2, "Raul"));
        users.add(new UserResponseDto(1, "Facundo"));

        UserFollowedResponseDto expectedResult = new UserFollowedResponseDto();
        expectedResult.setUserId(6);
        expectedResult.setUserName("Joe");
        expectedResult.setFollowed(users);

        //Act y Assert
        UserFollowedResponseDto actual = userService.getFollowedDto(6, "name_desc");
        assertEquals(expectedResult, actual);
    }


    @Test
    @DisplayName("T3 Se lanza excepción si el orden es inválido.")
    public void shouldThrowExceptionIfOrderDoesNotExist() {
        // Arrange
        User user = User.builder().id(6).name("Joe").isSeller(true).build();
        User user1 = User.builder().id(1).name("Facundo").build();
        User user2 = User.builder().id(2).name("Raul").build();

        Set<Integer> followed = new HashSet<>();
        followed.add(1);
        followed.add(2);

        user.setFollowed(followed);

        when(userRepository.getUserById(6)).thenReturn(user);
        when(userRepository.getUserById(1)).thenReturn(user1);
        when(userRepository.getUserById(2)).thenReturn(user2);

        List<UserResponseDto> users = new ArrayList<>();
        users.add(new UserResponseDto(2, "Raul"));
        users.add(new UserResponseDto(1, "Facundo"));

        UserFollowedResponseDto expectedResult = new UserFollowedResponseDto();
        expectedResult.setUserId(6);
        expectedResult.setUserName("Joe");
        expectedResult.setFollowed(users);

        //Act y Assert
        assertThrows(InvalidQueryParamValueException.class, () -> userService.getFollowedDto(6, "invalid_order"));
    }

    @Test
    @DisplayName("T3 se obtiene lista de los que un usuario sigue ordenada ascendentemente (por defecto).")
    public void shouldGetSellersFollowedDtoOrdered() {

        // Arrange
        User user = User.builder().id(6).name("Joe").isSeller(true).build();
        User user1 = User.builder().id(1).name("Facundo").build();
        User user2 = User.builder().id(2).name("Raul").build();

        Set<Integer> followed = new HashSet<>();
        followed.add(1);
        followed.add(2);

        user.setFollowed(followed);

        when(userRepository.getUserById(6)).thenReturn(user);
        when(userRepository.getUserById(1)).thenReturn(user1);
        when(userRepository.getUserById(2)).thenReturn(user2);

        List<UserResponseDto> users = new ArrayList<>();
        users.add(new UserResponseDto(1, "Facundo"));
        users.add(new UserResponseDto(2, "Raul"));

        UserFollowedResponseDto expectedResult = new UserFollowedResponseDto();
        expectedResult.setUserId(6);
        expectedResult.setUserName("Joe");
        expectedResult.setFollowed(users);

        //Act y Assert
        UserFollowedResponseDto actual = userService.getFollowedDto(6, null);
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T3 se obtiene lista de seguidores de un usuario ordenada ascendentemente (por defecto).")
    public void shouldGetSellersFollowersDtoOrdered() {

        // Arrange
        User user = User.builder().id(6).name("Joe").isSeller(true).build();
        User user1 = User.builder().id(1).name("Facundo").build();
        User user2 = User.builder().id(2).name("Raul").build();

        Set<Integer> followers = new HashSet<>();
        followers.add(1);
        followers.add(2);

        user.setFollowers(followers);

        when(userRepository.getUserById(6)).thenReturn(user);
        when(userRepository.getUserById(1)).thenReturn(user1);
        when(userRepository.getUserById(2)).thenReturn(user2);

        List<UserResponseDto> users = new ArrayList<>();
        users.add(new UserResponseDto(1, "Facundo"));
        users.add(new UserResponseDto(2, "Raul"));

        UserFollowersResponseDto expectedResult = new UserFollowersResponseDto();
        expectedResult.setUserId(6);
        expectedResult.setUserName("Joe");
        expectedResult.setFollowers(users);

        //Act y Assert
        UserFollowersResponseDto actual = userService.getSellerFollowersDto(6, null);
        assertEquals(expectedResult, actual);
    }

}