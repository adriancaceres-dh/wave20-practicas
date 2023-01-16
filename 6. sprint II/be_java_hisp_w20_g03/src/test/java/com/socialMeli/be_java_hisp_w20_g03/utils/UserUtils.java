package com.socialMeli.be_java_hisp_w20_g03.utils;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;

import java.util.ArrayList;
import java.util.List;

import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowersDTO;

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


    public static UserFollowersDTO buildListUserFollowedDtoDesc(){
        UserDTO userDto = new UserDTO(1536,"usuario4");
        UserDTO userDto1 = new UserDTO(4698,"usuario3");
        UserDTO userDto2 = new UserDTO(6631,"usuario2");
        return  new UserFollowersDTO(234,"usuario1",List.of(userDto,userDto1,userDto2));
    }
    public static UserFollowersDTO buildListUserFollowedDtoAsc(){
        UserDTO userDto4 = new UserDTO(1536,"usuario4");
        UserDTO userDto1 = new UserDTO(4698,"usuario3");
        UserDTO userDto2 = new UserDTO(6631,"usuario2");
        return  new UserFollowersDTO(234,"usuario1",List.of(userDto2,userDto1,userDto4));
    }

    public static User buildUser(){
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
        User usuario3 = User.builder()
                .userId(4698)
                .userName("usuario3")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario4 = User.builder()
                .userId(1536)
                .userName("usuario4")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        usuario1.getFollowers().add(usuario2);
        usuario2.getFollowed().add(usuario1);

        usuario1.getFollowers().add(usuario3);
        usuario3.getFollowed().add(usuario1);

        usuario1.getFollowers().add(usuario4);
        usuario4.getFollowed().add(usuario1);

        usuario2.getFollowers().add(usuario1);
        usuario1.getFollowed().add(usuario2);

        return usuario1;
    }

    public static User buildUserWithOneFollower(int userId1, int userId2){
        User user1 = User.builder()
                .userId(userId1)
                .userName("usuario1")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User user2 = User.builder()
                .userId(userId2)
                .userName("usuario2")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        user2.getFollowed().add(user1);
        user1.getFollowers().add(user2);

        return user1;
    }
}
