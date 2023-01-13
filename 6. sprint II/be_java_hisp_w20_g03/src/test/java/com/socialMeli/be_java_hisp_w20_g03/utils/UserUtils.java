package com.socialMeli.be_java_hisp_w20_g03.utils;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {
    private static List<User> userList;
public static User getUserAddFollower(int usId){
     userList = new ArrayList<>();
    User usuario1 = User.builder()
            .userId(234)
            .userName("usuario1")
            .followers(new ArrayList<>())
            .followed(new ArrayList<>())
            .build();
    User usuario2 = User.builder()
            .userId(6631)
            .userName("usuario2")
            .followers(new ArrayList<>())
            .followed(new ArrayList<>())
            .build();
    userList.add(usuario1);
    userList.add(usuario2);
   User userResponse = userList.stream()
           .filter(user -> user.getUserId() == usId)
           .findAny()
           .orElse(null);

   return userResponse;

}

}
