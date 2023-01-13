package com.socialmeli.be_java_hisp_w20_g8.services.users;

import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    IPersonRepository mockPersonRepository;

    @InjectMocks
    UserService injectMockUserService;

    @Test
    @DisplayName("T-0002 Camino Feliz ....")
    void unfollowServiceTest() {
        //Arrange
        int userId = 1;
        int sellerId = 6;
        User user = new User(userId, "user1", new HashSet<>() {{
            add(5);
            add(6);
            add(9);
        }});

        Seller seller = new Seller(sellerId, "seller4", new HashSet<>() {{
            add(1);
        }}, new HashSet<>() {{
            add(4);
        }});

        ResponseDTO expectedResponseDTO = new ResponseDTO(true, "you have unfollowed the user");

        when(mockPersonRepository.checkUser(user.getId())).thenReturn(true);
        when(mockPersonRepository.checkUser(seller.getId())).thenReturn(true);
        when(mockPersonRepository.unfollowing(user.getId(), seller.getId())).thenReturn(true);
        when(mockPersonRepository.unfollower(seller.getId(), user.getId())).thenReturn(true);

        //Act
        ResponseDTO actualResponseDTO = injectMockUserService.unfollow(user.getId(), seller.getId());

        //Assert
        Assertions.assertEquals(expectedResponseDTO, actualResponseDTO);

    }

    @Test
    void unfollowServiceNoExistTest() {
        //Arrange
        int userId = 50;
        int sellerId = 60;

        when(mockPersonRepository.checkUser(sellerId)).thenReturn(false);
        when(mockPersonRepository.checkUser(userId)).thenReturn(true);

        //Act and Assert
        Assertions.assertThrows(NotFoundException.class, () -> injectMockUserService.unfollow(userId, sellerId));
    }
}