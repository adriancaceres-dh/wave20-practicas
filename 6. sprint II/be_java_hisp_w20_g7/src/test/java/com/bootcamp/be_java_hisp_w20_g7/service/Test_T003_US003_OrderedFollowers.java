package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.exception.OrderNotValidException;
import com.bootcamp.be_java_hisp_w20_g7.repository.FollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g7.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Test_T003_US003_OrderedFollowers {

    @Mock
    FollowRepository followRepository;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("Test de validacion de orden descendente por nombre")
    public void userFollowersValidDescOrderTest() {
        // Arrange
        int id = 1;
        boolean processOk = true;
        String order = "name_desc";
        when(userRepository.findById(1)).thenReturn(TestUtils.usersTest().get(4));

        // Act
        try {
            userService.userFollowers(id, order);
        } catch (OrderNotValidException e) {
            processOk = false;
        }

        // Assert
        Assertions.assertTrue(processOk);

    }

    @Test
    @DisplayName("Test de validacion de orden ascendente por nombre")
    public void userFollowersValidAscOrderTest() {
        // Arrange
        int id = 1;
        boolean processOk = true;
        String order = "name_asc";
        when(userRepository.findById(1)).thenReturn(TestUtils.usersTest().get(4));

        // Act
        try {
            userService.userFollowers(id, order);
        } catch (OrderNotValidException e) {
            processOk = false;
        }

        // Assert
        Assertions.assertTrue(processOk);

    }


}
