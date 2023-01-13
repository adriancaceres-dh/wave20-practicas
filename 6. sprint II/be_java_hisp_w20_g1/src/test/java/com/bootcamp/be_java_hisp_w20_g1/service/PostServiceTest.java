package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;
import com.bootcamp.be_java_hisp_w20_g1.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import com.bootcamp.be_java_hisp_w20_g1.util.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    void lastTwoWeeksPostsFromFollowersTest() {
        //arrange
        int idUser = 2;
        int idSeller = 1;
        String order = "DESC";
        Set<Integer> followedIds = new HashSet<>();
        followedIds.add(idSeller);
        List<Post> posts = TestUtil.getPostsByUserId(idSeller);
        ProductResponseDto primerProducto = TestUtil.getProductById(1);
        ProductResponseDto segundoProducto = TestUtil.getProductById(2);

        //se valida que el usuario exista
        when(userService.validateUserExistById(idUser)).thenReturn(true);

        //devuelve la lista de ids de los vendedores a los cuales sigue el usuario
        when(userService.getUserFollowed(idUser)).thenReturn(followedIds);

        //devuelve la lista de posteos del vendedor
        when(postRepository.getPostsByUserId(idSeller)).thenReturn(posts);

        //devuelve los productos asociados a cada posteo.
        when(productService.getProductById(1)).thenReturn(primerProducto);
        when(productService.getProductById(2)).thenReturn(segundoProducto);

        PostListResponseDto expected = TestUtil.getPostListResponseDto(idUser, idSeller);
        // act
        PostListResponseDto results = postService.lastTwoWeeksPostsFromFollowers(idUser, order);

        //assert
        Assertions.assertEquals(expected, results);
    }

}