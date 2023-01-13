package com.socialmeli.be_java_hisp_w20_g8.services.users;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
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

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IPersonRepository personRepository;

    @InjectMocks
    UserService userService;

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

        when(personRepository.checkUser(anyInt())).thenReturn(true);
        when(personRepository.findUserById(anyInt())).thenReturn(new User(userId, "luis_lopez", new HashSet<>()));
        when(personRepository.getAllFollowed(anyInt())).thenReturn(Set.of(6, 7, 8, 9, 10));
        when(personRepository.findSellerById(6)).thenReturn(new Seller(6, "jesus_flores"));
        when(personRepository.findSellerById(7)).thenReturn(new Seller(7, "ana_ortiz"));
        when(personRepository.findSellerById(8)).thenReturn(new Seller(8, "ernesto_llano"));
        when(personRepository.findSellerById(9)).thenReturn(new Seller(9, "jesus_rivera"));
        when(personRepository.findSellerById(10)).thenReturn(new Seller(10, "ana_real"));

        // act
        UserFollowedDTO userFollowedDTO = userService.getAllFollowed(userId, "name_asc");
        List<SellerDTO> actual = userFollowedDTO.getFollowed();

        // assert
        verify(personRepository, atLeastOnce()).getAllFollowed(anyInt());
        assertNotNull(actual);
        assertEquals(expected, actual);
        for(int i = 1; i < actual.size(); i++) {
            assertTrue(actual.get(i-1).getUser_name().compareTo(actual.get(i).getUser_name()) <= 0);
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

        when(personRepository.checkUser(anyInt())).thenReturn(true);
        when(personRepository.findUserById(anyInt())).thenReturn(new User(userId, "luis_lopez", new HashSet<>()));
        when(personRepository.getAllFollowed(anyInt())).thenReturn(Set.of(6, 7, 8, 9, 10));
        when(personRepository.findSellerById(6)).thenReturn(new Seller(6, "jesus_flores"));
        when(personRepository.findSellerById(7)).thenReturn(new Seller(7, "ana_ortiz"));
        when(personRepository.findSellerById(8)).thenReturn(new Seller(8, "ernesto_llano"));
        when(personRepository.findSellerById(9)).thenReturn(new Seller(9, "jesus_rivera"));
        when(personRepository.findSellerById(10)).thenReturn(new Seller(10, "ana_real"));

        // act
        UserFollowedDTO userFollowedDTO = userService.getAllFollowed(userId, "name_desc");
        List<SellerDTO> actual = userFollowedDTO.getFollowed();

        // assert
        verify(personRepository, atLeastOnce()).getAllFollowed(anyInt());
        assertNotNull(actual);
        assertEquals(expected, actual);
        for(int i = 1; i < actual.size(); i++) {
            assertTrue(actual.get(i-1).getUser_name().compareTo(actual.get(i).getUser_name()) >= 0);
        }
    }
}