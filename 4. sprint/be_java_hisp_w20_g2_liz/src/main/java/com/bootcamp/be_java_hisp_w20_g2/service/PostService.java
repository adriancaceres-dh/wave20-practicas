package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromoPostCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromoPostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g2.utils.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


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
     * Creates a "promo post" and saves it in a user posts list.
     * @param promoPostRequestDTO has the data for the "promo post" to be created.
     */
    @Override
    public void createPromoPost(PromoPostRequestDTO promoPostRequestDTO) {
        User user = getUserOrThrow(promoPostRequestDTO.getUserId());

        Post post = postMapper.toPost(promoPostRequestDTO);
        user.addPost(post);

        userRepository.save(user);
    }

    /**
     * Gets a count of the "promo posts" made by a given user (userId) .
     * @param userId has the data for the "promo post" to be created.
     * @return PromoPostCountResponseDTO;
     */
    @Override
    public PromoPostCountResponseDTO getPromoPostCount(int userId) {
        User user = getUserOrThrow(userId);
        long promoPostCount = user.getPosts().stream().filter(Post::isHasPromo).count();
        return new PromoPostCountResponseDTO(userId, user.getUserName(), promoPostCount);
    }
    /**
     * Gets a list of the "promo posts" made by a given user (userId).
     * @param userId user id of the user whose  promo posts" list is being retrieved.
     */
    @Override
    public PromoPostListResponseDTO getPromoPostList(int userId) {
        User user = getUserOrThrow(userId);
        List<Post> promoPostList = user.getPosts().stream().filter(Post::isHasPromo).toList();
        return new PromoPostListResponseDTO(userId, user.getUserName(), promoPostList);
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
