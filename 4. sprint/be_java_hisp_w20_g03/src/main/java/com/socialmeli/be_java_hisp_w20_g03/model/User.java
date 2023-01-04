package com.socialmeli.be_java_hisp_w20_g03.model;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private int userId;
    private String userName;
    private List<User> followers;
    private List<User> followed;
}
