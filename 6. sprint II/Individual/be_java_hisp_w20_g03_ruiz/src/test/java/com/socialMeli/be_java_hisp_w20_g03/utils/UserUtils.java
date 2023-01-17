package com.socialMeli.be_java_hisp_w20_g03.utils;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserExtendedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowedDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;

import java.util.ArrayList;
import java.util.List;

import com.socialMeli.be_java_hisp_w20_g03.dto.response.UserFollowersDTO;
import org.modelmapper.ModelMapper;

public class UserUtils {
    private static List<User> userList;
    static ModelMapper mapper = new ModelMapper();

    public static User getUserAddFollower(int usId) {
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


    public static UserFollowersDTO buildListUserFollowedDtoDesc() {
        UserDTO userDto = new UserDTO(1536, "usuario4");
        UserDTO userDto1 = new UserDTO(4698, "usuario3");
        UserDTO userDto2 = new UserDTO(6631, "usuario2");
        return new UserFollowersDTO(234, "usuario1", List.of(userDto, userDto1, userDto2));
    }

    public static UserFollowersDTO buildListUserFollowedDtoAsc() {
        UserDTO userDto4 = new UserDTO(1536, "usuario4");
        UserDTO userDto1 = new UserDTO(4698, "usuario3");
        UserDTO userDto2 = new UserDTO(6631, "usuario2");
        return new UserFollowersDTO(234, "usuario1", List.of(userDto2, userDto1, userDto4));
    }

    public static User buildUserWithFollowers() {
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

    public static User buildUserWithOneFollower(int userId1, int userId2) {
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

    public static UserFollowedDTO buildListUserFollowersDtoAsc() {
        UserDTO userDto4 = new UserDTO(1536, "usuario4");
        UserDTO userDto3 = new UserDTO(4698, "usuario3");
        UserDTO userDto2 = new UserDTO(234, "usuario2");
        return new UserFollowedDTO(6631, "usuario1", List.of(userDto2, userDto3, userDto4));
    }

    public static UserFollowedDTO buildListUserFollowersDtoDesc() {
        UserDTO userDto4 = new UserDTO(1536, "usuario4");
        UserDTO userDto3 = new UserDTO(4698, "usuario3");
        UserDTO userDto2 = new UserDTO(234, "usuario2");
        return new UserFollowedDTO(6631, "usuario1", List.of(userDto4, userDto3, userDto2));
    }

    public static User buildUserWithFollowed() {
        User usuario1 = User.builder()
                .userId(6631)
                .userName("usuario1")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario2 = User.builder()
                .userId(234)
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
        usuario2.getFollowers().add(usuario1);
        usuario1.getFollowed().add(usuario2);

        usuario3.getFollowers().add(usuario1);
        usuario1.getFollowed().add(usuario3);

        usuario4.getFollowers().add(usuario1);
        usuario1.getFollowed().add(usuario4);

        usuario1.getFollowers().add(usuario2);
        usuario2.getFollowed().add(usuario1);

        return usuario1;
    }

    public static List<UserExtendedDTO> getListUsers() {
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
        User usuario5 = User.builder()
                .userId(2236)
                .userName("usuario5")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario6 = User.builder()
                .userId(6932)
                .userName("usuario6")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();
        User usuario7 = User.builder()
                .userId(123)
                .userName("usuario7")
                .followers(new ArrayList<>())
                .followed(new ArrayList<>())
                .build();

        usuario1.getFollowers().add(usuario2);
        usuario2.getFollowed().add(usuario1);

        usuario1.getFollowers().add(usuario3);
        usuario3.getFollowed().add(usuario1);

        usuario1.getFollowers().add(usuario4);
        usuario4.getFollowed().add(usuario1);

        usuario2.getFollowers().add(usuario3);
        usuario3.getFollowed().add(usuario2);

        usuario2.getFollowers().add(usuario4);
        usuario4.getFollowed().add(usuario2);

        usuario1.getFollowers().add(usuario7);
        usuario7.getFollowed().add(usuario1);

        userList.add(usuario1);
        userList.add(usuario2);
        userList.add(usuario3);
        userList.add(usuario4);
        userList.add(usuario5);
        userList.add(usuario6);
        userList.add(usuario7);
        List<UserExtendedDTO> usersDTO = new ArrayList<>();
       userList.stream().forEach(u-> usersDTO.add(mapper.map(u, UserExtendedDTO.class)));

        return usersDTO;
    }
}
