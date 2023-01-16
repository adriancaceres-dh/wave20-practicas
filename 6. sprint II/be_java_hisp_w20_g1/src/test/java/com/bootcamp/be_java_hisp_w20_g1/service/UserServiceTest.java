package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g1.exception.InvalidQueryParamValueException;
import com.bootcamp.be_java_hisp_w20_g1.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
import com.bootcamp.be_java_hisp_w20_g1.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import com.bootcamp.be_java_hisp_w20_g1.util.TestUtil;
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
    @DisplayName("T1 Cuando el usuario a seguir existe se agrega como seguidor")
    void whenGivingValidUserId_followUser_ShouldFollowUser() {

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
    @DisplayName("T1 Se lanza excepción cuando el usuario a seguir no existe")
    void whenGivingInvalidUserId_followUser_ShouldThrowNotFoundException() {

        // Arrange
        String expectedErrorMessage = Parameter.getString("EX_NotExistentUser");
        when(userRepository.getUserById(1)).thenReturn(validUser);
        when(userRepository.getUserById(99)).thenReturn(null);
        validUser.getFollowed().add(validUserToFollow.getId());

        // Act && Assert
        NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> userService.followUser(1, 99));
        Assertions.assertEquals(expectedErrorMessage, notFoundException.getMessage());
    }

    @Test
    @DisplayName("T4 se obtiene lista de los seguidores de un usuario ordenada ascendentemente.")
    public void whenGivingAnUserIdAndAscendingOrderByQueryParam_getSellerFollowers_ShouldGetAnAscendentListOfFollowers() {

        // Arrange
        User user = TestUtil.getUserWithFollowers(true);
        User user1 = TestUtil.getSellerUser("Facundo", 2);
        User user2 = TestUtil.getSellerUser("Raul", 3);

        when(userRepository.getUserById(1)).thenReturn(user);
        when(userRepository.getUserById(2)).thenReturn(user1);
        when(userRepository.getUserById(3)).thenReturn(user2);

        UserFollowersResponseDto expectedResult = TestUtil.getUserFollowersResponseDto(user, user1, user2);

        // Act
        UserFollowersResponseDto actual = userService.getSellerFollowersDto(1, Parameter.getString("NameAsc"));
        // Assert 
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T4 se obtiene lista de los seguidores de un usuario ordenada descendente.")
    public void whenGivingAnUserIdAndDescendingOrderByQueryParam_getSellerFollowers_ShouldGetADescendentListOfFollowers() {

        // Arrange
        User user = TestUtil.getUserWithFollowers(true);
        User user1 = TestUtil.getSellerUser("Facundo", 2);
        User user2 = TestUtil.getSellerUser("Raul", 3);

        when(userRepository.getUserById(1)).thenReturn(user);
        when(userRepository.getUserById(2)).thenReturn(user1);
        when(userRepository.getUserById(3)).thenReturn(user2);

        UserFollowersResponseDto expectedResult = TestUtil.getUserFollowersResponseDto(user, user2, user1);

        // Act
        UserFollowersResponseDto actual = userService.getSellerFollowersDto(1, Parameter.getString("NameDesc"));
        // Assert
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T4 se obtiene lista de los que un usuario sigue ordenada ascendente.")
    public void whenGivingAnUserIdAndAscendingOrderByQueryParam_getSellerFolloweds_ShouldGetAnAscendentListOfFolloweds() {

        // Arrange
        User user = TestUtil.getUserWithFollowed(true);
        User user1 = TestUtil.getSellerUser("Facundo", 2);
        User user2 = TestUtil.getSellerUser("Raul", 3);

        when(userRepository.getUserById(1)).thenReturn(user);
        when(userRepository.getUserById(2)).thenReturn(user1);
        when(userRepository.getUserById(3)).thenReturn(user2);

        UserFollowedResponseDto expectedResult = TestUtil.getUserFollowedResponseDto(user, user1, user2);

        // Act
        UserFollowedResponseDto actual = userService.getFollowedDto(1, Parameter.getString("NameAsc"));
        // Assert
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T4 se obtiene lista de los que un usuario sigue ordenada descendente.")
    public void whenGivingAnUserIdAndDescendentOrderByQueryParam_getSellerFolloweds_ShouldGetADescendentListOfFolloweds() {

        // Arrange
        User user = TestUtil.getUserWithFollowed(true);
        User user1 = TestUtil.getSellerUser("Facundo", 2);
        User user2 = TestUtil.getSellerUser("Raul", 3);

        when(userRepository.getUserById(1)).thenReturn(user);
        when(userRepository.getUserById(2)).thenReturn(user1);
        when(userRepository.getUserById(3)).thenReturn(user2);

        UserFollowedResponseDto expectedResult = TestUtil.getUserFollowedResponseDto(user, user2, user1);

        // Act
        UserFollowedResponseDto actual = userService.getFollowedDto(1, Parameter.getString("NameDesc"));
        // Assert
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T3 Se lanza excepción si el orden es inválido en getFollowed.")
    public void whenAnInvalidContentOfQueryParamIsReceived_getFolloweds_ShouldThrowException() {
        // Arrange
        User user = TestUtil.getUserWithFollowed(true);

        when(userRepository.getUserById(1)).thenReturn(user);

        // Act y Assert
        assertThrows(InvalidQueryParamValueException.class, () -> userService.getFollowedDto(1, Parameter.getString("InvalidOrder")));
    }

    @Test
    @DisplayName("T3 Se lanza excepción si el orden es inválido en getSellerFollowers.")
    public void whenAnInvalidContentOfQueryParamIsReceived_getFollowers_ShouldThrowException() {
        // Arrange
        User user = TestUtil.getUserWithFollowed(true);

        when(userRepository.getUserById(1)).thenReturn(user);

        // Act y Assert
        assertThrows(InvalidQueryParamValueException.class, () -> userService.getSellerFollowersDto(1, Parameter.getString("InvalidOrder")));
    }

    @Test
    @DisplayName("T3 se obtiene lista de los que un usuario sigue ordenada ascendentemente (por defecto).")
    public void whenNoQueryParamIsReceived_getFollowed_ShouldOrderTheListAscendently() {

        // Arrange
        User user = TestUtil.getUserWithFollowed(true);
        User user1 = TestUtil.getSellerUser("Facundo", 2);
        User user2 = TestUtil.getSellerUser("Raul", 3);

        when(userRepository.getUserById(1)).thenReturn(user);
        when(userRepository.getUserById(2)).thenReturn(user1);
        when(userRepository.getUserById(3)).thenReturn(user2);

        UserFollowedResponseDto expectedResult = TestUtil.getUserFollowedResponseDto(user, user1, user2);

        // Act
        UserFollowedResponseDto actual = userService.getFollowedDto(1, null);
        // Assert
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T3 se obtiene lista de seguidores de un usuario ordenada ascendentemente (por defecto).")
    public void whenNoQueryParamIsReceived_getFollowers_ShouldOrderTheListAscendently() {

        // Arrange
        User user = TestUtil.getUserWithFollowers(true);
        User user1 = TestUtil.getSellerUser("Facundo", 2);
        User user2 = TestUtil.getSellerUser("Raul", 3);

        when(userRepository.getUserById(1)).thenReturn(user);
        when(userRepository.getUserById(2)).thenReturn(user1);
        when(userRepository.getUserById(3)).thenReturn(user2);

        UserFollowersResponseDto expectedResult = TestUtil.getUserFollowersResponseDto(user, user1, user2);

        // Act
        UserFollowersResponseDto actual = userService.getSellerFollowersDto(1, null);
        // Assert
        assertEquals(expectedResult, actual);
    }

    @Test
    @DisplayName("T7 se obtiene cantidad de seguidores que tiene un vendedor")
    void shouldReturnRealAmountOfFollowers() {

        // Arrange
        int id = 1;
        int expected = 2;

        when(userRepository.getUserById(id)).thenReturn(TestUtil.getUserWithFollowers(true));

        // Act
        int actual = userService.getFollowersCountDto(id).getFollowersCount();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T7 se lanza excepcion si el usuario a consultar no existe")
    void whenGetAnInvalidUserId_ThenThrowNotFoundException() {

        // Arrange
        int id = 1;
        String expectedMessage = Parameter.getString("EX_NotExistentUser");

        when(userRepository.getUserById(id)).thenReturn(null);

        // Act
        NotFoundException actual = assertThrows(NotFoundException.class, () -> userService.getFollowersCountDto(id).getFollowersCount());

        // Assert
        assertEquals(actual.getMessage(), expectedMessage);
    }

    @Test
    @DisplayName("T7 se lanza excepcion si el usuario a consultar no es vendedor")
    void ifIsNotASeller_ThenThrowBadRequestException() {

        // Arrange
        int id = 1;
        String expectedMessage = Parameter.getString("EX_NotASeller");

        when(userRepository.getUserById(id)).thenReturn(TestUtil.getUserWithFollowers(false));

        // Act
        BadRequestException actual = assertThrows(BadRequestException.class, () -> userService.getFollowersCountDto(id).getFollowersCount());

        // Assert
        assertEquals(actual.getMessage(), expectedMessage);
    }
}