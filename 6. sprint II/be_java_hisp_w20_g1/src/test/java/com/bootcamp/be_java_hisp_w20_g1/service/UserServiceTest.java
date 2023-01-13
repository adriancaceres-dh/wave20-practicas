package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseDto;
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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

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

    static ObjectWriter writer;
    static User validUser = new User(1,"noahHoah",new HashSet<>(),new HashSet<>(),new HashSet<>(),true);
    static User validUserToFollow = new User(2,"elzaTlza",new HashSet<>(),new HashSet<>(),new HashSet<>(),true);
    @BeforeEach
    public void setUp() {
        this.writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void whenGivingValidUserId_followUser_ShouldFollowUser() throws Exception {

        //Arrange
        when(userRepository.getUserById(1)).thenReturn(validUser);
        when(userRepository.getUserById(2)).thenReturn(validUserToFollow);

        UserResponseDto userResponseDto = new UserResponseDto(validUserToFollow.getId(),validUserToFollow.getName());
        UserFollowedResponseDto userFollowedResponseDto = new UserFollowedResponseDto(validUser.getId(),validUser.getName(), List.of(userResponseDto));

        String expectedDTO = writer.writeValueAsString(userFollowedResponseDto);

        //Act
        validUser.getFollowed().add(validUserToFollow.getId());
        String actualDTO = writer.writeValueAsString(userService.followUser(1,2));

        //Assert
        Assertions.assertEquals(expectedDTO,actualDTO);

    }

    @Test
    void whenGivingInvalidUserId_followUser_ShouldThrowNotFoundException() throws Exception {

        //Arrange
        String expectedErrorMessage = "El usuario no existe";
        when(userRepository.getUserById(1)).thenReturn(validUser);
        when(userRepository.getUserById(99)).thenReturn(null);
        validUser.getFollowed().add(validUserToFollow.getId());

        //Act && Assert
        NotFoundException notFoundException = Assertions.assertThrows(NotFoundException.class, () -> userService.followUser(1,99));
        Assertions.assertEquals(expectedErrorMessage,notFoundException.getMessage());
    }

}