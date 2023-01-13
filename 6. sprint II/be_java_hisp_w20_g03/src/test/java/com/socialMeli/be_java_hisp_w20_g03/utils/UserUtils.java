package com.socialMeli.be_java_hisp_w20_g03.utils;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtils {

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

        return usuario1;
    }
}
