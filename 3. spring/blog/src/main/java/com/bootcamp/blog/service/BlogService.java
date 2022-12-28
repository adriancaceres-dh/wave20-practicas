package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.OperationResultDTO;

import java.util.List;

public interface BlogService {
    OperationResultDTO create(BlogDTO blogDTO);

    BlogDTO get(long id);

    List<BlogDTO> listAll();
}
