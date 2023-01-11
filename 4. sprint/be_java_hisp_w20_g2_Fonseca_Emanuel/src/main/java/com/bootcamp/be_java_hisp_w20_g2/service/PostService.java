package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
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
import java.util.LinkedList;
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
     * Creates a post promo and saves it in a user posts list.
     * @param postRequestDTO has the data for the post to be created.
     */
    @Override
    public void createPromoPost(PostPromoDTO postRequestDTO) {
        if(!postRequestDTO.isHasPromo()){
            throw new PostCreationException("El indicador de promo no puede ser falso.");
        } else if (postRequestDTO.getDiscount() <= 0.0) {
            throw new PostCreationException("No ha aplicado a un descuento valido para el producto que ha seleccionado como promo.");
        }
        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post newPost = postMapper.toPromoPost(postRequestDTO);
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
     * It returns a PostPromoCountResponseDTO.
     * @param userId the id of the user to check the number of their Posts in Promo.
     * @return PostPromoCountResponseDTO.
     */
    public PostPromoCountResponseDTO countProductPromoOfUser(Optional<Integer> userId){
        if(!userId.isPresent()){
            throw new BadRequestException("El campo identificador de usuario no puede estar vacío");
        }else if(!userRepository.exists(userId.get())){
            throw new BadRequestException("El usuario no existe");
        }
        User user = userRepository.findOne(userId.get());

        List<Post> postPromo = user.getPosts().stream().filter(x -> x.isHasPromo()==true).collect(Collectors.toList());;

        return new PostPromoCountResponseDTO(userId.get(), user.getUserName(), postPromo.size());
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