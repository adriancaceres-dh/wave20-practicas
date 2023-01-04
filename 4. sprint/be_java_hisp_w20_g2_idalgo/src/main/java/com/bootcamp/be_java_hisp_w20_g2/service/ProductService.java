package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromosAmountDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g2.utils.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private PostMapper postMapper;

    /**
     * Creates a post and persists it.
     *
     * @param postRequestDTO has the data for the post to be created.
     * @return message confirming successful operation
     */
    @Override
    public String createPost(PostDTO postRequestDTO) {
        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post newPost = postMapper.toPost(postRequestDTO);
        user.addPost(newPost);

        userRepository.save(user);
        return "Post created";
    }

    /**
     * Creates a post and saves it in a user posts list.
     *
     * @param userId is the id of the user whose followers' posts will be taken into account.
     * @param order  is the string representing the sorting criteria that will be used
     */
    @Override
    public PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order) {
        User user = getUserOrThrow(userId);

        List<PostWithIdDTO> posts = user.getFollowing().stream()
                .map(User::getPosts)
                .flatMap(Collection::stream)
                .sorted(getDateComparator(order))
                .map(postMapper::toWithIdDTO)
                .collect(Collectors.toList());

        return new PostResponseDTO(userId, posts);
    }

    /**
     * Creates a post with a promotion and persists it.
     *
     * @param postRequestDTO has the data for the post to be created.
     * @return message confirming successful operation
     */
    @Override
    public String createPromoPost(PromoPostRequestDTO postRequestDTO) {
        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post post = postMapper.toPost(postRequestDTO);
        user.addPost(post);

        userRepository.save(user);
        return "Promo post created";
    }

    /**
     * Get the amount of posts in promotion the user has.
     *
     * @param userId id of the user.
     * @return amount of posts.
     */
    @Override
    public PromosAmountDTO getAmountOfPromos(int userId) {
        User user = getUserOrThrow(userId);

        long amountOfPromos = user.getPosts().stream().filter(Post::isHasPromo).count();

        return new PromosAmountDTO(userId, user.getUserName(), amountOfPromos);
    }

    /**
     * List promos submitted by a user
     *
     * @param userId id of the seller
     * @param order  optional string representing the sorting criteria
     * @return list of posts
     */
    @Override
    public PostResponseDTO listPromosFromUser(int userId, Optional<String> order) {
        User user = getUserOrThrow(userId);

        List<PostWithIdDTO> posts = user.getPosts().stream()
                .filter(Post::isHasPromo)
                .sorted(getDateComparator(order))
                .map(postMapper::toWithIdDTO)
                .collect(Collectors.toList());

        return new PostResponseDTO(userId, posts);
    }

    /**
     * @param order optional string representing the sorting criteria
     * @return list of posts that have promotions
     */
    @Override
    public List<PostWithIdDTO> listPromos(Optional<String> order) {
        return postRepository.findByHasPromo(true).stream()
                .sorted(getDateComparator(order))
                .map(postMapper::toWithIdDTO)
                .collect(Collectors.toList());
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
