package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2.model.Category;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;


@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    /**
     * Creates a post and saves it in a user posts list.
     * @param postRequestDTO has the data for the post to be created.
     */
    @Override
    public void createPost(PostRequestDTO postRequestDTO) {
        User user = userRepository.findOne(postRequestDTO.getUserId());
        if (user == null) {
            throw new PostCreationException("The given user id does not exist.");
        }

        Post newPost = toObject(postRequestDTO);
        user.addPost(newPost);

        userRepository.save(user);
    }
    /**
     * It returns a list of all the posts made by users that a given user (userId) follows in the last two weeks.
     * @param userId the id of the user to check.
     * @param order receives a String ("date_asc" or "date_desc") to order the list of posts.
     * @return PostResponseDTO.
     */
    @Override
    public PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new BadRequestException("The given userId not exist.");
        }

        PostResponseDTO postResponse = new PostResponseDTO(userId);

        user.getFollowing()
                .forEach(followedUser -> {
                    followedUser.getPosts().stream()
                            .sorted(this.getDateComparator(order))
                            .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                            .forEach(post -> postResponse.addPost(post, followedUser.getId()));
                });

        return postResponse;
    }

    private Comparator<Post> getDateComparator(Optional<String> order) {
        return order.orElse("date_desc").equals("date_desc") ?
                Comparator.comparing(Post::getDate).reversed()
                : Comparator.comparing(Post::getDate);
    }
    /**
     * It takes the product data from postRequestDTO to return a Post object.
     * @param postRequestDTO has the product data to build the Post.
     * @return Post.
     */
    private Post toObject(PostRequestDTO postRequestDTO) {
        ProductDTO productDTO = postRequestDTO.getProduct();
        Product product = new Product(
                productDTO.getProductId(),
                productDTO.getProductName(),
                productDTO.getType(),
                productDTO.getBrand(),
                productDTO.getColor(),
                productDTO.getNotes());

        Category category = categoryRepository.findByCode(postRequestDTO.getCategory())
                .orElseThrow(() -> new PostCreationException("Invalid category code"));

        return new Post(postRequestDTO.getDate(), product, category, postRequestDTO.getPrice());
    }

}
