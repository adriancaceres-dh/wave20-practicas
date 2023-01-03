package com.bootcamp.be_java_hisp_w20_g6_villamizar.service.Implement;

import com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.exception.FollowerExistsException;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.exception.FollowerNotFoundException;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.exception.UserExistsException;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.model.UserModel;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.service.Interface.IUserService;
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
    public boolean followUser( int idFollower,int idFollowed) {
        try{
            UserModel followed = userRepository.getUserById(idFollowed);
            UserModel follower = userRepository.getUserById(idFollower);

            ArrayList<Integer> fanFollowedList = follower.getFollowed();
            if(!fanFollowedList.contains(idFollowed)){
                fanFollowedList.add(idFollowed);
                followed.getFollowers().add(idFollower);
                return true;
            }else{
                throw new FollowerExistsException("Usuario ya esta siguiendo al vendedor.");
            }
        }catch(NullPointerException e){
            throw new UserExistsException("Usuario no existe.");
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
            throw new UserExistsException("Usuario no existe.");
        }
    }

    @Override
    public FollowersListResponseDto getFollowersList(int id, String order) {
        try{
            UserModel user = userRepository.getUserById(id);
            List<UserResponseDto> followers = getUserResponseDtos(user.getFollowers());
            if(order == null)   return new FollowersListResponseDto(id, user.getUser_name(), followers);
            return new FollowersListResponseDto(id, user.getUser_name(), orderReturnValues(followers, order));
        }catch(NullPointerException e){
            throw new UserExistsException("Usuario no existe.");
        }
    }

    @Override
    public FollowedListResponseDto getFollowedList(int id, String order) {
        try{
            UserModel user = userRepository.getUserById(id);
            List<UserResponseDto> followers = getUserResponseDtos(user.getFollowed());
            if(order == null)   return new FollowedListResponseDto(id, user.getUser_name(), followers);
            return new FollowedListResponseDto(id, user.getUser_name(), orderReturnValues(followers, order));
        }catch(NullPointerException e){
            throw new UserExistsException("Usuario no existe.");
        }
    }

    private List<UserResponseDto> getUserResponseDtos(List<Integer> userList) {
        List<UserResponseDto> followers = userList
                .stream()
                .map(u -> new UserResponseDto(u , userRepository.getUserById(u).getUser_name())).collect(Collectors.toList());
        return followers;
    }

    @Override
    public boolean unFollowUser(int idFollower, int idFollowed) {
        try{
            UserModel unFollowed = userRepository.getUserById(idFollowed);
            UserModel unFollower = userRepository.getUserById(idFollower);

            ArrayList<Integer> fanFollowedList = unFollower.getFollowed();
            int followIndex = fanFollowedList.indexOf(idFollowed);
            if(followIndex >= 0){
                fanFollowedList.remove(followIndex);
                unFollowed.getFollowers().remove((Integer) idFollower);
                return true;
            }else{
                throw new FollowerNotFoundException("Usuario no esta siguiendo al vendedor.");
            }
        }catch(NullPointerException e){
            throw new UserExistsException("Usuario no existe.");
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

        }
        return listToOrder;
    }
}
