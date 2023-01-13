package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.publication.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServicePublicationTest {

    @Mock
    IPublicationRepository mockPublicationRepository;

    @Mock
    IUserRepository mockUserRepository;

    @InjectMocks
    ServicePublication mockServicePublication;

    @Test
    void addPublication() {
    }

    @Test
    void getPublicationsOrderAscOKTest() {
    }

    @Test
    void getPublicationsOrderDescOKTest() {
    }

    @Test
    @DisplayName(value = "Parametro de orden correcto")
    void getPublicationsOrderOKTest() {
        //arrange

        User user = new Seller();
        user.setUser_id(1);

        User userFollowed = new Seller();
        userFollowed.setUser_id(2);

        HashMap<Integer,User> followedsMap = new HashMap<>();
        followedsMap.put(1,userFollowed);
        user.setFollowed(followedsMap);

        Publication p1 = new Publication();
        p1.setPost_id(1);
        p1.setUser_id(1);
        List<Publication> publicationList = Arrays.asList(p1);

        List<Integer> followedsId = Arrays.asList(2);

        when(mockPublicationRepository.getPublicationLastNDays(followedsId,15)).thenReturn(publicationList);
        when(mockUserRepository.findById(1)).thenReturn(user);


        ListedPostDTO listedPostDTO = new ListedPostDTO();
        listedPostDTO.setPost_id(1);
        listedPostDTO.setUser_id(1);
        List<ListedPostDTO> listedPostDTOList = Arrays.asList(listedPostDTO);

        ProductTwoWeeksResponseDTO productTwoWeeksResponseDTO = new ProductTwoWeeksResponseDTO(1,listedPostDTOList);

        //act
        ProductTwoWeeksResponseDTO productTwoWeeksResponseDTOFound = mockServicePublication.getLastTwoWeeksPublications(1,"date_asc");

        //assert
        assertEquals(productTwoWeeksResponseDTO,productTwoWeeksResponseDTOFound);

    }

    @Test
    @DisplayName(value = "Parametro de orden incorrecto")
    void getPublicationsInvalidOrderTest() {
        //assert
        assertThrows(BadRequestException.class,()->mockServicePublication.getLastTwoWeeksPublications(1,"date_ASsscc"));
    }

    @Test
    void getLastTwoWeeksPublicationsOKTest() {
    }
}