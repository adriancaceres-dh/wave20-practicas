package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.PromoPostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPromoPostDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;

public interface IPostService {

    /**
     * US 0005: Dar de alta una nueva publicación
     *
     * @param postCreateDto : body request para crear el post
     * @return String
     */
    String createPost(PostCreateDto postCreateDto);

    /**
     * US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
     *
     * @param promoPostCreateDto: body request para crear el post con promoción
     * @return String
     */
    String createPromoPost(PromoPostCreateDto promoPostCreateDto);

    /**
     * US 0005: Calcula el id de una nueva publicacion
     *
     * @return int
     */
    void calculateId(Post post);

    /**
     * US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
     *
     * @param userId : body id del usuario
     * @param order  : String que especifica el orden por fecha en el que se despliegan los posts
     * @return UserPostFollowedDto: retorna el id del ususario y una lista de los post de los usuarios seguidos en las ultimas 2 semanas oredeandos por fecha
     */
    UserPostFollowedDto postUsersFollowed(int userId, String order);

    /**
     *
     * @param userId: body id del usuario
     * @return UserPromoPostDto: retorna una lista de los post del usuario con promocion
     */
    UserPromoPostDto promoPostUser(int userId);

}
