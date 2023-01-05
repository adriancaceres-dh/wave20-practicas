package com.bootcamp.be_java_hisp_w20_g2_podio.service;

import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PromoPostCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PromoPostListByUserIdResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.User;
import com.bootcamp.be_java_hisp_w20_g2_podio.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2_podio.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2_podio.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2_podio.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g2_podio.utils.mapper.PostMapper;
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

    @Override
    public void createPromoPost(PromoPostDTO promoPostRequestDTO){
        if (promoPostRequestDTO.getDiscount() <= 0.0){
            throw new BadRequestException("Discount not valid");
        }
        if (!promoPostRequestDTO.isHasPromo()) {
            throw new BadRequestException("Must have promo");
        }
        User user = getUserOrThrow(promoPostRequestDTO.getUserId());

        Post newPromoPost = postMapper.toPromoPost(promoPostRequestDTO);
        user.addPost(newPromoPost);

        userRepository.save(user);
    }

    /**
     * It returns a count of promo posts by a given user (userId).
     * @param userId the id of the user to check.
     * @return PromoPostCountResponseDTO.
     */
    @Override
    public PromoPostCountResponseDTO getPromoProductsCountByUserId(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new BadRequestException("User not Found");
        }
        if (user.getPosts().size() == 0){
            throw new BadRequestException("This User don't have posts");
        }
        PromoPostCountResponseDTO promoPostCount = new PromoPostCountResponseDTO();
        promoPostCount.setUserId(user.getId());
        promoPostCount.setUserName(user.getUserName());
        promoPostCount.setPromoProductsCount((int) user.getPosts().stream().filter(Post::isHasPromo).count());
        return promoPostCount;
    }

    @Override
    public PromoPostListByUserIdResponseDTO getPromoPostListByUserId(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new BadRequestException("User not Found");
        }
        if (user.getPosts().size() == 0){
            throw new BadRequestException("This User don't have posts");
        }
        List<Post> hasPromo = user.getPosts().stream().filter(Post::isHasPromo).collect(Collectors.toList());
        if (hasPromo.size() == 0){
            throw new BadRequestException("This User don't have promo posts");
        }
        PromoPostListByUserIdResponseDTO promoList = new PromoPostListByUserIdResponseDTO(user.getId());
        promoList.setUserId(user.getId());
        promoList.setUserName(user.getUserName());
        user.getPosts().stream().filter(Post::isHasPromo)
                .forEach(post -> promoList.addPost(postMapper.toWithIdDTO(post, user.getId())));

        return promoList;
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

        user.getFollowing().forEach(followedUser -> {
                    followedUser.getPosts().stream()
                            .sorted(this.getDateComparator(order))
                            .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                            .forEach(post -> postResponse.addPost(postMapper.toWithIdDTO(post, followedUser.getId())));
                }
        );

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
