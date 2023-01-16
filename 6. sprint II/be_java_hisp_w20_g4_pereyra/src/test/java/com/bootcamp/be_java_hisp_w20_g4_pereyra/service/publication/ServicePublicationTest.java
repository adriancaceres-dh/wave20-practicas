package com.bootcamp.be_java_hisp_w20_g4_pereyra.service.publication;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Seller;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.publication.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.user.IUserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.bootcamp.be_java_hisp_w20_g4_pereyra.utils.TestUtils.mapper;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServicePublicationTest {

    @Mock
    IPublicationRepository mockPublicationRepository;

    @Mock
    IUserRepository mockUserRepository;

    @InjectMocks
    ServicePublication mockServicePublication;

    private Publication publication1;

    private Publication publication2;

    private Publication publication3;

    private Seller seller;
    private Buyer buyer;


    @BeforeEach
    void setUp(){
        Product product1 = new Product(
                12, "twingo",
                "gris", "no es un ferrari pero casi",
                "de carrera", "REANULT");

        Category category = new Category(100, "autos");
        publication1 = new Publication(LocalDate.of(2023, 1, 9),
                100.00, product1, category, 10);

        publication2 = new Publication(LocalDate.of(2022, 12, 19),
                100.00, product1, category, 10);
        publication3 = new Publication(LocalDate.of(2021, 6, 9),
                100.00, product1, category, 10);
        seller = new Seller(1,"vendedor");
        seller.addPublication(publication1);
        seller.addPublication(publication2);
        seller.addPublication(publication3);
        buyer = new Buyer(2, "comprador");
        buyer.addUserToMyFollowedList(seller);

    }


    @Test
    @DisplayName("T-0006 - Verificar  las publicaciones de las ultimas 2 semanas en orden ascendente")
    void getPublicationsOrderAscOKTest() {
        //Arrange

        when(mockUserRepository.findById(anyInt())).thenReturn(buyer);

        when(mockPublicationRepository.getPublicationLastNDays(Collections.singletonList(seller.getUser_id()), 15))
                .thenReturn(seller.getPublications().values().stream().sorted(Comparator.comparing(Publication::getDate)).collect(Collectors.toList()));

        List<ListedPostDTO> listedPostDTOList = seller.getPublications().values().stream().sorted(Comparator.comparing(Publication::getDate)).map(publication -> mockServicePublication.mapper.map(publication, ListedPostDTO.class)).collect(Collectors.toList());

        ProductTwoWeeksResponseDTO expected = new ProductTwoWeeksResponseDTO(buyer.getUser_id(), listedPostDTOList);
        //Act
        ProductTwoWeeksResponseDTO response = mockServicePublication.getLastTwoWeeksPublications(1, "date_asc");
        //Assert
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("T-0006 - Verificar publicaciones ultimas 2 semanas orden descendente")
    void getPublicationsOrderDescOKTest() {
        //Arrange

        when(mockUserRepository.findById(2)).thenReturn(buyer);

        when(mockPublicationRepository.getPublicationLastNDays(Collections.singletonList(seller.getUser_id()), 15))
                .thenReturn(seller.getPublications().values().stream().collect(Collectors.toList()));

        List<ListedPostDTO> listedExpectedPosts = new ArrayList<>();

        listedExpectedPosts.add(mockServicePublication.mapper.map(publication3, ListedPostDTO.class));
        listedExpectedPosts.add(mockServicePublication.mapper.map(publication2, ListedPostDTO.class));
        listedExpectedPosts.add(mockServicePublication.mapper.map(publication1, ListedPostDTO.class));
        ProductTwoWeeksResponseDTO expected = new ProductTwoWeeksResponseDTO(2, listedExpectedPosts);
        //Act
        ProductTwoWeeksResponseDTO result = mockServicePublication.getLastTwoWeeksPublications(2, "date_desc");
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName(value = "T-0005 -Parametro de orden correcto (date_asc)")
    void getPublicationsOrderValidAscOKTest() {
        //arrange

        when(mockPublicationRepository.getPublicationLastNDays(Arrays.asList(1),15)).thenReturn(Arrays.asList(publication1,publication2,publication3));
        when(mockUserRepository.findById(2)).thenReturn(buyer);

        ProductTwoWeeksResponseDTO expected = new ProductTwoWeeksResponseDTO(2,seller.getPublications().values().stream().map((x)->mapper.map(x,ListedPostDTO.class)).collect(Collectors.toList()));

        //act
        ProductTwoWeeksResponseDTO result = mockServicePublication.getLastTwoWeeksPublications(2,"date_asc");

        //assert
        assertEquals(expected,result);

    }

    @Test
    @DisplayName(value = "T-0005 -Parametro de orden correcto (date_desc)")
    void getPublicationsOrderValidDescOKTest() {
        //arrange

        when(mockPublicationRepository.getPublicationLastNDays(Arrays.asList(1),15)).thenReturn(Arrays.asList(publication1,publication2,publication3));
        when(mockUserRepository.findById(2)).thenReturn(buyer);

        List<ListedPostDTO> publicationsExpected = seller.getPublications().values().stream().map((x)->mapper.map(x,ListedPostDTO.class)).collect(Collectors.toList());

        Collections.reverse(publicationsExpected);

        ProductTwoWeeksResponseDTO expected = new ProductTwoWeeksResponseDTO(2,publicationsExpected);

        //act
        ProductTwoWeeksResponseDTO result = mockServicePublication.getLastTwoWeeksPublications(2,"date_desc");

        //assert
        assertEquals(expected,result);

    }

    @Test
    @DisplayName(value = "T-0005 - Parametro de orden de fecha incorrecto")
    void getPublicationsInvalidOrderTest() {
        //assert
        assertThrows(BadRequestException.class,()->mockServicePublication.getLastTwoWeeksPublications(1,"date_ASsscc"));
    }

    @Test
    @DisplayName("T-0008 - Verificar que las publicaciones sean de las últimas dos semanas")
    void getLastTwoWeeksPublicationsOKTest() {
        //arrange

        when(mockUserRepository.findById(2)).thenReturn(buyer);
        when(mockPublicationRepository.getPublicationLastNDays(new ArrayList<Integer>(Arrays.asList(1)), 15)).thenReturn(new ArrayList<Publication>(Arrays.asList(publication1,publication2,publication3)));

        ProductTwoWeeksResponseDTO expected = new ProductTwoWeeksResponseDTO(2, new ArrayList<ListedPostDTO>(Arrays.asList(mapper.map(publication3, ListedPostDTO.class),mapper.map(publication2, ListedPostDTO.class),mapper.map(publication1, ListedPostDTO.class))));
        //act
        ProductTwoWeeksResponseDTO result = mockServicePublication.getLastTwoWeeksPublications(2, null);
        //assert
        assertEquals(expected, result);
    }
}