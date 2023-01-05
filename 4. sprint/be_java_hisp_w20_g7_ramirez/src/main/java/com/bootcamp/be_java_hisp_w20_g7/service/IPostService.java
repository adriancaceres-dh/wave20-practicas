package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.PostCountProductDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.PostListPromoDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;

public interface IPostService {

    /**
     * US 0005: Dar de alta una nueva publicación
     *US 0010: Llevar a cabo la publicación de un nuevo producto en promoción
     * @param postCreateDto : body request para crear el post
     * @return String
     */
    String createPost(PostCreateDto postCreateDto);

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
     * US 0011 Obtener la cantidad de productos en promoción de un determinado vendedor
     * @param userId
     * @return
     */
    PostCountProductDto postCountProduct(int userId);

    /**
     * US 0012Obtener un listado de todos los productos en promoción de un determinado vendedor
     * @param userId
     * @return
     */
    PostListPromoDto listPromo(int userId);

}
