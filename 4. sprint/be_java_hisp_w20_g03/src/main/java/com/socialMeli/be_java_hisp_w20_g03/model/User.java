package com.socialMeli.be_java_hisp_w20_g03.model;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private int user_id;
    private String user_name;
    private List<User> followers;
    private List<User> followed;
}
