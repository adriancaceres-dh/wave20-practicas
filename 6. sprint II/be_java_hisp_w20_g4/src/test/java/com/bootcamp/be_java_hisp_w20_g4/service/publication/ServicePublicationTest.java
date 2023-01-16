package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.model.Publication;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.publication.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g4.utils.TestUtils;
import org.apache.catalina.mapper.Mapper;
import org.junit.jupiter.api.DisplayName;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.PublicationDTO;
import com.bootcamp.be_java_hisp_w20_g4.model.*;
import com.bootcamp.be_java_hisp_w20_g4.repository.publication.IPublicationRepository;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

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
    @DisplayName("USS 006 - Verificar  las publicaciones de las ultimas 2 semanas en orden ascendente")
    void getPublicationsOrderAscOKTest() {
        //Arrange
        Product product1 = new Product(
                12, "twingo",
                "gris", "no es un ferrari pero casi",
                "de carrera", "REANULT");
        Category category = new Category(100, "autos");

        Publication publication1 = new Publication(LocalDate.of(2023, 1, 9),
                100.00, product1, category, 10);

        Publication publication2 = new Publication(LocalDate.of(2022, 12, 19),
                100.00, product1, category, 10);
        Publication publication3 = new Publication(LocalDate.of(2021, 6, 9),
                100.00, product1, category, 10);
        HashMap<Integer, Publication> publicationHashMap = new HashMap<>();
        publicationHashMap.put(1, publication1);
        publicationHashMap.put(2, publication2);
        publicationHashMap.put(3, publication3);
        Seller seller = new Seller(10, "messi");
        HashMap<Integer, User> followeds = new HashMap<>();
        seller.setPublications(publicationHashMap);
        seller.setFollowers(followeds);
        
        Buyer buyer = new Buyer(1, "rodri");
        buyer.addUserToMyFollowedList(seller);

        when(mockUserRepository.findById(anyInt())).thenReturn(buyer);

        when(mockPublicationRepository.getPublicationLastNDays(Collections.singletonList(seller.getUser_id()), 15))
                .thenReturn(publicationHashMap.values().stream().sorted(Comparator.comparing(Publication::getDate)).collect(Collectors.toList()));

        List<ListedPostDTO> listedPostDTOList = publicationHashMap.values().stream().sorted(Comparator.comparing(Publication::getDate)).map(publication -> mockServicePublication.mapper.map(publication, ListedPostDTO.class)).collect(Collectors.toList());

        ProductTwoWeeksResponseDTO productExpected = new ProductTwoWeeksResponseDTO(buyer.getUser_id(), listedPostDTOList);
        //Act
        ProductTwoWeeksResponseDTO productActual = mockServicePublication.getLastTwoWeeksPublications(1, "date_asc");
        //Assert
        assertEquals(productExpected, productActual);
    }

    @Test
    @DisplayName("US 006 - Verificar publicaciones ultimas 2 semanas orden descendente")
    void getPublicationsOrderDescOKTest() {
        //Arrange
        Product product1 = new Product(
                6, "casio",
                "dorado", "no es un rolex pero casi",
                "reloj", "CASIO");
        Category category = new Category(50, "relojes");

        Publication publication1 = new Publication(LocalDate.of(2021, 2, 12),
                1000.00, product1, category, 10);

        Publication publication2 = new Publication(LocalDate.of(2021, 11, 21),
                10000.00, product1, category, 10);

        Publication publication3 = new Publication(LocalDate.of(2022, 11, 21),
                10000.00, product1, category, 10);

        HashMap<Integer, Publication> publicationHashMap = new HashMap<>();
        publicationHashMap.put(1, publication1);
        publicationHashMap.put(2, publication2);
        publicationHashMap.put(3, publication3);

        Seller seller = new Seller(10, "diego");
        HashMap<Integer, User> followeds = new HashMap<>();
        seller.setPublications(publicationHashMap);
        seller.setFollowers(followeds);

        Buyer buyer = new Buyer(11, "angel");
        buyer.addUserToMyFollowedList(seller);

        when(mockUserRepository.findById(anyInt())).thenReturn(buyer);

        when(mockPublicationRepository.getPublicationLastNDays(Collections.singletonList(seller.getUser_id()), 15))
                .thenReturn(publicationHashMap.values().stream().collect(Collectors.toList()));

        List<ListedPostDTO> listedPostDTOList = new ArrayList<>();
                // publicationHashMap.values().stream().map(publication -> mockServicePublication.mapper.map(publication, ListedPostDTO.class)).collect(Collectors.toList());
        listedPostDTOList.add(mockServicePublication.mapper.map(publication3, ListedPostDTO.class));
        listedPostDTOList.add(mockServicePublication.mapper.map(publication2, ListedPostDTO.class));
        listedPostDTOList.add(mockServicePublication.mapper.map(publication1, ListedPostDTO.class));
        ProductTwoWeeksResponseDTO productExpected = new ProductTwoWeeksResponseDTO(buyer.getUser_id(), listedPostDTOList);
        //Act
        ProductTwoWeeksResponseDTO productActual = mockServicePublication.getLastTwoWeeksPublications(11, "date_desc");
        //Assert
        assertEquals(productExpected, productActual);
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
        Product product = new Product(1, "producto", "rojo", "", "", "");
        Category category = new Category(1, "categoria");
        Seller seller1 = new Seller(1, "Vendedor1");
        Publication publication1 = new Publication(LocalDate.of(2022, 1, 14), 100.0, product, category, 1);
        Publication publication2 = new Publication(LocalDate.of(2022, 2, 13), 200.0, product, category, 1);
        Seller seller2 = new Seller(2, "Vendedor2");
        Publication publication3 = new Publication(LocalDate.of(2023, 1, 10), 300.0, product, category, 2);

        Buyer buyer = new Buyer(3, "Comprador");
        buyer.addUserToMyFollowedList(seller1);
        buyer.addUserToMyFollowedList(seller2);

        when(mockUserRepository.findById(3)).thenReturn(buyer);
        when(mockPublicationRepository.getPublicationLastNDays(new ArrayList<Integer>(Arrays.asList(1, 2)), 15)).thenReturn(new ArrayList<Publication>(Arrays.asList(publication1,publication3)));

        ProductTwoWeeksResponseDTO expected = new ProductTwoWeeksResponseDTO(3, new ArrayList<ListedPostDTO>(Arrays.asList(TestUtils.mapper.map(publication3, ListedPostDTO.class), TestUtils.mapper.map(publication1, ListedPostDTO.class))));

        ProductTwoWeeksResponseDTO result = mockServicePublication.getLastTwoWeeksPublications(3, null);

        assertEquals(expected, result);
    }
}