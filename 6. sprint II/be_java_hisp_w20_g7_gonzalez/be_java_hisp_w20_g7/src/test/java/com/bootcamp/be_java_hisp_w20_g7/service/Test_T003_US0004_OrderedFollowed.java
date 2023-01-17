package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.exception.OrderNotValidException;
import com.bootcamp.be_java_hisp_w20_g7.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IUserRepository;
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
public class Test_T003_US0004_OrderedFollowed {

    @Mock
    IUserRepository userRepository;
    @Mock
    IFollowRepository followRepository;
    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("T003 Orden ascendente existe")
    public void userFollowedAscOrderOK() {
        // Arrange
        int userId = 5;
        String order = "name_asc";
        boolean existe = true;
        when(userRepository.findById(5)).thenReturn(TestUtils.usersTest().get(4));

        // Act
        if (order.equals("name_asc")) {
            userService.userFollowed(userId, order);
        } else {
            existe = false;
        }

        // Assert
        Assertions.assertTrue(existe);
    }

    @Test
    @DisplayName("T003 Orden descendente existe")
    public void userFollowedDescOrderOK() {
        // Arrange
        int userId = 5;
        String order = "name_desc";
        boolean existe = true;
        when(userRepository.findById(5)).thenReturn(TestUtils.usersTest().get(4));

        // Act
        if (order.equals("name_desc")) {
            userService.userFollowed(userId, order);
        } else {
            existe = false;
        }

        // Assert
        Assertions.assertTrue(existe);
    }



    @Test
    @DisplayName("T003 Orden no existe")
    public void userFollowedOrderNotExist() {
        // Arrange
        int id = 1;
        String order = "order";
        when(userRepository.findById(1)).thenReturn(TestUtils.usersTest().get(4));

        // Act & Assert
        Assertions.assertThrows(OrderNotValidException.class, () -> userService.userFollowers(id, order));
    }
}