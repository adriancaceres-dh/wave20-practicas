package com.bootcamp.be_java_hisp_w20_g2_idalgo.service;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.CategoryDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostWithPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response.PromosAmountDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response.UserIdentifiedListDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.model.User;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.utils.mapper.PostMapper;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.utils.sort.PostStreamSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public UserIdentifiedListDTO<PostWithIdDTO> sendLastPostOfFollowed(int userId, Optional<String> order) {
        User user = getUserOrThrow(userId);

        List<PostWithIdDTO> posts = user.getFollowing().stream()
                .map(User::getPosts)
                .flatMap(Collection::stream)
                .sorted(PostStreamSorter.getSortCriteria(order.orElse("date_desc")))
                .map(postMapper::toWithIdDTO)
                .collect(Collectors.toList());

        return new UserIdentifiedListDTO<>(userId, posts);
    }

    /**
     * Creates a post with a promotion and persists it.
     *
     * @param postRequestDTO has the data for the post to be created.
     * @return message confirming successful operation
     */
    @Override
    public String createPromoPost(PromoPostRequestDTO postRequestDTO) {
        User user = getUserOrThrow(postRequestDTO.getPost().getUserId());

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
    public UserIdentifiedListDTO<PostWithPromoDTO> listPromosFromUser(int userId, Optional<String> order) {
        User user = getUserOrThrow(userId);

        List<PostWithPromoDTO> posts = user.getPosts().stream()
                .filter(Post::isHasPromo)
                .sorted(PostStreamSorter.getSortCriteria(order.orElse("date_desc")))
                .map(postMapper::toWithPromoDTO)
                .collect(Collectors.toList());

        return new UserIdentifiedListDTO<>(userId, posts);
    }

    /**
     * List posts in promotion
     *
     * @param order optional string representing the sorting criteria
     * @return list of posts that have promotions
     */
    @Override
    public List<PostWithPromoDTO> listPromos(Optional<String> order) {
        return postRepository.findAllByHasPromo(true).stream()
                .sorted(PostStreamSorter.getSortCriteria(order.orElse("date_desc")))
                .map(postMapper::toWithPromoDTO)
                .collect(Collectors.toList());
    }

    /**
     * List valid categories with their respective codes
     *
     * @return list of categories
     */
    @Override
    public List<CategoryDTO> listCategories() {
        return categoryRepository.findAll().stream()
                .map(c -> new CategoryDTO(c.getCode(), c.getName()))
                .collect(Collectors.toList());
    }

    private User getUserOrThrow(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new BadRequestException("The given userId not exist.");
        }

        return user;
    }

}
