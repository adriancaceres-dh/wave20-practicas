package com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response;

import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.PostDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.PostPromoDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPromoPostListDto {

    private int userId;
    private String userName;
    private List<PostPromoDto> postPromoList;

}
