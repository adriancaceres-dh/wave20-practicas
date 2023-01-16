package com.socialMeli.be_java_hisp_w20_g03.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialMeli.be_java_hisp_w20_g03.dto.request.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class UserFollowedDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    private List<UserDTO> followed;
}
