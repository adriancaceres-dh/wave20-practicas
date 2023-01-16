package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.exception.InvalidQueryParamValueException;
import com.bootcamp.be_java_hisp_w20_g1.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;
import com.bootcamp.be_java_hisp_w20_g1.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import com.bootcamp.be_java_hisp_w20_g1.util.TestUtil;
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
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    ModelMapper mapper = new ModelMapper();

    @Test
    @DisplayName("T8: obtiene lista de posteos de las ultimas dos semanas de los vendedores seguidos por un usuario")
    void whenAGivingAValidUser_ThenObtainPostsFromLastTwoWeeks() {

        //Arrange
        Set<Integer> followedIds = new HashSet<>();

        /*variables de test*/
        int idSeller = 1;
        int idUser = 2;
        int idFirstExpectedProduct = 1;
        int idSecondExpectedProduct = 2;
        String order = Parameter.getString("DateDesc");
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

    static private Stream<Arguments> orderByDateQueryParamProvider() {
        return Stream.of(arguments(Parameter.getString("DateAsc")), arguments(Parameter.getString("DateDesc")));
    }

    @ParameterizedTest
    @MethodSource("orderByDateQueryParamProvider")
    void whenGivingValidOrderParam_sortPostByDate_ShouldReturnList(String orderQueryParam) throws Exception {
        // Arrange
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        // Act
        List<PostResponseDto> actualPostResponseDtoList = postService.sortPostByDate(postResponseDtoList,orderQueryParam);

        // Assert
        assertEquals(postResponseDtoList, actualPostResponseDtoList);
    }

    @Test
    void whenGivingInvalidOrderParam_sortPostByDate_ShouldThrowInvalidQueryParamValueException() throws Exception {
        // Arrange
        String expectedErrorMessage = Parameter.getString("EX_InvalidOrder");
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();

        // Act && Assert
        InvalidQueryParamValueException InvalidQueryParamValueException = Assertions.assertThrows(InvalidQueryParamValueException.class, () -> postService.sortPostByDate(postResponseDtoList, Parameter.getString("NonExistentOrder")));
        assertEquals(expectedErrorMessage,InvalidQueryParamValueException.getMessage());
    }
}