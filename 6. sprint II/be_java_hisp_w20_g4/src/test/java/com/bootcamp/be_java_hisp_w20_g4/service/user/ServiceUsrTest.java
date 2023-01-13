package com.bootcamp.be_java_hisp_w20_g4.service.user;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g4.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceUsrTest {

    @Mock
    IUserRepository mockUserRepository;

    @InjectMocks
    ServiceUsr mockServiceUser;

    @Test
    @DisplayName("Test user to follow exists ok")
    void followOKTest() {
        // arrange
        Buyer userFollow = new Buyer(1, "user which follows");
        Seller sellerToFollow = new Seller(2, "userTofollow");
        when(mockUserRepository.findById(userFollow.getUser_id())).thenReturn(userFollow);
        when(mockUserRepository.findById(sellerToFollow.getUser_id())).thenReturn(sellerToFollow);

        List<ListedUserDTO> followedExpected = List.of(new ListedUserDTO(sellerToFollow.getUser_id(),sellerToFollow.getUser_name()));
        UserFollowedDTO expected = new UserFollowedDTO(userFollow.getUser_id(),userFollow.getUser_name(), followedExpected);

        // act
        UserFollowedDTO result = mockServiceUser.follow(userFollow.getUser_id(), sellerToFollow.getUser_id());

        // assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test user to follow doesn't exist. Throw exception")
    void followInvalidIDTest() {
        // arrange
        Buyer userFollow = new Buyer(1, "user which follows");
        Seller sellerToFollow = new Seller(2, "userTofollow");
        when(mockUserRepository.findById(userFollow.getUser_id())).thenReturn(userFollow);
        when(mockUserRepository.findById(sellerToFollow.getUser_id())).thenReturn(null);

        // act && assert
        Assertions.assertThrows(BadRequestException.class, () ->{mockServiceUser.follow(userFollow.getUser_id(), sellerToFollow.getUser_id());});
    }

    @Test
    void followersCountOKTest() {
    }

    @Test
    void followersOrderAscOKTest() {
    }

    @Test
    void followersOrderDescOKTest() {
    }

    @Test
    void followersInvalidOrderTest() {
    }

    @Test
    void followedOrderAscOKTest() {
    }

    @Test
    void followedOrderDescOKTest() {
    }

    @Test
    void followedInvalidOrderTest() {
    }

    @Test
    void unfollowOKTest() {
    }

    @Test
    void unfollowInvalidIDTest() {
    }
}