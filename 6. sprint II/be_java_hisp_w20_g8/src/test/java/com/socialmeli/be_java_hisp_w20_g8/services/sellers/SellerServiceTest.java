package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerFollowersDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import com.socialmeli.be_java_hisp_w20_g8.services.sellers.SellerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

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

}