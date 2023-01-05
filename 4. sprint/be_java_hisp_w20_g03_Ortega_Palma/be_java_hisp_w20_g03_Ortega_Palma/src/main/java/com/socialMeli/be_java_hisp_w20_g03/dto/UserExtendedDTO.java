package com.socialMeli.be_java_hisp_w20_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class UserExtendedDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    private List<UserDTO> followers;
    private List<UserDTO> followed;
}
