package com.socialmeli.be_java_hisp_w20_g8.services.posts;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponsePostDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import com.socialmeli.be_java_hisp_w20_g8.repositories.posts.IPostRepository;
import com.socialmeli.be_java_hisp_w20_g8.services.products.IProductService;


/**
 * This test is used for check the sorting options for the post service and check the result of the method against a mock
 * @author: Adrian Isaac Gomez Ocon
 */
@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    IProductService productService;
    @Mock
    IPostRepository postRepository;
    @Mock
    IPersonRepository personRepository;

    @InjectMocks
    PostService postService;

    private ResponsePostDTO responsePostDTO;

    private List<PostDTO> listPostDTO;
    private Set<PostDTO> setPostDTO;
    private Set<Seller> sellerSet;
    private Set<Integer> idPost;


    public PostServiceTest() {
        listPostDTO = new ArrayList<>();
        setPostDTO = new HashSet<>();
        sellerSet = new HashSet<>();

        // setting postDTO for testing
        PostDTO postDTO1 = PostDTO.builder().post_id(1).user_id(5).date(LocalDate.now().minusDays(4)).build();
        PostDTO postDTO2 = PostDTO.builder().post_id(2).user_id(5).date(LocalDate.now().minusDays(3)).build();
        PostDTO postDTO3 = PostDTO.builder().post_id(3).user_id(7).date(LocalDate.now().minusDays(2)).build();
        PostDTO postDTO4 = PostDTO.builder().post_id(4).user_id(6).date(LocalDate.now().minusDays(1)).build();

        listPostDTO.add(postDTO1);
        listPostDTO.add(postDTO2);
        listPostDTO.add(postDTO3);
        listPostDTO.add(postDTO4);

        setPostDTO.add(postDTO1);
        setPostDTO.add(postDTO2);
        setPostDTO.add(postDTO3);
        setPostDTO.add(postDTO4);

        responsePostDTO = ResponsePostDTO.builder().id_user(1).posts(listPostDTO).build();

        // setting sellers for testing
        sellerSet.addAll(Set.of(
                new Seller(5, "seller3", new HashSet<>(), new HashSet<>() {
                    {
                        add(4);
                        add(2);
                    }
                }),
                new Seller(6, "seller4", new HashSet<>(), new HashSet<>() {
                    {
                        add(1);
                        add(3);
                    }
                }),
                new Seller(8, "seller5", new HashSet<>(), new HashSet<>())));

    }

    @Test
    @DisplayName("T-0005-> Check ascending order of post by date")
    public void findPostByIdSellerTestAscendentOrder() {
        List<PostDTO> listPostExpectd = new ArrayList<>();

//        List with the correct order of posts
        listPostExpectd.add(listPostDTO.get(0));
        listPostExpectd.add(listPostDTO.get(1));
        listPostExpectd.add(listPostDTO.get(2));
        listPostExpectd.add(listPostDTO.get(3));

//        Returning the set of post of each seller
        when(postRepository.findPostsById(new HashSet<Integer>() {
            {
                add(1);
                add(3);
            }
        })).thenReturn(new HashSet<PostDTO>() {
            {
                add(listPostDTO.get(0));
                add(listPostDTO.get(2));
            }
        });
        when(postRepository.findPostsById(new HashSet<Integer>() {
            {
                add(4);
                add(2);
            }
        })).thenReturn(new HashSet<PostDTO>() {
            {
                add(listPostDTO.get(3));
                add(listPostDTO.get(1));
            }
        });
        when(postRepository.findPostsById(new HashSet<>())).thenReturn(new HashSet<PostDTO>());

        // Act
        ResponsePostDTO actual = postService.findPostByIdSeller(sellerSet, 1, "date_asc");
        // Assert
        Assertions.assertEquals(listPostExpectd, actual.getPosts());

    }

    @Test
    @DisplayName("T-0005-> Check descending order of post by date")
    public void findPostByIdSellerTestDescendentOrder() {
        List<PostDTO> listPostExpectd = new ArrayList<>();

//        List with the correct order of posts
        listPostExpectd.add(listPostDTO.get(3));
        listPostExpectd.add(listPostDTO.get(2));
        listPostExpectd.add(listPostDTO.get(1));
        listPostExpectd.add(listPostDTO.get(0));

//        Returning the set of post of each seller
        when(postRepository.findPostsById(new HashSet<Integer>() {
            {
                add(1);
                add(3);
            }
        })).thenReturn(new HashSet<PostDTO>() {
            {
                add(listPostDTO.get(0));
                add(listPostDTO.get(2));
            }
        });
        when(postRepository.findPostsById(new HashSet<Integer>() {
            {
                add(4);
                add(2);
            }
        })).thenReturn(new HashSet<PostDTO>() {
            {
                add(listPostDTO.get(3));
                add(listPostDTO.get(1));
            }
        });
        when(postRepository.findPostsById(new HashSet<>())).thenReturn(new HashSet<PostDTO>());

        // Act
        ResponsePostDTO actual = postService.findPostByIdSeller(sellerSet, 1, "date_desc");
        // Assert
        Assertions.assertEquals(listPostExpectd, actual.getPosts());

    }

    @Test
    @DisplayName("T-0004-> Find post by id seller order asc test")
    void findPostByIdSellerTestAsc(){
        String orderOption = "date_asc";

        when(postRepository.findPostsById(anySet())).thenReturn(setPostDTO);

        ResponsePostDTO responseExpected = postService.findPostByIdSeller(sellerSet, 1, orderOption);

        assertNotNull(responseExpected);
        assertDoesNotThrow(() ->postService.findPostByIdSeller(sellerSet,1, orderOption));

    }
    @Test
    @DisplayName("T-0004-> Find post by id seller order desc test")
    void findPostByIdSellerTestDesc(){
        String orderOption = "date_desc";

        when(postRepository.findPostsById(anySet())).thenReturn(setPostDTO);

        ResponsePostDTO responseExpected = postService.findPostByIdSeller(sellerSet, 1, orderOption);

        assertNotNull(responseExpected);
        assertDoesNotThrow(() ->postService.findPostByIdSeller(sellerSet,1, orderOption));

    }

    @Test
    @DisplayName("T-0004-> Find post by id seller order invalid test")
    void findPostByIdSellerOrderInvalidTest(){
        String orderOption = "not_sorting_option";
        String expectedErrorMessage = "Invalid sorting option";

        when(postRepository.findPostsById(anySet())).thenReturn(setPostDTO);

        Exception exception = assertThrows(InvalidArgumentException.class,()-> postService.findPostByIdSeller(sellerSet,1, orderOption));

        assertEquals(expectedErrorMessage,exception.getMessage());
    }
}
