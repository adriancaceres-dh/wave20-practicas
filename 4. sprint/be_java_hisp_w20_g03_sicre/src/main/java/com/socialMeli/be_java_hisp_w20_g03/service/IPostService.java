package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.PostDiscountCountDto;
import com.socialMeli.be_java_hisp_w20_g03.dto.PostDiscountDto;

import java.util.List;

public interface IPostService {
    String addPost(PostDTO postDTO);
    List<PostDTO> getPost(int userId, String order);
    public PostDiscountCountDto getDiscountCountPostByUserId(int user_id);
    public String addDiscountPost(PostDiscountDto postDiscountDto);
    public List<PostDiscountDto> getDiscountPostByUserId(int user_id);
}
