package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.service;

import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.exception.InvalidQueryParamValueException;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.model.Post;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private ProductService productService;

    @Mock
    private UserService userService;

    @InjectMocks
    PostService postService;

    static private Stream<Arguments> orderByDateQueryParamProvider() {
        return Stream.of(arguments(Parameter.getString("DateAsc")), arguments(Parameter.getString("DateDesc")));
    }

    @ParameterizedTest
    @MethodSource("orderByDateQueryParamProvider")
    @DisplayName("T5: Se devuelve una lista cuando el parametro order es valido")
    void whenGivingValidOrderParam_sortPostByDate_ShouldReturnList(String orderQueryParam) throws Exception {
        // Arrange
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        // Act
        List<PostResponseDto> actualPostResponseDtoList = postService.sortPostByDate(postResponseDtoList, orderQueryParam);

        // Assert
        assertEquals(postResponseDtoList, actualPostResponseDtoList);
    }

    @Test
    @DisplayName("T5: Se lanza excepción cuando el parametro order es invalido")
    void whenGivingInvalidOrderParam_sortPostByDate_ShouldThrowInvalidQueryParamValueException() throws Exception {
        // Arrange
        String expectedErrorMessage = Parameter.getString("EX_InvalidOrder");
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        // Act && Assert
        InvalidQueryParamValueException InvalidQueryParamValueException = Assertions.assertThrows(InvalidQueryParamValueException.class, () -> postService.sortPostByDate(postResponseDtoList, Parameter.getString("NonExistentOrder")));
        assertEquals(expectedErrorMessage, InvalidQueryParamValueException.getMessage());
    }

    @Test
    @DisplayName("T6: Se obtiene lista de los post de un usuario ordenada ascendentemente")
    void whenGivingUnorderedList_sortPostByDateAscParam_ShouldReturnOrderedList() {
        // Arrange
        List<PostResponseDto> ascPost = TestUtil.ascPostResponseDTOBuilder(1, 2);
        List<PostResponseDto> shuffledList = TestUtil.ascPostResponseDTOBuilder(1, 2);
        Collections.shuffle(shuffledList);
        // Act
        List<PostResponseDto> actualList = postService.sortPostByDate(shuffledList, "date_asc");
        // Assert
        assertEquals(ascPost, actualList);

    }

    @Test
    @DisplayName("T6: Se obtiene lista de los post de un usuario ordenada descendentemente")
    void whenGivingUnorderedList_sortPostByDateDescParam_ShouldReturnOrderedList() {
        // Arrange
        List<PostResponseDto> ascPost = TestUtil.ascPostResponseDTOBuilder(1, 2);
        List<PostResponseDto> ascPostReverse = TestUtil.ascPostResponseDTOBuilder(1, 2);
        Collections.reverse(ascPostReverse);
        Collections.shuffle(ascPost);
        // Act
        List<PostResponseDto> actualList = postService.sortPostByDate(ascPost, "date_desc");

        // Assert
        assertEquals(ascPostReverse, actualList);

    }

    @Test
    @DisplayName("T8: Obtiene lista de posteos de las ultimas dos semanas de los vendedores seguidos por un usuario")
    void whenAGivingAValidUser_ThenObtainPostsFromLastTwoWeeks() {

        //Arrange
        Set<Integer> followedIds = new HashSet<>();

        /*variables de test*/
        int idSeller = 1;
        int idUser = 2;
        int idFirstExpectedProduct = 1;
        int idSecondExpectedProduct = 2;
        String order = Parameter.getString("DateAsc");
        followedIds.add(idSeller);

        List<Post> posts = TestUtil.getPostsByUserId(idSeller); //lista de posts con fechas validas
        posts.add(TestUtil.getPostFromFifteenDaysAgo()); //se agrega post con fecha invalida, el sistema deberia descartarla exitosamente

        ProductResponseDto firstExpectedProduct = TestUtil.getProductById(idFirstExpectedProduct);
        ProductResponseDto secondExpecterdProduct = TestUtil.getProductById(idSecondExpectedProduct);

        when(userService.validateUserExistById(idUser)).thenReturn(true); //se valida que el usuario exista
        when(userService.getUserFollowed(idUser)).thenReturn(followedIds); //devuelve la lista de ids de los vendedores a los cuales sigue el usuario
        when(postRepository.getPostsByUserId(idSeller)).thenReturn(posts); //devuelve la lista de posteos del vendedor
        /*devuelve los productos asociados a cada posteo.*/
        when(productService.getProductById(idFirstExpectedProduct)).thenReturn(firstExpectedProduct);
        when(productService.getProductById(idSecondExpectedProduct)).thenReturn(secondExpecterdProduct);

        //Act
        PostListResponseDto expected = TestUtil.getPostListResponseDto(idUser, idSeller);
        PostListResponseDto actual = postService.lastTwoWeeksPostsFromFollowers(idUser, order);

        //Assert
        assertEquals(expected, actual);
        assertFalse(actual.getPosts().containsAll(posts)); //Verifica que se haya descartado el post con fecha anterior a 14 dias
    }

}