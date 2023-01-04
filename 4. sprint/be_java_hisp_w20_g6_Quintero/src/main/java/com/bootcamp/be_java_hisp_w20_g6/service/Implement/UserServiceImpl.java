package com.bootcamp.be_java_hisp_w20_g6.service.Implement;

import com.bootcamp.be_java_hisp_w20_g6.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g6.exception.*;
import com.bootcamp.be_java_hisp_w20_g6.model.UserModel;
import com.bootcamp.be_java_hisp_w20_g6.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g6.service.Interface.IUserService;
import org.apache.catalina.User;
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
    public boolean followUser( int userId,int userToFollowId) {
        UserModel userToFollow = getUserById(userToFollowId);
        UserModel user = getUserById(userId);

        ArrayList<Integer> userFollowedList = user.getFollowed();
        if (!userFollowedList.contains(userToFollowId)) {
            user.getFollowed().add(userToFollowId);
            userToFollow.getFollowers().add(userId);
            return true;
        } else {
            throw new FollowerExistsException("Usuario ya esta siguiendo al vendedor.");
        }
    }

    public UserModel getUserById(int id){
        UserModel user = userRepository.getUserById(id);
        if(user == null) throw new UserNotFoundException("Usuario no existe");
        return user;  
    }

    @Override
    public FollowersCountResponseDto getFollowersCount(int id) {
        try{
            UserModel user = userRepository.getUserById(id);
            return new FollowersCountResponseDto(id, user.getUser_name(), user.getFollowers().size());

        }catch(NullPointerException e){
            throw new UserNotFoundException("Usuario no existe.");
        }
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
        try{
            UserModel user = userRepository.getUserById(id);
            List<UserResponseDto> followers = getUserResponseDtos(user.getFollowed());
            if(order == null)   return new FollowedListResponseDto(id, user.getUser_name(), followers);
            return new FollowedListResponseDto(id, user.getUser_name(), orderReturnValues(followers, order));
        }catch(NullPointerException e){
            throw new UserNotFoundException("Usuario no existe.");
        }
    }

    private List<UserResponseDto> getUserResponseDtos(List<Integer> userList) {
        List<UserResponseDto> followers = userList
                .stream()
                .map(u -> new UserResponseDto(u , userRepository.getUserById(u).getUser_name())).collect(Collectors.toList());
        return followers;
    }

    @Override
    public boolean unFollowUser(int userId, int userToUnfollowId) {
        UserModel userToUnfollow = getUserById(userToUnfollowId);
        UserModel user = getUserById(userId);

        ArrayList<Integer> fanFollowedList = user.getFollowed();
        int followIndex = fanFollowedList.indexOf(userToUnfollowId);
        if (followIndex >= 0) {
            user.getFollowed().remove(followIndex);
            userToUnfollow.getFollowers().remove((Integer) userId);
            return true;
        } else {
            throw new FollowerNotFoundException("Usuario no esta siguiendo al vendedor.");
        }
    }

    @Override
    public List<UserResponseDto> orderReturnValues(List<UserResponseDto> listToOrder, String orderBy) {

        switch(orderBy){
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
