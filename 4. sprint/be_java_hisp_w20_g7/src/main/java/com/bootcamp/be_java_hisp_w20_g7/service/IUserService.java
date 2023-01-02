package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;

public interface IUserService {


    /**
     * US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     *
     * @param userId id del usuario
     * @return UserFollowersCountDto : usuario mas el numero de seguidores
     */
    UserFollowersCountDto userFollowersCount(int userId);

    /**
     * US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor
     *
     * @param userId: id del ususario
     * @return UserFollowersDto: objeto que trae los datos del usuario y los datos de sus seguidores
     */
    UserFollowersDto userFollowers(int userId);

    /**
     * US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario
     *
     * @param userId: id del ususario
     * @return UserFollowedDto: objeto que trae los datos del usuario y los usuarios que sigue
     */
    UserFollowedDto userFollowed(int userId);


    /**
     * US 0006 Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas
     *
     * @param userId : id del usuario
     * @return UserPostFollowedDto : retorna una lista de post de los usuarios que sigue el ususario
     */
    UserPostFollowedDto userPostFollowed(int userId);


}
