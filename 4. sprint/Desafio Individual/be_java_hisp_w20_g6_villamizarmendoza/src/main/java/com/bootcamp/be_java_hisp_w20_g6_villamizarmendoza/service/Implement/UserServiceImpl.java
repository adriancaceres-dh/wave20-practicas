package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.service.Implement;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.exception.*;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.model.UserModel;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean followUser(int user_id, int userToFollow_id) {
        if(user_id == userToFollow_id) throw new SameUserException("El usuario no se puede seguir a si mismo.");
        UserModel userToFollow = getUserById(userToFollow_id);
        UserModel user = getUserById(user_id);

        ArrayList<Integer> userFollowedList = user.getFollowed();
        if (!userFollowedList.contains(userToFollow_id)) {
            user.getFollowed().add(userToFollow_id);
            userToFollow.getFollowers().add(user_id);
            return true;
        } else {
            throw new FollowerExistsException("Usuario ya esta siguiendo al vendedor.");
        }
    }

    /**
     *
     * @param id
     * @return el usuario del id
     * @throws UserNotFoundException cuando no se encuentra al usuario
     */
    public UserModel getUserById(int id) {
        UserModel user = userRepository.getUserById(id);
        if (user == null)
            throw new UserNotFoundException("Usuario no existe");
        return user;
    }

    @Override
    public FollowersCountResponseDto getFollowersCount(int id) {
        UserModel user = getUserById(id);
        return new FollowersCountResponseDto(id, user.getUser_name(), user.getFollowers().size());
    }

    @Override
    public FollowersListResponseDto getFollowersList(int id, String order) {
        UserModel user = getUserById(id);
        List<UserResponseDto> followers = getUserResponseDtos(user.getFollowers());
        if (order == null)
            return new FollowersListResponseDto(id, user.getUser_name(), followers);
        return new FollowersListResponseDto(id, user.getUser_name(), orderReturnValues(followers, order));
    }

    @Override
    public FollowedListResponseDto getFollowedList(int id, String order) {
        UserModel user = getUserById(id);
        List<UserResponseDto> followers = getUserResponseDtos(user.getFollowed());
        if (order == null)
            return new FollowedListResponseDto(id, user.getUser_name(), followers);
        return new FollowedListResponseDto(id, user.getUser_name(), orderReturnValues(followers, order));
    }

    private List<UserResponseDto> getUserResponseDtos(List<Integer> userList) {
        List<UserResponseDto> followers = userList
                .stream()
                .map(u -> new UserResponseDto(u, getUserById(u).getUser_name()))
                .collect(Collectors.toList());
        return followers;
    }

    @Override
    public boolean unFollowUser(int user_id, int userToUnfollow_id) {
        UserModel userToUnfollow = getUserById(userToUnfollow_id);
        UserModel user = getUserById(user_id);

        ArrayList<Integer> fanFollowedList = user.getFollowed();
        int followIndex = fanFollowedList.indexOf(userToUnfollow_id);
        if (followIndex >= 0) {
            user.getFollowed().remove(followIndex);
            userToUnfollow.getFollowers().remove((Integer) user_id);
            return true;
        } else {
            throw new FollowerNotFoundException("Usuario no esta siguiendo al vendedor.");
        }
    }

    @Override
    public List<UserResponseDto> orderReturnValues(List<UserResponseDto> listToOrder, String orderBy) {

        switch (orderBy) {
            case "name_asc":
                listToOrder.sort(Comparator.comparing(UserResponseDto::getUser_name));
                break;
            case "name_desc":
                listToOrder.sort(Comparator.comparing(UserResponseDto::getUser_name).reversed());
                break;
            default: 
                throw new InvalidParamException("Argumento invalido");

        }
        return listToOrder;

    }
}
