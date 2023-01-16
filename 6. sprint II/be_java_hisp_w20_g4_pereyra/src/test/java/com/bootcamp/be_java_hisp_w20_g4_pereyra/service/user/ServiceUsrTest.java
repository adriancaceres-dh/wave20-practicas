package com.bootcamp.be_java_hisp_w20_g4_pereyra.service.user;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.user.UserFollowersDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.User;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.user.IUserRepository;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceUsrTest {

    @Mock
    IUserRepository mockUserRepository;

    @InjectMocks
    ServiceUsr mockServiceUser;

    private Seller seller;
    private Buyer buyer;

    @BeforeEach
     void setUp(){
        seller = new Seller(1, "Vendedor");
        buyer = new Buyer(2, "nina");
        seller.addUserToMyFollowersList(buyer);
        seller.addUserToMyFollowersList(new Buyer(3, "ani"));
        seller.addUserToMyFollowersList(new Buyer(4, "nino"));

        seller.addUserToMyFollowedList(new Seller(5, "joaquin"));
        seller.addUserToMyFollowedList(new Seller(6, "rodri"));
    }

    @Test
    @DisplayName("T-0001 Verificar que el usuario a seguir exista")
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
    @DisplayName("T-0001 Verificar que el usuario a seguir no existe. Lanza excepción")
    void followInvalidIDTest() {
        // arrange
        Buyer userFollow = new Buyer(10, "user which follows");
        when(mockUserRepository.findById(userFollow.getUser_id())).thenReturn(userFollow);
        when(mockUserRepository.findById(seller.getUser_id())).thenReturn(null);

        // act && assert
        Assertions.assertThrows(BadRequestException.class, () ->{mockServiceUser.follow(userFollow.getUser_id(), seller.getUser_id());});
    }

    @Test
    @DisplayName("T-0007 - Verificar la cantidad de seguidores")
    void followersCountOKTest() {
        //arrange
        UserCountDTO expected = new UserCountDTO(1, "Vendedor", 3);
        when(mockUserRepository.findById(1)).thenReturn(seller);
        //act
        UserCountDTO result = mockServiceUser.followersCount(1);
        //assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0003 - Verificar que el orden exista. Orden name_asc")
    void followersOrderAscOKTest() {
        //arrange
        List<ListedUserDTO> listedUserExpected = seller.getFollowers()
                .values().stream().sorted(Comparator.comparing(User::getUser_name))
                .map(s -> mockServiceUser.mapper.map(s, ListedUserDTO.class))
                .collect(Collectors.toList());
        UserFollowersDTO expected = new UserFollowersDTO(1,"Vendedor", listedUserExpected);
        when(mockUserRepository.findById(1)).thenReturn(seller);
        //act
        UserFollowersDTO actual = mockServiceUser.followers(1, "name_asc");

        //assert
        Assertions.assertEquals(expected, actual);

    }
    @Test
    @DisplayName("T-0003 - Verificar que el orden exista. Orden name_desc")
    void followersOrderDescOKTest() {
        //arrange
        List<ListedUserDTO> listedUserExpected = seller.getFollowers()
                .values().stream().sorted(Comparator.comparing(User::getUser_name))
                .map(s -> mockServiceUser.mapper.map(s, ListedUserDTO.class))
                .collect(Collectors.toList());

        Collections.reverse(listedUserExpected);
        UserFollowersDTO expected = new UserFollowersDTO(1,"Vendedor", listedUserExpected);

        when(mockUserRepository.findById(1)).thenReturn(seller);

        //act
        UserFollowersDTO result = mockServiceUser.followers(1, "name_desc");

        //assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("T-0003 - Verificar que el orden exista. Orden inválido")
    void followersInvalidOrderTest() {
        //assert
       assertThrows(BadRequestException.class, ()->mockServiceUser.followers(1, "aaa"));

    }

    @Test
    @DisplayName("T-0004 - Verificar el ordenamiento ascendente por nombre")
    void followedOrderAscOKTest() {
        //Arrage
        List<ListedUserDTO> expectedList = new ArrayList<>();
        expectedList = seller.getFollowed().values().stream().sorted(Comparator.comparing(User::getUser_name)).map(s -> mockServiceUser.mapper.map(s, ListedUserDTO.class)).collect(Collectors.toList());

        UserFollowedDTO expected = new UserFollowedDTO(1,"Vendedor",expectedList);

        when(mockUserRepository.findById(1)).thenReturn(seller);
        //Act
        UserFollowedDTO result = mockServiceUser.followed(1,"name_asc");
        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("T-0004 - Verificar el ordenamiento descendente por nombre")
    void followedOrderDescOKTest() {
        //Arrage
        List<ListedUserDTO> expectedList = new ArrayList<>();
        expectedList = seller.getFollowed().values().stream().sorted(Comparator.comparing(User::getUser_name)).map(s -> mockServiceUser.mapper.map(s, ListedUserDTO.class)).collect(Collectors.toList());
        Collections.reverse(expectedList);
        UserFollowedDTO expected = new UserFollowedDTO(1,"Vendedor",expectedList);

        when(mockUserRepository.findById(1)).thenReturn(seller);
        //Act
        UserFollowedDTO result = mockServiceUser.followed(1,"name_desc");
        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("UT-0003 - Verificar que el orden exista. Orden inválido")
    void followedInvalidOrderTest() {
        assertThrows(BadRequestException.class, ()-> mockServiceUser.followed(1, "aaa") );
    }

    @Test
    @DisplayName("T-0002 -  verificar que el usuario a dejar de seguir exista")
    void unfollowOKTest() {
        //arrange
        buyer.addUserToMyFollowedList(seller);
        seller.addUserToMyFollowersList(buyer);

        UserFollowedDTO expected = new UserFollowedDTO(2, "nina", new ArrayList<>());

        when(mockUserRepository.findById(1)).thenReturn(seller);
        when(mockUserRepository.findById(2)).thenReturn(buyer);
        //act
        UserFollowedDTO result = mockServiceUser.unfollow(2,1);
        //assert
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("T-0002 -  verificar que el usuario a dejar de seguir exista")
    void unfollowInvalidIDTest() {
        //arrange

        when(mockUserRepository.findById(2)).thenReturn(buyer);
        when(mockUserRepository.findById(20)).thenReturn(null);
        //act & assert
        assertThrows(BadRequestException.class, () -> mockServiceUser.unfollow(2, 20));
    }
}