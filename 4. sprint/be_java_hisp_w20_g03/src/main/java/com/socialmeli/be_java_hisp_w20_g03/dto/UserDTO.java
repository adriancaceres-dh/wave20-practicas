package com.socialmeli.be_java_hisp_w20_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
}
