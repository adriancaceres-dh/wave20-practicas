package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;

public interface IPostService {

    /**
     * US 0005: Dar de alta una nueva publicación
     *
     * @param postCreateDto : body request para crear el post
     * @return String
     */
    String createPost(PostCreateDto postCreateDto);

    /**
     * US 0005: Calcula el id de una nueva publicacion
     *
     * @return int
     */
    int calculateId();

}
