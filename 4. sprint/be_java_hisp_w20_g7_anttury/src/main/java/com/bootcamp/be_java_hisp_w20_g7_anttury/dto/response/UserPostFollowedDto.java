package com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response;

import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPostFollowedDto {

    private int userId;
    private List<PostDto> posts;


}
