package com.bootcamp._excepciones_p1_vivo.repository;

import com.bootcamp._excepciones_p1_vivo.dto.request.RequestBlogDto;
import com.bootcamp._excepciones_p1_vivo.model.Blog;

import java.time.LocalDate;
import java.util.HashMap;

public interface IBlogRepository {

    public Long addInId(Long id, Blog blog);
    public HashMap<Long,Blog> getAll();

}
