package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PromoPostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.*;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserPostDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserProductDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.AlreadyPostedPromoException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidPostDataException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.NotPromotionException;
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

    public PromoProductListDTO listPromoByUser (int id){
        User user = userService.getById(id);

        List<PromoPostResponseDTO> productList= postRepository.getAll().stream()
                .filter(post -> post.getId()==id && post.getDiscount()>0)
                .map(post -> PromoPostResponseDTO.builder()
                        .user_id(post.getUserId())
                        .post_id(post.getId())
                        .date(post.getDate())
                        .product(PromoProductResponseDTO.builder()
                                .product_id(post.getProduct().getId())
                                .product_name(post.getProduct().getName())
                                .type(post.getProduct().getType())
                                .brand(post.getProduct().getBrand())
                                .color(post.getProduct().getColor())
                                .notes(post.getProduct().getNotes())
                                .build())
                        .category(post.getCategory())
                        .price(post.getPrice())
                        .has_promo(post.getDiscount()>0)
                        .discount(post.getDiscount())
                        .build())
                .collect(Collectors.toList());

        return new PromoProductListDTO(id, user.getUserName(), productList);
    }

    public boolean isPosted(PromoPostRequestDTO post){
        return postRepository.getAll().stream()
                .anyMatch(p -> p.getProduct().getId() == post.getProduct().getProduct_id());
    }

    public String addPromoPost(PromoPostRequestDTO post){
        if(!post.isHas_promo()){
            throw new NotPromotionException(new MessageExceptionDTO("No esta promocionado."));
        }else if(isPosted(post)){
            throw new AlreadyPostedPromoException(new MessageExceptionDTO("Promocion ya publicada."));
        }else{
            /* Para crear el id tuve inconvenientes, ya que los posts al estar en un Set no se puede
            acceder al ultimo elemento agregado directamente para sumarle 1 a su id. No me parecia bien
            usar el .size() por si llegara a haber elementos borrados. Podia usar un metodo que itere el set
            y consiga el maximo para sumarle 1 pero me parecio ineficiente y generaba conflicto con la
            solucion que encontro un compañero de usar el post_id que esta aca en el service, aunque no
            estoy convencido de que sea una buena solucion. Quiza haya que haber planeado mejor el repositorio
            desde el inicio. */
            postRepository.add(new Post(++post_id,post.getCategory(),post.getUser_id(),post.getDate(),post.getPrice(),post.getDiscount(),new Product(post.getProduct().getProduct_id(),post.getProduct().getProduct_name(),post.getProduct().getBrand(),post.getProduct().getType(),post.getProduct().getColor(),post.getProduct().getNotes())));
            return "Añadido con exito!";
        }
    }

    public PromoProductCountDTO countPromoByUser (int id){
        User user = userService.getById(id);
        int count = (int) postRepository.getAll().stream()
                .filter(post -> post.getId()==id && post.getDiscount()>0)
                .count();
        return new PromoProductCountDTO(id, count, user.getUserName());
    }

    @Override
    public Post newPost(PostRequestDTO postRequestDTO) {
        Post newPost = Post.builder()
                .id(++post_id)
                .category(postRequestDTO.getCategory())
                .price(postRequestDTO.getPrice())
                .userId(postRequestDTO.getUserId())
                .discount(0)
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

    //Requerimiento 006 + 009
    public FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order){
        User userInBd = userService.getById(userId);
        FollowedUsersPostsResponse result = new FollowedUsersPostsResponse();

        try
        {
            Collection<Post> followedUsersPosts = new ArrayList<>();

            userInBd.getFollowing()
                    .stream().forEach(followedUsersIds -> followedUsersPosts
                            .addAll(postRepository
                                    .filterByUserId(followedUsersIds)
                                    .stream().filter(post -> post
                                            .getDate()
                                            .isAfter(LocalDate.now().minusDays(14)))
                                    .collect(Collectors.toList())));

            Collection<FollowedUserPostDTO> postResults = new ArrayList<>();

            int auxSign = (order!= null && order.equalsIgnoreCase("date_asc"))? 1 : -1;
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

        }

        return result;
    }
}
