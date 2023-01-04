package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserPostsCountDTO {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    private long promoPostCount;

}
