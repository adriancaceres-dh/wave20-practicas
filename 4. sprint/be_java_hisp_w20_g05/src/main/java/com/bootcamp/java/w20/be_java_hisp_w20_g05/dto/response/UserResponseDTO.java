package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String userName;
}
