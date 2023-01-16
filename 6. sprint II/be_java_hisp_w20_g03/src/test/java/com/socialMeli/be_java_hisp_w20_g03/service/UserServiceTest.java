package com.socialMeli.be_java_hisp_w20_g03.service;


import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.BadRequestException;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import com.socialMeli.be_java_hisp_w20_g03.utils.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static com.socialMeli.be_java_hisp_w20_g03.utils.UserUtils.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("T-0001: Permite continuar con normalidad.")
    void addFollower() {
        //Arrange
        int idRequestUser = 234;
        int idRequestUser2 = 6631;
        User user1 = UserUtils.getUserAddFollower(idRequestUser);
        User user2 = UserUtils.getUserAddFollower(idRequestUser2);
        String expected = "Comenzaste a seguir al usuario: " + user2.getUserName();
        when(userRepository.getUserById(idRequestUser)).thenReturn(user1);
        when(userRepository.getUserById(idRequestUser2)).thenReturn(user2);
        //Act
        String result = userService.addFollower(idRequestUser,idRequestUser2);
        // assert
        Assertions.assertEquals(expected,result);
    }
    @Test
    @DisplayName("T-0001: Verificando la excepcion cuando el usuario no existe.")
    void addFollowerThrowsNotFoundException() {
        //Arrange
        int idRequestUser = 23;
        int idRequestUser2 = 6631;
        //Act y Assert
        Assertions.assertThrows(NotFoundException.class,()-> userService.addFollower(idRequestUser,idRequestUser2));
    }

    @Test
    @DisplayName("T-0007: Cantidad de seguidores adecuada.")
    void getFollowerCount() {
        //Arrange
        User user = UserUtils.buildUserWithFollowers();
        when(userRepository.getUserById(anyInt())).thenReturn(user);

        //Act
        UserFollowerCountDTO output = userService.getFollowerCount(user.getUserId());

        //Assert
        verify(userRepository, atLeastOnce()).getUserById(user.getUserId());
        assertEquals(3,output.getFollowers_count());

    }

    @Test
    @DisplayName("T-0007: Usuario inexistente")
    void getFollowerCountUserDoesntExists() {
        //Arrange
        when(userRepository.getUserById(anyInt())).thenReturn(null);

        //Act & Assert
        assertThrows(NotFoundException.class, ()->userService.getFollowerCount(1));
    }

    @Test
    @DisplayName("T-0004: Camino Feliz")
    void getFollowersListOrderDesc() {
        //arrange
        int userId = 234;
        UserFollowersDTO expect = buildListUserFollowedDtoDesc();
        User user = UserUtils.buildUserWithFollowers();
        when(userRepository.getUserById(userId)).thenReturn(user);
        //act
        UserFollowersDTO actual = userService.getFollowersList(234,"name_desc");
        //assert
        verify(userRepository, atLeastOnce()).getUserById(userId);
        assertEquals(expect,actual);
    }
    @Test
    @DisplayName("T-0004: Camino Feliz")
    void getFollowersListOrderAsc() {
        //arrange
        int userId = 234;
        UserFollowersDTO expect = buildListUserFollowedDtoAsc();
        User user = UserUtils.buildUserWithFollowers();
        when(userRepository.getUserById(userId)).thenReturn(user);
        //act
        UserFollowersDTO actual = userService.getFollowersList(234,"name_asc");
        //assert
        verify(userRepository, atLeastOnce()).getUserById(userId);
        assertEquals(expect,actual);
    }
    @Test
    @DisplayName("T-0003: Camino Feliz, orden de forma asc")
    void getFollowersListOrderAscOK() {
        //arrange
        int userId = 234;
        User user = UserUtils.buildUserWithFollowers();
        when(userRepository.getUserById(userId)).thenReturn(user);
        //act
        UserFollowersDTO actual = userService.getFollowersList(userId,"name_asc");
        //assert
        verify(userRepository, atLeastOnce()).getUserById(userId);
        assertNotNull(actual);
    }
    @Test
    @DisplayName("T-0003: Camino Feliz, orden de forma desc")
    void getFollowersListOrderDescOK() {
        //arrange
        int userId = 234;
        User user = UserUtils.buildUserWithFollowers();
        when(userRepository.getUserById(userId)).thenReturn(user);
        //act
        UserFollowersDTO actual = userService.getFollowersList(userId,"name_desc");
        //assert
        verify(userRepository, atLeastOnce()).getUserById(userId);
        assertNotNull(actual);
    }
    @Test
    @DisplayName("T-0004: Excepción cuando el usuario no existe")
    void getFollowersListUserNotFound() {
        //arrange
        when(userRepository.getUserById(000)).thenThrow(NotFoundException.class);
        //assert
        assertThrows(NotFoundException.class, ()->userService.getFollowersList(000,null));
    }
    @Test
    @DisplayName("T-0003: Excepción cuando ingresa un orden incorrecto")
    void getFollowersListUserNotFoundOrder() {
        //arrange
        when(userRepository.getUserById(234)).thenThrow(BadRequestException.class);
        //assert
        assertThrows(BadRequestException.class, ()->userService.getFollowersList(234,"name_null"));
    }

    @DisplayName("T-0002: Permite continuar con normalidad.")
    @Test
    void unfollowOk() {
        //arrange
        int userIdFollower = 234;
        int userIdToUnfollow = 6631;

        User user = UserUtils.buildUserWithFollowers();
        User user2 = user.getFollowed().get(0);

        when(userRepository.getUserById(userIdFollower)).thenReturn(user);
        when(userRepository.getUserById(userIdToUnfollow)).thenReturn(user2);

        String expectedString = "Dejaste de seguir al usuario: " + user2.getUserName();

        //Act
        String unfollowResponse = userService.unfollow(userIdFollower,userIdToUnfollow);

        //Assert
        assertEquals(expectedString,unfollowResponse);

    }
    @DisplayName("T-0002: Usuario no existe.")
    @Test
    void unfollowUserNotFound() {
        //arrange
        int userIdFollower = 234;
        int userIdToUnfollow = 6631;

        //Act
        when(userRepository.getUserById(userIdFollower)).thenReturn(null);
        //Assert
        assertThrows(NotFoundException.class, ()->userService.unfollow(userIdFollower,userIdToUnfollow));
    }
    @DisplayName("T-0002: Usuario no es seguido")
    @Test
    void unfollowUserNotFollowed() {
        int userIdFollower = 234;
        int userIdToUnfollow = 6631;

        User user = UserUtils.buildUserWithFollowers();
        User user2 = UserUtils.getUserAddFollower(userIdToUnfollow);
        //Act
        when(userRepository.getUserById(userIdFollower)).thenReturn(user);
        when(userRepository.getUserById(userIdToUnfollow)).thenReturn(user2);

        //Assert
        assertThrows(BadRequestException.class, ()->userService.unfollow(userIdFollower,userIdToUnfollow));
    }
}
