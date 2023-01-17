package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerFollowersDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserCountDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * This test is used for check the sorting options for the seller service and check the result of the method against a mock
 * and check the amount of followers of a seller
 * @author: Juan Camilo Arango Valle, Luis López Gómez and Julian Atehortua Zapata
 */
@ExtendWith(MockitoExtension.class)
class SellerServiceTest {
    @Mock
    private IPersonRepository personRepository;

    @InjectMocks
    private SellerService sellerService;

    @Test
    @DisplayName("T-0003-> Ascending sort test")
    void testAscSort(){
        //Arrange
        String orderOption = "name_asc";
        int sellerId = 6;
        when(personRepository.findSellerById(anyInt())).thenReturn(new Seller(sellerId, "luis_lopez", Set.of( 3, 4, 5), new HashSet<>()));
        when(personRepository.findUserById(4)).thenReturn(new User(3, "jesus_rivera", new HashSet<>()));
        when(personRepository.findUserById(3)).thenReturn(new User(4, "ernesto_llano", new HashSet<>()));
        when(personRepository.findUserById(5)).thenReturn(new User(5, "ana_real", new HashSet<>()));
        //Action
        SellerFollowersDTO sellerFollowers = sellerService.getSellerFollowers(sellerId,orderOption);

        //assert
        assertNotNull(sellerFollowers);
        assertDoesNotThrow(() ->sellerService.getSellerFollowers(sellerId,orderOption));

    }

    @Test
    @DisplayName("T-0003-> descending sort test")
    void testDescSort(){
        //Arrange
        String orderOption = "name_desc";
        int sellerId = 6;
        when(personRepository.findSellerById(anyInt())).thenReturn(new Seller(sellerId, "luis_lopez", Set.of( 3, 4, 5), new HashSet<>()));
        when(personRepository.findUserById(4)).thenReturn(new User(3, "jesus_rivera", new HashSet<>()));
        when(personRepository.findUserById(3)).thenReturn(new User(4, "ernesto_llano", new HashSet<>()));
        when(personRepository.findUserById(5)).thenReturn(new User(5, "ana_real", new HashSet<>()));
        //Action
        SellerFollowersDTO sellerFollowers = sellerService.getSellerFollowers(sellerId,orderOption);

        //assert
        assertNotNull(sellerFollowers);
        assertDoesNotThrow(() ->sellerService.getSellerFollowers(sellerId,orderOption));


    }
    @Test
    @DisplayName("T-0003-> Invalid sorting option test")
    void badSortingOption(){
        //Arrange
        String orderOption = "not_sorting_option";
        String expectedErrorMessage = "Invalid sorting option";
        int sellerId = 6;
        when(personRepository.findSellerById(anyInt())).thenReturn(new Seller(sellerId, "luis_lopez", Set.of( 3, 4, 5), new HashSet<>()));
        when(personRepository.findUserById(4)).thenReturn(new User(3, "jesus_rivera", new HashSet<>()));
        when(personRepository.findUserById(3)).thenReturn(new User(4, "ernesto_llano", new HashSet<>()));
        when(personRepository.findUserById(5)).thenReturn(new User(5, "ana_real", new HashSet<>()));
        //Action
        Exception exception = assertThrows(InvalidArgumentException.class,()-> sellerService.getSellerFollowers(sellerId,orderOption));
        //Asserts
        assertEquals(expectedErrorMessage,exception.getMessage());
    }

    @Test
    @DisplayName("T-0004 -> Verify the followers sorting in ascending order")
    void getSellerFollowersAsc() {
        // arrange
        int sellerId = 6;
        String order = "name_asc";
        List<UserDTO> expected = List.of(
                new UserDTO(2, "ana_ortiz"),
                new UserDTO(5, "ana_real"),
                new UserDTO(3, "ernesto_llano"),
                new UserDTO(1, "jesus_flores"),
                new UserDTO(4, "jesus_rivera")
        );

        when(personRepository.findSellerById(anyInt())).thenReturn(new Seller(sellerId, "luis_lopez", Set.of(1, 2, 3, 4, 5), new HashSet<>()));
        when(personRepository.findUserById(1)).thenReturn(new User(1, "jesus_flores", new HashSet<>()));
        when(personRepository.findUserById(2)).thenReturn(new User(2, "ana_ortiz", new HashSet<>()));
        when(personRepository.findUserById(3)).thenReturn(new User(3, "ernesto_llano", new HashSet<>()));
        when(personRepository.findUserById(4)).thenReturn(new User(4, "jesus_rivera", new HashSet<>()));
        when(personRepository.findUserById(5)).thenReturn(new User(5, "ana_real", new HashSet<>()));

        // act
        SellerFollowersDTO sellerFollowersDTO = sellerService.getSellerFollowers(sellerId, order);
        List<UserDTO> actual = sellerFollowersDTO.getFollowers();

        // assert
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0004 -> Verify the followers sorting in descending order")
    void getSellerFollowersDesc() {
        // arrange
        int sellerId = 6;
        String order = "name_desc";
        List<UserDTO> expected = List.of(
                new UserDTO(4, "jesus_rivera"),
                new UserDTO(1, "jesus_flores"),
                new UserDTO(3, "ernesto_llano"),
                new UserDTO(5, "ana_real"),
                new UserDTO(2, "ana_ortiz")
        );

        when(personRepository.findSellerById(anyInt())).thenReturn(new Seller(sellerId, "luis_lopez", Set.of(1, 2, 3, 4, 5), new HashSet<>()));
        when(personRepository.findUserById(1)).thenReturn(new User(1, "jesus_flores", new HashSet<>()));
        when(personRepository.findUserById(2)).thenReturn(new User(2, "ana_ortiz", new HashSet<>()));
        when(personRepository.findUserById(3)).thenReturn(new User(3, "ernesto_llano", new HashSet<>()));
        when(personRepository.findUserById(4)).thenReturn(new User(4, "jesus_rivera", new HashSet<>()));
        when(personRepository.findUserById(5)).thenReturn(new User(5, "ana_real", new HashSet<>()));

        // act
        SellerFollowersDTO sellerFollowersDTO = sellerService.getSellerFollowers(sellerId, order);
        List<UserDTO> actual = sellerFollowersDTO.getFollowers();

        // assert
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @DisplayName("T-0007 -> Amount of followers of a user is correct")
    @Test
    public void followersCountTest(){

        //arrange
        int userId = 9;
        UserCountDTO sellExcpected = new UserCountDTO(9,"user1",3);
        when(personRepository.getById(9)).thenReturn(
                new Seller(9,"user1",
                        new HashSet<>(){{add(1);add(2);add(3);}},
                        new HashSet<>()));

        //act
        UserCountDTO sellActual = sellerService.followersCount(userId);

        //assert
        assertEquals(sellExcpected.getFollowers_count(),sellActual.getFollowers_count());
        assertThrows(NotFoundException.class,()->sellerService.followersCount(2));
    }
}