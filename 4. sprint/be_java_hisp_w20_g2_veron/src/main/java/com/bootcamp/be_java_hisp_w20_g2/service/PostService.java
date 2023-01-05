package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserPromoProductsCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserPromoProductsListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.exception.PostCreationException;
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
    public void createPost(PostDTO postRequestDTO,boolean promotion) {


        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post newPost = postMapper.toPost(postRequestDTO);

        // if the endpoint is promo-post
        if(promotion){
            if(postRequestDTO.getDiscount().isEmpty() || postRequestDTO.getHasPromo().isEmpty()){
                throw new PostCreationException("Need provide promotion data");
            }

            if(postRequestDTO.getHasPromo().isPresent() && !postRequestDTO.getHasPromo().get()){
                throw new PostCreationException("has_promo can´t be false");
            }
            if(postRequestDTO.getDiscount().isPresent() && postRequestDTO.getDiscount().get() <= 0){
                throw new PostCreationException("The discount should be > 0");

            }
            newPost.setHasPromo(postRequestDTO.getHasPromo());
            newPost.setDiscount(postRequestDTO.getDiscount());
        }
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
                            .forEach(post -> postResponse.addPost(postMapper.toWithIdDTO(post, followedUser.getId())));
                });

        return postResponse;
    }

    /**
     * It returns a counter of products in promotion from an user given by userId
     * @param userId the id of the user to check.
     * @return UserPromoProductsCountResponseDTO.
     */
    @Override
    public UserPromoProductsCountResponseDTO getPromotionProductsQuantity(int userId) {
        User user = getUserOrThrow(userId);
        int promoProductsCount = (int) user.getPosts().stream().filter(x->
                (x.getHasPromo().isPresent() && x.getHasPromo().get() )
                        && (x.getDiscount().isPresent() && x.getDiscount().get()>0) ).count();
        return new UserPromoProductsCountResponseDTO(user.getId(),user.getUserName(),promoProductsCount);
    }

    /**
     * It returns a list of products in promotion from an user given by userId
     * @param userId the id of the user to check.
     * @return UserPromoProductsListResponseDTO.
     */
    @Override
    public UserPromoProductsListResponseDTO getPromotionProductsList(int userId) {
        User user = getUserOrThrow(userId);
        List<Post> promoProductsList = user.getPosts().stream().filter(x->
                (x.getHasPromo().isPresent() && x.getHasPromo().get() )
                        && (x.getDiscount().isPresent() && x.getDiscount().get()>0) )
                .collect(Collectors.toList());

        List<PostDTO> promoProductsDTOList = promoProductsList.stream().map(x->postMapper.toDTO(x,userId))
                .collect(Collectors.toList());
        return new UserPromoProductsListResponseDTO(user.getId(),user.getUserName(),promoProductsDTOList);
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
