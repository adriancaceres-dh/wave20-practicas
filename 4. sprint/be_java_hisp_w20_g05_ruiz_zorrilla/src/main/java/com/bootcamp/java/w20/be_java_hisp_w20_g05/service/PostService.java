package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PromoPostRequest;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserPostDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserProductDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidPostDataException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Product;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostService implements IPostService{
    private int post_id = 36;
    @Autowired
    public IPostRepository postRepository;
    @Autowired
    public IUserService userService;
    @Override
    public List<PostResponseDTO> filterBy(String name) {
        return null;
    }

    @Override
    public Post newPost(PostRequestDTO postRequestDTO) {
        Post newPost = Post.builder()
                .id(++post_id)
                .category(postRequestDTO.getCategory())
                .price(postRequestDTO.getPrice())
                .userId(postRequestDTO.getUserId())
                .discount(0)
                .IsDiscounted(false)
                .date(postRequestDTO.getDate())
                .userId(postRequestDTO.getUserId())
                .product(Product.builder()
                            .id(postRequestDTO.getProduct().getProduct_id())
                            .name(postRequestDTO.getProduct().getProduct_name())
                            .brand(postRequestDTO.getProduct().getBrand())
                            .color(postRequestDTO.getProduct().getColor())
                            .notes(postRequestDTO.getProduct().getNotes())
                            .type(postRequestDTO.getProduct().getType())
                            .build()
                        )
                .build();
        if(!postRepository.add(newPost)) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));
        // --> Pendiente chequear esta excepcion, validar datos para que dispare.
        return newPost;
    }

    //Creates post with a discount.
    public void newPromoPost(PromoPostRequest request) {
        Post newPost = Post.builder()
                .id(++post_id)
                .category(request.getCategory())
                .price(request.getPrice())
                .userId(request.getUserId())
                .discount(request.getDiscount())
                .date(request.getDate())
                .IsDiscounted(request.isHasDiscount())
                .userId(request.getUserId())
                .product(Product.builder()
                        .id(request.getProduct().getProduct_id())
                        .name(request.getProduct().getProduct_name())
                        .brand(request.getProduct().getBrand())
                        .color(request.getProduct().getColor())
                        .notes(request.getProduct().getNotes())
                        .type(request.getProduct().getType())
                        .build()
                )
                .build();
        if(!postRepository.add(newPost)) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));


    }

    //Requerimiento 006 + 009
    public FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order){
        FollowedUsersPostsResponse result = new FollowedUsersPostsResponse();

        try
        {
            //Busca el usuario por un id especificado. Puede devolver una excepcion si el usuario no existe.
            User userInBd = userService.getById(userId);

            Collection<Post> followedUsersPosts = new ArrayList<>();

            //Agrega a una lista todos los posts hechos por los usuarios cuyos ids se encuentran en la lista de usuarios seguidos del usuario provisto.
            userInBd.getFollowing()
                    .stream().forEach(followedUsersIds -> followedUsersPosts
                            .addAll(postRepository
                                    .filterByUserId(followedUsersIds)
                                    .stream().filter(post -> post
                                            .getDate()
                                            .isAfter(LocalDate.now().minusDays(14)))
                                    .collect(Collectors.toList())));

            Collection<FollowedUserPostDTO> postResults = new ArrayList<>();

            //Se guarda en una variable el signo por el que se debe multiplicar el int devuelto por el comparator si se quiere invertir el orden.
            int auxSign = (order!= null && order.equalsIgnoreCase("date_asc"))? 1 : -1;

            //Se ordenan usando el auxSign para definir el orde. Tambien mapean todos los posts a un DTO y se agregan al resultado.
            followedUsersPosts.stream()
                    .sorted((x,y) -> auxSign*(x.getDate().compareTo(y.getDate())))
                    .forEach(post ->
                    postResults.add(new FollowedUserPostDTO(post.getUserId(),
                            post.getId(),
                            post.getDate(),
                            new FollowedUserProductDTO(post.getProduct().getId(), post.getProduct().getName(), post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(), post.getProduct().getNotes()),
                            post.getCategory(),
                            post.getPrice())));

            result = new FollowedUsersPostsResponse(userInBd.getId(), postResults);

        } catch (IdNotFoundException ex){
            //Se descarta la excepcion del usuario no encontrado
        }

        return result;
    }
}
