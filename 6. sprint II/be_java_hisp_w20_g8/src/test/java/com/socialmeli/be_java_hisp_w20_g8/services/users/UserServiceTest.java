package com.socialmeli.be_java_hisp_w20_g8.services.users;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import org.assertj.core.condition.Not;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    IPersonRepository mockPersonRepository;

    @InjectMocks
    UserService injectMockUserService;

    @Test
    @DisplayName("T-0001 -> User to follow exists")
    void followServiceTestOK(){

        //Arrange
        int userId = 1;
        int userIdToFollow = 2;
        ResponseDTO expectedResponse = new ResponseDTO(true,"New Follower add successfully");
        when(mockPersonRepository.checkUser(userId)).thenReturn(true);
        when(mockPersonRepository.checkUser(userIdToFollow)).thenReturn(true);
        when(mockPersonRepository.addFollowing(userId, userIdToFollow)).thenReturn(true);
        when(mockPersonRepository.addFollower(userIdToFollow, userId)).thenReturn(true);

        //Act
        ResponseDTO actualResponse = injectMockUserService.addNewFollow(userId,userIdToFollow);
        //Assert
        Assertions.assertEquals(expectedResponse,actualResponse);

    }
    @Test
    @DisplayName("T-0001 ->  User to follow exists but same id's exception")
    void followServiceTestNotOK(){

        //Arrange
        int userId = 2;
        int userIdToFollow = 2;
        String actualMessageError = "";
        String expectedMessageError ="A user can't follow himself";

        //Act
        //Assert
        Exception actualException = Assertions.assertThrows(OperationFailedException.class,()->injectMockUserService.addNewFollow(userId,userIdToFollow));
        Assertions.assertEquals(expectedMessageError,actualException.getMessage());
    }
    @Test
    @DisplayName("T-0001 -> User to follow doesn't exist")
    void followServiceTestNotOKV2(){
        //Arrange
        int userId = 2;
        int userIdToFollow = 3;

        when(mockPersonRepository.checkUser(userId)).thenReturn(true);
        when(mockPersonRepository.checkUser(userIdToFollow)).thenReturn(false);

        //Act
        //Assert
       Assertions.assertThrows(NotFoundException.class,()->injectMockUserService.addNewFollow(userId,userIdToFollow));
       //comparacion delmensaje
    }

    @Test
    @DisplayName("T-0002 ->  User to unfollow exists")
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
    @DisplayName("T-0002 -> Unfollow user exists exception")
    void unfollowServiceNoExistTest() {
        //Arrange
        int userId = 50;
        int sellerId = 60;

        when(mockPersonRepository.checkUser(sellerId)).thenReturn(false);
        when(mockPersonRepository.checkUser(userId)).thenReturn(true);

        //Act and Assert
        Assertions.assertThrows(NotFoundException.class, () -> injectMockUserService.unfollow(userId, sellerId));
    }

    @Test
    @DisplayName("T-0004 -> Verify the followed sorting in ascending order")
    void getAllFollowedAsc() {
        // arrange
        int userId = 2;
        List<SellerDTO> expected = List.of(
                new SellerDTO(7, "ana_ortiz"),
                new SellerDTO(10, "ana_real"),
                new SellerDTO(8, "ernesto_llano"),
                new SellerDTO(6, "jesus_flores"),
                new SellerDTO(9, "jesus_rivera")
        );

        when(mockPersonRepository.checkUser(anyInt())).thenReturn(true);
        when(mockPersonRepository.findUserById(anyInt())).thenReturn(new User(userId, "luis_lopez", new HashSet<>()));
        when(mockPersonRepository.getAllFollowed(anyInt())).thenReturn(Set.of(6, 7, 8, 9, 10));
        when(mockPersonRepository.findSellerById(6)).thenReturn(new Seller(6, "jesus_flores"));
        when(mockPersonRepository.findSellerById(7)).thenReturn(new Seller(7, "ana_ortiz"));
        when(mockPersonRepository.findSellerById(8)).thenReturn(new Seller(8, "ernesto_llano"));
        when(mockPersonRepository.findSellerById(9)).thenReturn(new Seller(9, "jesus_rivera"));
        when(mockPersonRepository.findSellerById(10)).thenReturn(new Seller(10, "ana_real"));

        // act
        UserFollowedDTO userFollowedDTO = injectMockUserService.getAllFollowed(userId, "name_asc");
        List<SellerDTO> actual = userFollowedDTO.getFollowed();

        // assert
        verify(mockPersonRepository, atLeastOnce()).getAllFollowed(anyInt());
        assertNotNull(actual);
        assertEquals(expected, actual);
        for (int i = 1; i < actual.size(); i++) {
            assertTrue(actual.get(i - 1).getUser_name().compareTo(actual.get(i).getUser_name()) <= 0);
        }
    }

    @Test
    @DisplayName("T-0004 -> Verify the followed sorting in descending order")
    void getAllFollowedDesc() {
        // arrange
        int userId = 2;
        List<SellerDTO> expected = List.of(
                new SellerDTO(9, "jesus_rivera"),
                new SellerDTO(6, "jesus_flores"),
                new SellerDTO(8, "ernesto_llano"),
                new SellerDTO(10, "ana_real"),
                new SellerDTO(7, "ana_ortiz")
        );

        when(mockPersonRepository.checkUser(anyInt())).thenReturn(true);
        when(mockPersonRepository.findUserById(anyInt())).thenReturn(new User(userId, "luis_lopez", new HashSet<>()));
        when(mockPersonRepository.getAllFollowed(anyInt())).thenReturn(Set.of(6, 7, 8, 9, 10));
        when(mockPersonRepository.findSellerById(6)).thenReturn(new Seller(6, "jesus_flores"));
        when(mockPersonRepository.findSellerById(7)).thenReturn(new Seller(7, "ana_ortiz"));
        when(mockPersonRepository.findSellerById(8)).thenReturn(new Seller(8, "ernesto_llano"));
        when(mockPersonRepository.findSellerById(9)).thenReturn(new Seller(9, "jesus_rivera"));
        when(mockPersonRepository.findSellerById(10)).thenReturn(new Seller(10, "ana_real"));

        // act
        UserFollowedDTO userFollowedDTO = injectMockUserService.getAllFollowed(userId, "name_desc");
        List<SellerDTO> actual = userFollowedDTO.getFollowed();

        // assert
        verify(mockPersonRepository, atLeastOnce()).getAllFollowed(anyInt());
        assertNotNull(actual);
        assertEquals(expected, actual);
        for (int i = 1; i < actual.size(); i++) {
            assertTrue(actual.get(i - 1).getUser_name().compareTo(actual.get(i).getUser_name()) >= 0);
        }
    }
}