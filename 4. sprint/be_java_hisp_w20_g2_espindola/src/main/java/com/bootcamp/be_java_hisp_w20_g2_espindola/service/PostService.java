package com.bootcamp.be_java_hisp_w20_g2_espindola.service;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.request.PostPromoRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostPromoListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_espindola.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2_espindola.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.User;
import com.bootcamp.be_java_hisp_w20_g2_espindola.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2_espindola.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2_espindola.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2_espindola.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g2_espindola.utils.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private PostMapper postMapper;

    /**
     * Creates a post and saves it in a user posts list.
     * @param postRequestDTO has the data for the post to be created.
     */
    @Override
    public void createPost(PostDTO postRequestDTO) {
        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post newPost = postMapper.toPost(postRequestDTO);
        user.addPost(newPost);

        userRepository.save(user);
    }

    /**
     * Creates a new promotion post and saves it in a user posts list.
     * @param postPromoRequestDTO has the data for the post to be created.
     */
    @Override
    public void createPromoPost(PostPromoRequestDTO postPromoRequestDTO) {
        User user = getUserOrThrow(postPromoRequestDTO.getUserId());

        Post newPostPromo = postMapper.toPostPromo(postPromoRequestDTO);

        if(newPostPromo.getDiscount() == 0.00) {
            throw new PostCreationException("Discount not valid");
        }

        user.addPost(newPostPromo);

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
                            .forEach(post -> postResponse.addPost(postMapper.toWithIdDTO(post, followedUser.getId())));
                });

        return postResponse;
    }

    /**
     * It returns the basic data from a user including the promotional posts count.
     * @param userId the id of the user to check.
     * @return PostPromoCountResponseDTO.
     */
    @Override
    public PostPromoCountResponseDTO countPromotionPosts(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new BadRequestException("User not found.");
        }

        int promosCount = (int) user.getPosts().stream().filter(Post::isHasPromo).count();

        return new PostPromoCountResponseDTO(userId, user.getUserName(), promosCount);
    }

    /**
     * It returns the basic data from a user including a list with the promotional posts.
     * @param userId the id of the user to check.
     * @return PostPromoListResponseDTO.
     */
    public PostPromoListResponseDTO listPromotionPosts(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found.");
        }

        List<PostPromoDTO> posts = user.getPosts().stream()
                .filter(Post::isHasPromo)
                .map(post -> postMapper.toPostPromoDTO(post, userId))
                .collect(Collectors.toList());

        return new PostPromoListResponseDTO(userId, user.getUserName(), posts);
    }

    private User getUserOrThrow(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new BadRequestException("The given userId not exist.");
        }

        return user;
    }

    private Comparator<Post> getDateComparator(Optional<String> order) {
        return order.orElse("date_desc").equals("date_desc") ?
                Comparator.comparing(Post::getDate).reversed()
                : Comparator.comparing(Post::getDate);
    }

}
