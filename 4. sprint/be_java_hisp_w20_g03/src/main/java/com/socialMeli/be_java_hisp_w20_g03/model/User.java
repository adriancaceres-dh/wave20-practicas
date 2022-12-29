package com.socialMeli.be_java_hisp_w20_g03.model;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private int user_id;
    private String user_name;
    private List<User> followers;
    private List<User> followed;
}
