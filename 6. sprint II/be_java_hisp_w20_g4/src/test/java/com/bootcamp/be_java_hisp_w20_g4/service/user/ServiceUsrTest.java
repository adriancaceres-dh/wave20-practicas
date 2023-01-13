package com.bootcamp.be_java_hisp_w20_g4.service.user;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.junit.jupiter.api.Assertions;

import com.bootcamp.be_java_hisp_w20_g4.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import com.bootcamp.be_java_hisp_w20_g4.model.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

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

    private Seller createSeller(){
        Seller seller1 = new Seller();
        seller1.setUser_name("rodri");
        seller1.setUser_id(1);

        Seller seller2 = new Seller();
        seller2.setUser_name("Tammi");
        seller2.setUser_id(6);

        Seller seller3 = new Seller();
        seller3.setUser_name("Daniela");
        seller3.setUser_id(10);

        Seller seller4 = new Seller();
        seller4.setUser_name("Julieta");
        seller4.setUser_id(7);

        HashMap<Integer, User> followed = new HashMap<>();
        followed.put(6,seller2);
        followed.put(7,seller3);
        followed.put(10,seller4);

        seller1.setFollowed(followed);
        return seller1;

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
        Seller sellerCreate = createSeller();

        List<ListedUserDTO> expectedList = new ArrayList<>();
        expectedList.add(new ListedUserDTO(10,"Daniela"));
        expectedList.add(new ListedUserDTO(7,"Julieta"));
        expectedList.add(new ListedUserDTO(6,"Tammi"));

        UserFollowedDTO expected =  new UserFollowedDTO(1,"rodri",expectedList);

        when(mockUserRepository.findById(1)).thenReturn(sellerCreate);

        UserFollowedDTO result = mockServiceUser.followed(1,"name_asc");

        Assertions.assertEquals(expected,result);
    }

    @Test
    void followedOrderDescOKTest() {
        Seller sellerCreate = createSeller();
        List<ListedUserDTO> expectedList = new ArrayList<>();
        expectedList.add(new ListedUserDTO(6,"Tammi")); //Tammi
        expectedList.add(new ListedUserDTO(7,"Julieta")); //Julieta
        expectedList.add(new ListedUserDTO(10,"Daniela"));//Daniela

        UserFollowedDTO expected =  new UserFollowedDTO(1,"rodri",expectedList);

        when(mockUserRepository.findById(1)).thenReturn(sellerCreate);

        UserFollowedDTO result = mockServiceUser.followed(1,"name_desc");

        Assertions.assertEquals(expected,result);
    }

    @Test
    void followedInvalidOrderTest() {
    }

    @Test
    void unfollowOKTest() {
        Buyer userWhoUnfollow = new Buyer(1, "nombre1");
        Seller userUnfollowed = new Seller(2, "nombre2");
        userWhoUnfollow.addUserToMyFollowedList(userUnfollowed);
        userUnfollowed.addUserToMyFollowersList(userWhoUnfollow);

        UserFollowedDTO expected = new UserFollowedDTO(1, "nombre1", new ArrayList<>()); //No sigue a nadie

        when(mockUserRepository.findById(1)).thenReturn(userWhoUnfollow);
        when(mockUserRepository.findById(2)).thenReturn(userUnfollowed);

        UserFollowedDTO result = mockServiceUser.unfollow(1,2);

        assertEquals(expected, result);

    }

    @Test
    void unfollowInvalidIDTest() {

        Buyer userWhoUnfollow = new Buyer(1, "nombre1");

        when(mockUserRepository.findById(1)).thenReturn(userWhoUnfollow);
        when(mockUserRepository.findById(2)).thenReturn(null);

        assertThrows(BadRequestException.class, () -> mockServiceUser.unfollow(1, 2));
    }
}