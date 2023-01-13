package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import lombok.experimental.Wither;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock
    private IUserRepository repository;

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
    }

    @Test
    @DisplayName("Camino feliz en donde existe el usuario buscado por parámetro.")
    void followerListWithUserExist() {
        // Arrange
        UserFollowersCountResponseDTO responseExpected = new UserFollowersCountResponseDTO(2, "Mariano", 3);
        User user = new User("Mariano");
        user.setId(2);
        user.addFollower(new User("Luis"));
        user.addFollower(new User("Francisco"));
        user.addFollower(new User("Lorenzo"));
        // Act
        when(repository.exists(2)).thenReturn(true);
        when(repository.findOne(2)).thenReturn(user);
        UserFollowersCountResponseDTO dtoResult = service.followerList(2);
        // Assert
        assertEquals(responseExpected, dtoResult);
    }

    @Test
    @DisplayName("Camino feliz't en donde no existe el usuario buscado por parámetro.")
    void followerListWithUserNotExist() {
        // Arrange
        BadRequestException responseExpected = new BadRequestException("El usuario no existe");
        User user = new User("Mariano");
        user.setId(2);
        user.addFollower(new User("Luis"));
        user.addFollower(new User("Francisco"));
        user.addFollower(new User("Lorenzo"));

        Exception myExceptionResult = null;
        // Act
        when(repository.exists(2)).thenReturn(false);
        try {
            UserFollowersCountResponseDTO dtoResult = service.followerList(2);
        } catch (BadRequestException ex) {
            myExceptionResult = ex;
        } finally {
            // Assert
            assertEquals(responseExpected.getMessage(), myExceptionResult.getMessage());
        }
    }
}