package com.bootcamp._excepciones_p1_vivo.service;

import com.bootcamp._excepciones_p1_vivo.dto.request.RequestBlogDto;
import com.bootcamp._excepciones_p1_vivo.dto.response.ResponseBlogDto;

import java.util.List;

public interface IBlogService {
    public Long addBlogInId(RequestBlogDto blogDto);
    public ResponseBlogDto getBlogById (Long id);
    public List<ResponseBlogDto> getAll();

}
