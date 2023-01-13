package com.socialmeli.be_java_hisp_w20_g8.services.posts;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
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

    @Test
    public void findPostByIdSellerTestAscendentOrder() {
        List<PostDTO> listPostExpectd = new ArrayList<>();

        Set<Seller> sellers = new HashSet<>();
        sellers.addAll(Set.of(
                new Seller(5, "seller3", new HashSet<>(), new HashSet<>() {
                    {
                        add(4);
                        add(2);
                    }
                }),
                new Seller(5, "seller4", new HashSet<>(), new HashSet<>() {
                    {
                        add(1);
                        add(3);
                    }
                }),
                new Seller(8, "seller5", new HashSet<>(), new HashSet<>())));
        Set<PostDTO> setPost = new HashSet<>();

        PostDTO post1 = PostDTO.builder().post_id(1).user_id(5).date(LocalDate.now().minusDays(4)).build();
        PostDTO post2 = PostDTO.builder().post_id(2).user_id(5).date(LocalDate.now().minusDays(3)).build();
        PostDTO post3 = PostDTO.builder().post_id(3).user_id(7).date(LocalDate.now().minusDays(2)).build();
        PostDTO post4 = PostDTO.builder().post_id(4).user_id(6).date(LocalDate.now().minusDays(1)).build();

        listPostExpectd.add(post1);
        listPostExpectd.add(post2);
        listPostExpectd.add(post3);
        listPostExpectd.add(post4);

        setPost.add(post1);
        setPost.add(post2);
        setPost.add(post3);
        setPost.add(post4);

        when(postRepository.findPostsById(new HashSet<Integer>() {
            {
                add(1);
                add(3);
            }
        })).thenReturn(new HashSet<PostDTO>() {
            {
                add(post1);
                add(post3);
            }
        });
        when(postRepository.findPostsById(new HashSet<Integer>() {
            {
                add(4);
                add(2);
            }
        })).thenReturn(new HashSet<PostDTO>() {
            {
                add(post4);
                add(post2);
            }
        });
        when(postRepository.findPostsById(new HashSet<>())).thenReturn(new HashSet<PostDTO>());

        // Act
        ResponsePostDTO actual = postService.findPostByIdSeller(sellers, 1, "date_asc");
        // Assert
        Assertions.assertEquals(listPostExpectd, actual.getPosts());
        ;

    }

    @Test
    public void findPostByIdSellerTestDescendentOrder() {
        List<PostDTO> listPostExpectd = new ArrayList<>();

        Set<Seller> sellers = new HashSet<>();
        sellers.addAll(Set.of(
                new Seller(5, "seller3", new HashSet<>(), new HashSet<>() {
                    {
                        add(4);
                        add(2);
                    }
                }),
                new Seller(5, "seller4", new HashSet<>(), new HashSet<>() {
                    {
                        add(1);
                        add(3);
                    }
                }),
                new Seller(8, "seller5", new HashSet<>(), new HashSet<>())));
        Set<PostDTO> setPost = new HashSet<>();

        PostDTO post1 = PostDTO.builder().post_id(1).user_id(5).date(LocalDate.now().minusDays(4)).build();
        PostDTO post2 = PostDTO.builder().post_id(2).user_id(5).date(LocalDate.now().minusDays(3)).build();
        PostDTO post3 = PostDTO.builder().post_id(3).user_id(7).date(LocalDate.now().minusDays(2)).build();
        PostDTO post4 = PostDTO.builder().post_id(4).user_id(6).date(LocalDate.now().minusDays(1)).build();

        listPostExpectd.add(post4);
        listPostExpectd.add(post3);
        listPostExpectd.add(post2);
        listPostExpectd.add(post1);

        setPost.add(post1);
        setPost.add(post2);
        setPost.add(post3);
        setPost.add(post4);

        when(postRepository.findPostsById(new HashSet<Integer>() {
            {
                add(1);
                add(3);
            }
        })).thenReturn(new HashSet<PostDTO>() {
            {
                add(post1);
                add(post3);
            }
        });
        when(postRepository.findPostsById(new HashSet<Integer>() {
            {
                add(4);
                add(2);
            }
        })).thenReturn(new HashSet<PostDTO>() {
            {
                add(post4);
                add(post2);
            }
        });
        when(postRepository.findPostsById(new HashSet<>())).thenReturn(new HashSet<PostDTO>());

        // Act
        ResponsePostDTO actual = postService.findPostByIdSeller(sellers, 1, "date_desc");
        // Assert
        Assertions.assertEquals(listPostExpectd, actual.getPosts());

    }
}
