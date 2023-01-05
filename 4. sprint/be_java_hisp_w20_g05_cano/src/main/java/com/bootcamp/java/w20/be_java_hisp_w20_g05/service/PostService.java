package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PromoPostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoPostCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.UserPostDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.UserProductDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_post_list.PromoPostListResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_post_list.UserPromoPostDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidPostDataException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.PromoPostNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Product;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
                .promo(false)
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

            Collection<UserPostDTO> postResults = new ArrayList<>();

            //Se guarda en una variable el signo por el que se debe multiplicar el int devuelto por el comparator si se quiere invertir el orden.
            int auxSign = (order!= null && order.equalsIgnoreCase("date_asc"))? 1 : -1;

            //Se ordenan usando el auxSign para definir el orde. Tambien mapean todos los posts a un DTO y se agregan al resultado.
            followedUsersPosts.stream()
                    .sorted((x,y) -> auxSign*(x.getDate().compareTo(y.getDate())))
                    .forEach(post ->
                    postResults.add(new UserPostDTO(post.getUserId(),
                            post.getId(),
                            post.getDate(),
                            new UserProductDTO(
                                    post.getProduct().getId(),
                                    post.getProduct().getName(),
                                    post.getProduct().getType(),
                                    post.getProduct().getBrand(),
                                    post.getProduct().getColor(),
                                    post.getProduct().getNotes()),
                            post.getCategory(),
                            post.getPrice())));

            result = new FollowedUsersPostsResponse(userInBd.getId(), postResults);

        } catch (IdNotFoundException ex){
            //Se descarta la excepcion del usuario no encontrado
        }

        return result;
    }

    // Crea un nuevo post con descuento valiendose del metodo para crear post normales y seteando has_promo y discount
    // por lo que no es necesario chequear por excepciones ya que están contempladas en el otro metodo.
    // Me parecio una buena forma de implementarlo para reusar codigo y al mismo tiempo respetar el desarollo grupal.
    public Post newPromoPost(PromoPostRequestDTO promoPostRequestDTO) {
        Post newPost = newPost(promoPostRequestDTO);
        newPost.setPromo(promoPostRequestDTO.isPromo());
        newPost.setDiscount(promoPostRequestDTO.getDiscount());
        return newPost;
    }

    // OMG, here we go
    //Este metodo devuelve una lista con los post con descuento del user valiendose en parte
    // de DTO ya implementados para el requerimiento US 0006
    @Override
    public PromoPostListResponse getPromoPostList(int userId) {
        User user = userService.getById(userId);
        Collection<Post> UserPromoPostList;

        //Obtenemos todos los post en promo del user
        UserPromoPostList= postRepository.getAll().stream().filter(post -> post.getUserId() == userId && post.isPromo()).collect(Collectors.toList());

        //Verificamos si nuestro user tiene algun post en promo sino tiramos una excepción.
        if (UserPromoPostList.isEmpty()) {
            throw new PromoPostNotFoundException(new MessageExceptionDTO("El usuario no tiene ningún post con descuento."));
        }

        //Para cada post lo pasamos user promo post dto que contiene info de post con promo y del producto y los ponemos en la lista
        //Esto hubiera quedado mucho mas lindo con un mapper, anotado para mejorarlo en proximas instancias
        Collection<UserPromoPostDTO> promoPosts = new ArrayList<>();
        UserPromoPostList.forEach(post -> promoPosts.add(new UserPromoPostDTO(
                user.getId(),
                post.getId(),
                post.getDate(),
                        new UserProductDTO( //Como UserPromoPostDTO hereda de UserPostDTO requiere un UserProductDTO
                                post.getProduct().getId(),
                                post.getProduct().getName(),
                                post.getProduct().getType(),
                                post.getProduct().getBrand(),
                                post.getProduct().getColor(),
                                post.getProduct().getNotes()
                        ),
                post.getCategory(),
                post.getPrice(),
                post.isPromo(),
                post.getDiscount()
                )));

        //Creamos el dto que lista los post promo del user y le agregamos la lista de post promo dto
        PromoPostListResponse response = new PromoPostListResponse(user.getId(), user.getUserName(), promoPosts);
        return response;
    }

    // Metodo que devuelve la cuenta de post con promo de un user
    public PromoPostCountDTO getPromoPostCount (int userId){
        User user= userService.getById(userId);
        //retornamos el dto del count de post en promo del user
        return new PromoPostCountDTO(user.getId(),user.getUserName(),(int)(postRepository.getAll().stream().filter(post -> post.getUserId() == userId && post.isPromo()).count()));
    }

}
