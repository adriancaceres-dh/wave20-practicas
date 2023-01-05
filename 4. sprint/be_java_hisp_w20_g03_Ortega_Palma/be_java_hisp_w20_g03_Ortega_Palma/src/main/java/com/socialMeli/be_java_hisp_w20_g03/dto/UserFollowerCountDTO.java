package com.socialMeli.be_java_hisp_w20_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowerCountDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    private int followers_count;
}
